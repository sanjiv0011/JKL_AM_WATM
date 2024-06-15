package com.leonardoAI.pageObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.actions.Action_Activate;
import com.leonardoAI.actions.Action_Archive;
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.actions.Action_Restore;
import com.leonardoAI.actions.Action_View;
import com.leonardoAI.pageObject.pageLocators.PL_ImageGenerationPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.testCases.BaseClass;

public class PO_ImageGenerationPage extends ReUseAbleElement {

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
	public PO_ImageGenerationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	

	//ELEMENT LOCATORES

	@FindBy(xpath = PL_ImageGenerationPage.address_elementIsImageGeneratePageReady)
	@CacheLookup
	public WebElement elementIsImageGeneratePageReady;
	
	
	@FindBy(xpath = PL_ImageGenerationPage.address_textareaPromptInput)
	@CacheLookup
	public WebElement textareaPromptInput;
	
	@FindBy(xpath = PL_ImageGenerationPage.address_btnGenerateImage)
	@CacheLookup
	public WebElement btnGenerateImage;
	
	@FindBy(xpath = PL_ImageGenerationPage.address_listGeneratedImage)
	@CacheLookup
	public List <WebElement> listGeneratedImage;
	
	@FindBy(xpath = PL_ImageGenerationPage.address_btnDownloadImage)
	@CacheLookup
	public WebElement btnDownloadImage;
	
	@FindBy(xpath = PL_ImageGenerationPage.address_listBtnSelectImage)
	@CacheLookup
	public List <WebElement> listBtnSelectImage;
	
	@FindBy(xpath = PL_ImageGenerationPage.address_btnDownloadImageOnSelectImage)
	@CacheLookup
	public WebElement btnDownloadImageOnSelectImage;
	
	@FindBy(xpath = PL_ImageGenerationPage.address_btnOriginalImage)
	@CacheLookup
	public WebElement btnOriginalImage;
	
	
	public boolean checkIsImageGeneratePageReady() {
		boolean isImageGeneratePageReady = false;
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(elementIsImageGeneratePageReady, "Image Generation"));
			if(elementIsImageGeneratePageReady.isDisplayed()) {
				isImageGeneratePageReady = true;
			}
		}catch(Exception e) {logger.info(e.getCause());}
		
		return isImageGeneratePageReady;
	}
	
	
	public void setPrompt(String yourPrompt) throws InterruptedException {
		try {
			textareaPromptInput.sendKeys(Keys.CONTROL, "a");
			textareaPromptInput.sendKeys(Keys.DELETE);
			textareaPromptInput.sendKeys(yourPrompt);
			Thread.sleep(2000);
			logger.info("Entered yourPrompt");
		}catch(Exception e) {logger.info(e.getCause());}

	}
	
	public void clickOnBtnGenerateImage() throws InterruptedException {
		try {
			btnGenerateImage.click();
			logger.info("Waiting for at least 15 seconds");
			Thread.sleep(15000);
		}catch(Exception e) {
			logger.info(e.getCause());
		}
	}
	
	public boolean checkIsImageGenerated() {
		boolean isImageGenerated = false;
		try {
			wait.until(ExpectedConditions.invisibilityOfAllElements(listGeneratedImage));
			isImageGenerated = true;
			logger.info("✅✅✅ Image generated successfully");
		}catch(Exception e) {logger.info(e.getCause());}
		return isImageGenerated;
	}

	public void findImageFromList(int imageSerialNumber) throws InterruptedException {
		String address_specificImage = "("+PL_ImageGenerationPage.address_listGeneratedImage+")["+imageSerialNumber+"]";
		WebElement visitAnySpecificImage = driver.findElement(By.xpath(address_specificImage));
		action.moveToElement(visitAnySpecificImage).pause(500).build().perform();
		Thread.sleep(200);
	}
	
	public void clickOnBtnDownloadImagePresentOnTheImage(int imageSerialNumber) throws InterruptedException {
		findImageFromList(imageSerialNumber);
		try {
			action.moveToElement(btnDownloadImage).build().perform();
			Thread.sleep(200);
			action.moveToElement(btnDownloadImage).click().build().perform();
			logger.info("Clicked on the Donwlaod Image");
		}catch(Exception e) {logger.info(e.getCause());}
	}
	
	// ======END======PAGE OBJECT FOR ADD USERS LEBELS ACTOIN METHODS==========//

	// TO GENERATE IMAGE
	public PO_ImageGenerationPage generateImage(String yourPrompt) throws Throwable {
		
		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Caller methods name: " + callerMethodName);
		
		if(checkIsImageGeneratePageReady()) {
			setPrompt(yourPrompt);
			clickOnBtnGenerateImage();
			checkIsImageGenerated();
		}
		
		softAssert.assertAll();
		return new PO_ImageGenerationPage(driver);
	}
	
	//TO DOWNLOAD IMAGE
	public PO_ImageGenerationPage downloadImage(int imageSerialNumber) throws InterruptedException {
		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Caller methods name: " + callerMethodName);
		
		clickOnBtnDownloadImagePresentOnTheImage(imageSerialNumber);
		
		softAssert.assertAll();
		return new PO_ImageGenerationPage(driver);
		
	}
	
}
