package com.jkl.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.jkl.ReUseAble.PageObject.ReUseAbleElement;
import com.jkl.pageObject.PO_AssetCategoriesPage;
import com.jkl.pageObject.PO_CustomersPage;
import com.jkl.pageObject.PO_HomePage;
import com.jkl.pageObject.PO_Inner_DashboardPage;
import com.jkl.pageObject.PO_LoginPage;
import com.jkl.pageObject.PO_TenantsPage;

public class TC_AssetCategory extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_AssetCategory() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_CustomersPage cp;
	public PO_TenantsPage tp;
	public TC_AssumeRole assumeRole = new TC_AssumeRole();
	public PO_AssetCategoriesPage assetCategory;
	public PO_Inner_DashboardPage innerDashboard;

	// VARIABLE
	String assetCategoryName = "Monitor";
	String assetCategoryCode = "MTR";
	String assetCategoryDescription = faker.lorem().sentence();
	int[] assingmentTypesNumber = { 1, 2, 3 };
	String assetCategoryImage = "";
	String searchKey_assetCategory = assetCategoryName;
	String AssetCategoryName_Update = assetCategoryName + " Updated";

	int searchKeyColumnIndex_assetCategory = 2;
	boolean wantToclickOnFindSearckKey_assetCategory = false;
	boolean wantToClickOnThreeDot_assetCategroy = true;

	// TO ADD
	// @Test(priority = 1)
	public void test_AddAssetCategory() throws Throwable {
		assetCategory = callMeBeforePerformAnyAction();
		assetCategory.addOrEditAssetCategory(assetCategoryName, assetCategoryCode, assetCategoryDescription,
				assingmentTypesNumber, assetCategoryImage, searchKey_assetCategory, searchKeyColumnIndex_assetCategory,
				wantToClickOnThreeDot_assetCategroy, wantToclickOnFindSearckKey_assetCategory);
	}

	// TO EDIT
	// @Test(priority = 2)
	public void test_EditAssetCategory() throws Throwable {
		assetCategory = callMeBeforePerformAnyAction();
		assetCategory.addOrEditAssetCategory(AssetCategoryName_Update, assetCategoryCode, assetCategoryDescription,
				assingmentTypesNumber, assetCategoryImage, "Monitor Updated", searchKeyColumnIndex_assetCategory,
				wantToClickOnThreeDot_assetCategroy, wantToclickOnFindSearckKey_assetCategory);
		searchKey_assetCategory = AssetCategoryName_Update;
	}

	// TO VIEW
	@Test(priority = 3)
	public void test_ViewAssetCategory() throws Throwable {
		test_FindAssetCategoryFromListAndClickOnThreeDotButton();
		assetCategory.viewAssetCategory();
	}

	// TO DEACTIVATE
	@Test(priority = 4)
	public void test_DeactivateAssetCategory() throws Throwable {
		test_FindAssetCategoryFromListAndClickOnThreeDotButton();
		cp.deactivateCustomer();
	}

	// TO ACTIVATE
	@Test(priority = 5)
	public void test_ActivateAssetCategory() throws Throwable {
		test_FindAssetCategoryFromListAndClickOnThreeDotButton();
		cp.activateCustomer();
	}

	// TO ARCHIVE
	@Test(priority = 6)
	public void test_ArchiveAssetCategory() throws Throwable {
		test_FindAssetCategoryFromListAndClickOnThreeDotButton();
		cp.archiveCustomer();
	}

	// TO RESTORE
	@Test(priority = 7)
	public void test_RestoreAssetCategory() throws Throwable {
		test_FindAssetCategoryFromListAndClickOnThreeDotButton();
		cp.restoreCustomer();
	}
	
	
	

	// TO FIND THE ASSET CATEGORY FROM THE LIST AND CLICK ON THE THREE DOT ACTION BUTTON
	// @Test(priority = 10)
	public void test_FindAssetCategoryFromListAndClickOnThreeDotButton() throws Throwable {
		assetCategory = callMeBeforePerformAnyAction();
		// logger.info("1");
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTraceElement[2].getMethodName();
		// logger.info("2");
		if (callerMethodName.contains("test_Restore")) {
			// logger.info("3");
			ReUseAbleElement ruae = new ReUseAbleElement(driver);
			// logger.info("callerMethodName: "+callerMethodName);
			ruae.clickONBtnTooltip_RU("Show Archived", driver);
			// logger.info("4");
		}
		// logger.info("5");
		assetCategory.findAssetCategoryFromRowListAndClickOnThreeDot(customerName, searchKey, searchKeyColumnIndex,
				wantToClickOnThreeDot, wantToClickOnSearchKey);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT AND ASSUME_ROLE
	public PO_AssetCategoriesPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		innerDashboard = new PO_Inner_DashboardPage(driver);
		Thread.sleep(1000);
		innerDashboard.clickOnMenuAssetCategories();
		Thread.sleep(3000);
		return new PO_AssetCategoriesPage(driver);
	}

	// ---------------------------------ASSUME A ROLE----------------------------//
	// VARIABLES TO ASSUME A ROLE
	String tenantName = "Tata Steel 4"; // "WESTWOOD_"+faker.name().firstName();
	String customerName = "Tata Groups";
	String searchKey = customerName;
	String assureRoleAsTenant = searchKey;
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;

	// TO ASSUME A ROLE AS TENANTS
	// @BeforeClass
	public PO_Inner_DashboardPage assumeRole() throws Throwable {
		assumeRole.viewCustomers(customerName, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
				wantToClickOnSearchKey, tenantName);
		Thread.sleep(1000);
		searchKey = tenantName;

		assumeRole.assumeRoleAsTenant(tenantName, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
				wantToClickOnSearchKey);
		Thread.sleep(2000);
		logger.info("Role Assumed Successfully... & Hand over driver to InnerDashboard");
		return new PO_Inner_DashboardPage(driver);
	}
}
