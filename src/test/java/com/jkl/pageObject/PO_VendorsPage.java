package com.jkl.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.jkl.ReUseAble.PageObject.ReUseAbleElement;
import com.jkl.actions.Action_Edit;
import com.jkl.pageObject.pageLocators.PL_VendorsPage;
import com.jkl.projectUtility.FindThreeDotAndClick;

public class PO_VendorsPage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// CONSTRUCTOR CREATION
	public PO_VendorsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ======START======PAGE OBJECT AND ACTOIN METHODS==========//

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_NAME)
	@CacheLookup
	public WebElement field_VENDOR_NAME;

	public void setVendorName(String vendorName) throws InterruptedException {
		field_VENDOR_NAME.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_NAME.sendKeys(Keys.DELETE);
		field_VENDOR_NAME.sendKeys(vendorName);
		Thread.sleep(500);
		logger.info("Entered vendorName");

	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_EMAIL)
	@CacheLookup
	public WebElement field_VENDOR_EMAIL;

	public void setVendorEmail(String vendorEmail) throws InterruptedException {
		field_VENDOR_EMAIL.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_EMAIL.sendKeys(Keys.DELETE);
		field_VENDOR_EMAIL.sendKeys(vendorEmail);
		Thread.sleep(500);
		logger.info("Entered vendorEmail");

	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_PHONENUMBER)
	@CacheLookup
	public WebElement field_VENDOR_PHONENUMBER;

	public void setVendorPhoneNumber(String vendorPhoneNumber) throws InterruptedException {
		field_VENDOR_PHONENUMBER.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_PHONENUMBER.sendKeys(Keys.DELETE);
		field_VENDOR_PHONENUMBER.sendKeys(vendorPhoneNumber);
		Thread.sleep(500);
		logger.info("Entered vendorPhoneNumber");

	}

	public void selectAssteCategroy(String assetCategory) throws InterruptedException {
		if (ruae.clickOnDropdown_1_RU(driver)) {
			selectAnyValueFromDropdownList(driver, assetCategory);
		}
	}

	public void selectVendorsTypes(String vendorType) throws InterruptedException {
		if (ruae.clickOnDropdown_1_RU(driver)) {
			selectAnyValueFromDropdownList(driver, vendorType);
		}
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_WHATSAPPNUMBER)
	@CacheLookup
	public WebElement field_VENDOR_WHATSAPPNUMBER;

	public void setVendorWhatsAppNumber(String vendorWhatsappNumber) throws InterruptedException {
		field_VENDOR_WHATSAPPNUMBER.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_WHATSAPPNUMBER.sendKeys(Keys.DELETE);
		field_VENDOR_WHATSAPPNUMBER.sendKeys(vendorWhatsappNumber);
		Thread.sleep(500);
		logger.info("Entered vendorWhatsappNumber");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_WEBSITE)
	@CacheLookup
	public WebElement field_VENDOR_WEBSITE;

	public void setVendorWebsite(String vendorWebsite) throws InterruptedException {
		field_VENDOR_WEBSITE.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_WEBSITE.sendKeys(Keys.DELETE);
		field_VENDOR_WEBSITE.sendKeys(vendorWebsite);
		Thread.sleep(500);
		logger.info("Entered vendorWebsite");
	}

	public void selectVendorTypeRadioButton(String vendorType) throws InterruptedException {
		if (vendorType.equals("Agency")) {
			ruae.clickOnRadioButton_1_RU();
		} else if (vendorType.equals("Individual")) {
			ruae.clickOnRadioButton_2_RU();
		} else {
			logger.warn("Wrong vendor type" + vendorType);
		}
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_ADDRESS1)
	@CacheLookup
	public WebElement field_VENDOR_ADDRESS1;

	public void setVendorAddress1(String address1) throws InterruptedException {
		field_VENDOR_ADDRESS1.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_ADDRESS1.sendKeys(Keys.DELETE);
		field_VENDOR_ADDRESS1.sendKeys(address1);
		Thread.sleep(500);
		logger.info("Entered vendorAddress1");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_ADDRESS2)
	@CacheLookup
	public WebElement field_VENDOR_ADDRESS2;

	public void setVendorAddress2(String address2) throws InterruptedException {
		field_VENDOR_ADDRESS2.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_ADDRESS2.sendKeys(Keys.DELETE);
		field_VENDOR_ADDRESS2.sendKeys(address2);
		Thread.sleep(500);
		logger.info("Entered vendorAddress2");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_CITY)
	@CacheLookup
	public WebElement field_VENDOR_CITY;

	public void setVendorCity(String city) throws InterruptedException {
		field_VENDOR_CITY.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_CITY.sendKeys(Keys.DELETE);
		field_VENDOR_CITY.sendKeys(city);
		Thread.sleep(500);
		logger.info("Entered vendorCity");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_POSTALCODE)
	@CacheLookup
	public WebElement field_VENDOR_POSTALCODE;

	public void setVendorPostalCode(String postalCode) throws InterruptedException {
		field_VENDOR_POSTALCODE.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_POSTALCODE.sendKeys(Keys.DELETE);
		field_VENDOR_POSTALCODE.sendKeys(postalCode);
		Thread.sleep(500);
		logger.info("Entered vendorPostalCode");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_STATE)
	@CacheLookup
	public WebElement field_VENDOR_STATE;

	public void setVendorState(String state) throws InterruptedException {
		field_VENDOR_STATE.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_STATE.sendKeys(Keys.DELETE);
		field_VENDOR_STATE.sendKeys(state);
		Thread.sleep(500);
		logger.info("Entered vendorState");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_COUNTRY)
	@CacheLookup
	public WebElement field_VENDOR_COUNTRY;

	public void setVendorCountry(String country) throws InterruptedException {
		field_VENDOR_COUNTRY.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_COUNTRY.sendKeys(Keys.DELETE);
		field_VENDOR_COUNTRY.sendKeys(country);
		Thread.sleep(500);
		logger.info("Entered vendorCountry");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_OVERVIEW)
	@CacheLookup
	public WebElement field_VENDOR_OVERVIEW;

	public void setVendorOverview(String overview) throws InterruptedException {
		field_VENDOR_OVERVIEW.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_OVERVIEW.sendKeys(Keys.DELETE);
		field_VENDOR_OVERVIEW.sendKeys(overview);
		Thread.sleep(500);
		logger.info("Entered vendorOverview");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_CONTACT_NAME)
	@CacheLookup
	public WebElement field_VENDOR_CONTACTNAME;

	public void setVendorContactName(String contactName) throws InterruptedException {
		field_VENDOR_CONTACTNAME.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_CONTACTNAME.sendKeys(Keys.DELETE);
		field_VENDOR_CONTACTNAME.sendKeys(contactName);
		Thread.sleep(500);
		logger.info("Entered contactName");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_CONTACT_NUMBER)
	@CacheLookup
	public WebElement field_VENDOR_CONTACTNUMBER;

	public void setVendorContactNumber(String contactNumber) throws InterruptedException {
		field_VENDOR_CONTACTNUMBER.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_CONTACTNUMBER.sendKeys(Keys.DELETE);
		field_VENDOR_CONTACTNUMBER.sendKeys(contactNumber);
		Thread.sleep(500);
		logger.info("Entered contactNumber");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_CONTACT_EMAIL)
	@CacheLookup
	public WebElement field_VENDOR_CONTACT_EMAIL;

	public void setVendorContactEmail(String contactEmail) throws InterruptedException {
		field_VENDOR_CONTACT_EMAIL.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_CONTACT_EMAIL.sendKeys(Keys.DELETE);
		field_VENDOR_CONTACT_EMAIL.sendKeys(contactEmail);
		Thread.sleep(500);
		logger.info("Entered contactNumber");
	}

	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_CONTACT_COMMENT)
	@CacheLookup
	public WebElement field_VENDOR_CONTACT_COMMENT;

	public void setVendorContactComment(String contactComment) throws InterruptedException {
		field_VENDOR_CONTACT_COMMENT.sendKeys(Keys.CONTROL, "a");
		field_VENDOR_CONTACT_COMMENT.sendKeys(Keys.DELETE);
		field_VENDOR_CONTACT_COMMENT.sendKeys(contactComment);
		Thread.sleep(500);
		logger.info("Entered contactNumber");
	}

	// VENDOR LIST
	@FindBy(xpath = PL_VendorsPage.ADDRESS_VENDOR_LIST)
	@CacheLookup
	List<WebElement> listVendor;

	public int findDataFromRowListAndClickOnThreeDot(String vendorName, String searchKey, int searchKeyColumnIndex,
			boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {

		searchBox_1_RU(driver, searchKey);

		if (!driver.getPageSource().contains("No vendors found")) {
			int listRowCount = 0;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(PL_VendorsPage.ADDRESS_VENDOR_LIST,
						listVendor, driver, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
						wantToclickOnFindSearckKey);

			} catch (Exception e) {
				logger.info("Exception from findDataFromRowListAndClickOnThreeDot: " + e.getMessage());
			}
			logger.info("listRowCount: " + listRowCount);
			return listRowCount;
		} else {
			logger.info("No vendors found");
			return -1;
		}

	}
	// ======END======PAGE OBJECT AND ACTOIN METHODS==========//

//	// TO ASSUME A ROLE AS TENANTS
//	public PO_VendorsPage assumeRoleAsTenant(String tenantName, int rowListCount, int columnCount,
//			boolean wantToclickColumnELement, WebDriver driver) throws InterruptedException {
//		Action_ClickOnAnyColumnElementBasedOnSelectedRowItem.clickOnSelectedColumnElementBasedOnGivenRowCount(
//				PL_TenantsPage.ADD_TENANT_LIST, rowListCount, columnCount, true, driver);
//		String address_selectedTenant = "//*[text()='" + tenantName + "']";
//
//		String selectedTenant = driver.findElement(By.xpath(address_selectedTenant)).getText();
//		logger.info("Role Assumed for: " + selectedTenant);
//		softAssert.assertEquals(tenantName, selectedTenant);
//		softAssert.assertAll();
//		return new PO_VendorsPage(driver);
//	}

	// TO ADD AND UPDATE
	public PO_VendorsPage addOrEditVendor(String vendorName, String vendorEmail, String vendorPhoneNumber,
			String vendorWhatsAppNumber, String vendorWebsite, String vendorType, String vendorAddress1,
			String vendorAddress2, String vendorCity, String vendorPostalCode, String vendorState, String vendorCountry,
			String vendoroverview, String vendorContactName, String vendorContactNumber, String vendorContactEmail,
			String vendorContactComment, String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot,
			boolean wantToclickOnFindSearckKey) throws Throwable {

		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Caller methods name: " + callerMethodName);

		boolean flag = false;
		boolean isClickedOnAddOrEditButton = false;
		if (callerMethodName.contains("test_Add")) {
			isClickedOnAddOrEditButton = ruae.clickOnAdd_RU();

			Thread.sleep(1000);
		} else if (callerMethodName.contains("test_Edit")) {

			int isItemfindInList = findDataFromRowListAndClickOnThreeDot(vendorName, searchKey, searchKeyColumnIndex,
					wantToClickOnThreeDot, wantToclickOnFindSearckKey);
			logger.info("Item found in row number: " + isItemfindInList);
			if (isItemfindInList != -1) {
				isClickedOnAddOrEditButton = Action_Edit.edit(driver);
			}
		}

		logger.info("isClickedOnAddOrEditButton: " + isClickedOnAddOrEditButton);

		try {

			if (isClickedOnAddOrEditButton) {
				Thread.sleep(2000);
				boolean isClickedOnNextBtn = false;
				try {
					// for vendor details
					setVendorName(vendorName);
					setVendorEmail(vendorEmail);
					setVendorPhoneNumber(vendorPhoneNumber);
					setVendorWhatsAppNumber(vendorWhatsAppNumber);
					setVendorWebsite(vendorWebsite);
					selectVendorTypeRadioButton(vendorType);
					logger.info("Vendor Details added");
					isClickedOnNextBtn = ruae.clickOnBtnNext_RU();
					Thread.sleep(2000);
				} catch (Exception e) {
					logger.info("Exception from Vendor details: " + e.getMessage());
				}

				if (isClickedOnNextBtn) {
					try {
						// for vendor address
						isClickedOnNextBtn = false;
						setVendorAddress1(vendorAddress1);
						setVendorAddress2(vendorAddress2);
						setVendorCity(vendorCity);
						setVendorPostalCode(vendorPostalCode);
						setVendorState(vendorState);
						setVendorCountry(vendorCountry);
						setVendorOverview(vendoroverview);
						isClickedOnNextBtn = ruae.clickOnBtnNext_RU();
						logger.info("Vendor Address details");
						Thread.sleep(2000);
					} catch (Exception e) {
						logger.info("Exception from Vendor address: " + e.getMessage());
					}
				}

				if (isClickedOnNextBtn) {
					try {
						isClickedOnNextBtn = false;
						// for vendor contacts
						setVendorContactName(vendorContactName);
						setVendorContactNumber(vendorContactNumber);
						// setVendorContactEmail(vendorContactEmail);
						setVendorContactComment(vendorContactComment);
						isClickedOnNextBtn = ruae.clickOnBtnPreview_RU();
						logger.info("Vendor Address contact");
						Thread.sleep(2000);
					} catch (Exception e) {
						logger.info("Exception from Vendor contact: " + e.getMessage());
					}
				}

				if (isClickedOnNextBtn) {
					boolean isClickedOnSaveButton = ruae.clickOnBtnSave_1_RU();
					if (isClickedOnSaveButton) {
						if (driver.getPageSource().contains("Please")
								|| driver.getPageSource().contains("allow only alphabets")) {
							clickOnCancelButton_1_RU();
							logger.info("Asset Configuration not added");
							softAssert.assertTrue(false, "Vemdpr is emplty");
							return new PO_VendorsPage(driver);
						} else {

							String alertMsg = snakeAlertMessagesDisplayedContent_RU();
							logger.info("Alert Message: " + alertMsg);
							if (alertMsg.contains("already exists") || alertMsg.contains("error")) {
								clickOnCancelButton_1_RU();
							} else {
								if (callerMethodName.contains("test_Add")) {
									softAssert.assertEquals(alertMsg, PL_VendorsPage.MESSAGE_VENDOR_CREATEDED,
											"Check user vendor added or not");
								} else if (callerMethodName.contains("test_Edit")) {
									softAssert.assertEquals(alertMsg, PL_VendorsPage.MESSAGE_VENDOR_UPDATED,
											"Check user vendor updated or not");
								}
							}

						}
					}
				}

			}
		} catch (Exception e) {
			logger.warn("Exceptino form : addOrEditVendor >>" + e.getMessage());
		}

		softAssert.assertAll();
		return new PO_VendorsPage(driver);
	}

}
