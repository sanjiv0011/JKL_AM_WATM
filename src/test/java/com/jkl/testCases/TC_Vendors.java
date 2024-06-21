package com.jkl.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.jkl.ReUseAble.PageObject.ReUseAbleElement;
import com.jkl.pageObject.PO_AssetConfigurationsPage;
import com.jkl.pageObject.PO_CustomersPage;
import com.jkl.pageObject.PO_HomePage;
import com.jkl.pageObject.PO_Inner_DashboardPage;
import com.jkl.pageObject.PO_LoginPage;
import com.jkl.pageObject.PO_TenantsPage;
import com.jkl.pageObject.PO_VendorsPage;

public class TC_Vendors extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_Vendors() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_VendorsPage po_vendor;
	public PO_Inner_DashboardPage innerDashboard;

	// VARIABLE VENDOR DETAILS
	String vendorName = "Tata Croma Product";
	String vendorEmail = faker.internet().emailAddress();
	String vendorPhoneNumber = "917894654123";
	String vendorWhatsAppNumber = "917894560123";
	String vendorWebsite = "https://www.google.com/";
	String vendorType = "Individual"; //"Agency"

	// VARIABLE VENDOR ADDRESS
	String vendorAddress1 = faker.address().streetAddress();
	String vendorAddress2 = faker.address().fullAddress();
	String vendorCity = faker.address().cityName();
	String vendorPostalCode = "799854"; // text or number;
	String vendorState = faker.address().state();
	String vendorCountry = faker.address().country(); // text or number;
	String vendoroverview = faker.lorem().sentence();

	// VARIABLE VENDOR CONTACT
	String vendorContactName = faker.name().fullName();
	String vendorContactNumber = "917894561230";
	String vendorContactEmail = faker.internet().emailAddress();
	String vendorContactComment = faker.lorem().sentence();

	String vendorName_Update = vendorName + " Updated";

	String searchKey = vendorName;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnThreeDot = true;
	boolean wantToclickOnFindSearckKey = false;
	String searchKey_assetConfiguration = null;

	// TO ADD
	@Test(priority = 1)
	public void test_AddVendor() throws Throwable {
		po_vendor = callMeBeforePerformAnyAction();
		po_vendor.addOrEditVendor(vendorName, vendorEmail, vendorPhoneNumber, vendorWhatsAppNumber, vendorWebsite,vendorType,
				vendorAddress1, vendorAddress2, vendorCity, vendorPostalCode, vendorState, vendorCountry,
				vendoroverview, vendorContactName, vendorContactNumber, vendorContactEmail, vendorContactComment,
				searchKey, searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
	}

	// TO EDIT
	@Test(priority = 2)
	public void test_EditVendor() throws Throwable {
		po_vendor = callMeBeforePerformAnyAction();
		po_vendor.addOrEditVendor(vendorName_Update, vendorEmail, vendorPhoneNumber, vendorWhatsAppNumber, vendorWebsite,vendorType,
				vendorAddress1, vendorAddress2, vendorCity, vendorPostalCode, vendorState, vendorCountry,
				vendoroverview, vendorContactName, vendorContactNumber, vendorContactEmail, vendorContactComment,
				searchKey, searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
		searchKey = vendorName_Update;
	}

//	// TO ARCHIVE
//	@Test(priority = 3)
//	public void test_ArchiveAssetConfiguration() throws Throwable {
//		test_FindDataFromListAndClickOnThreeDotButton();
//		assetConfiration.archiveAssetConfiguration();
//	}
//
//	// TO RESTORE
//	@Test(priority = 4)
//	public void test_RestoreAssetConfiguration() throws Throwable {
//		test_FindDataFromListAndClickOnThreeDotButton();
//		assetConfiration.restoreAssetConfiguration();
//	}

	// TO FIND THE ASSET CATEGORY FROM THE LIST AND CLICK ON THE THREE DOT ACTION
	// BUTTON
	// @Test(priority = 10)
	public void test_FindDataFromListAndClickOnThreeDotButton() throws Throwable {
		po_vendor = callMeBeforePerformAnyAction();
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
		po_vendor.findDataFromRowListAndClickOnThreeDot(vendorName_Update, searchKey_assetConfiguration,
				searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT AND ASSUME_ROLE
	public PO_VendorsPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		innerDashboard = new PO_Inner_DashboardPage(driver);
		Thread.sleep(1000);
		innerDashboard.clickOnMenuVendors();
		Thread.sleep(3000);
		return new PO_VendorsPage(driver);
	}

}
