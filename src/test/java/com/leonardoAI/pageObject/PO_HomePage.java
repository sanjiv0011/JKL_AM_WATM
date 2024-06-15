package com.leonardoAI.pageObject;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.pageObject.pageLocators.PL_HomePage;

public class PO_HomePage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	//PAGE ELEMENT LOCATORS
	@FindBy(xpath = PL_HomePage.address_userLogoIcon)
	@CacheLookup
	WebElement userLogoIcon;

	@FindBy(xpath = PL_HomePage.address_gettingStartedCloseButton)
	@CacheLookup
	WebElement btnGettingStartedCloseButton;

	@FindBy(xpath = PL_HomePage.address_introGuide)
	@CacheLookup
	WebElement btnIntroGuide;
	
	@FindBy(xpath = PL_HomePage.address_imageGeneration)
	@CacheLookup
	WebElement menuImageGeneration;
	
	@FindBy(xpath = PL_HomePage.address_motion)
	@CacheLookup
	WebElement menuMotion;
	
	@FindBy(xpath = PL_HomePage.address_realtimeCanvas)
	@CacheLookup
	WebElement menuRealtimeCanvas;
	
	@FindBy(xpath = PL_HomePage.address_canvasEditor)
	@CacheLookup
	WebElement menuCanvasEditor;
	
	@FindBy(xpath = PL_HomePage.address_universalUpscaler)
	@CacheLookup
	WebElement menuMniversalUpscaler;
	
	
	@FindBy(xpath = PL_HomePage.address_CloseButtonModelImage2Motion)
	@CacheLookup
	WebElement btnCloseButtonModelImage2Motion;
	

	@FindBy(xpath = PL_HomePage.address_logoBackButton)
	@CacheLookup
	WebElement logoBackButton;

	@FindBy(xpath = PL_HomePage.address_logout)
	@CacheLookup
	WebElement userLogout;

	// =========END========HOME PAGE OBJECTS=============//

	// =========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	public void clickOnUserLogoIcon() throws InterruptedException {
		try {
			userLogoIcon.click();
			Thread.sleep(2000);
			logger.info("Clicked on the userLogoIcon");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
		
		
	}

	// TO CLICK ON THE CLOSE BUTTON MODEL GETTING STARTED
	public void clickOnCloseModelGettingStarted() throws InterruptedException {

		int loopcount = 0;
		boolean isGettingStartedModelPresent = false;
		while (loopcount < 10) {
			try {
				if (btnGettingStartedCloseButton.isDisplayed() && btnGettingStartedCloseButton.isEnabled()) {
					btnGettingStartedCloseButton.click();
					logger.info("clicke on btnGettingStartedCloseButton");
					Thread.sleep(500);
					loopcount++;
					isGettingStartedModelPresent = true;
					break;
				}
			} catch (Exception e) {
				if(loopcount == 9 && isGettingStartedModelPresent) {
					logger.info("Exception from btnGettingStartedCloseButton: " + e.getMessage());
					logger.info("btnGettingStartedCloseButton not present");
				}
				loopcount++;
			}
		}

	}

	// TO CLICK ON THE BUTTON INTRO GUIDE
	public void clickOnCloseModelIntroGuide() throws InterruptedException {
		int loopcount = 0;
		boolean isGettingStartedModelPresent = false;
		while (loopcount < 10) {
			try {
				if (btnIntroGuide.isDisplayed() && btnIntroGuide.isEnabled()) {
					btnIntroGuide.click();
					logger.info("clicke on btnIntroGuide");
					Thread.sleep(500);
					loopcount++;
					isGettingStartedModelPresent = true;
					break;
				}
			} catch (Exception e) {
				if(loopcount == 9 && isGettingStartedModelPresent) {
					logger.info("Exception from btnIntroGuide: " + e.getMessage());
					logger.info("btnIntroGuide not present");
				}
				loopcount++;
			}
		}

	}

	
	
	public void clickOnMenuImageGeneration() throws InterruptedException {
		try {
			menuImageGeneration.click();
			Thread.sleep(2000);
			logger.info("Clicked on the menuImageGeneration");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
	}
	
	public void clickOnMenuMotion() throws InterruptedException {
		try {
			menuMotion.click();
			Thread.sleep(2000);
			logger.info("Clicked on the menuMotion");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
		
	}
	
	public void clickOnCloseButtonModelImage2Motion() throws InterruptedException {
		int loopcount = 0;
		boolean isGettingStartedModelPresent = false;
		while (loopcount < 10) {
			try {
				if (btnCloseButtonModelImage2Motion.isDisplayed() && btnCloseButtonModelImage2Motion.isEnabled()) {
					btnCloseButtonModelImage2Motion.click();
					logger.info("clicke on btnCloseButtonModelImage2Motion");
					Thread.sleep(500);
					loopcount++;
					isGettingStartedModelPresent = true;
					break;
				}
			} catch (Exception e) {
				if(loopcount == 9 && isGettingStartedModelPresent) {
					logger.info("Exception from clickOnCloseButtonModelImage2Motion: " + e.getMessage());
					logger.info("btnCloseButtonModelImage2Motion not present");
				}
				loopcount++;
			}
		}
	}
	
	
	public void clickOnMenuRealtimeCanvas() throws InterruptedException {
		try {
			menuRealtimeCanvas.click();
			Thread.sleep(2000);
			logger.info("Clicked on the menuRealtimeCanvas");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
		
	}
	
	
	public void clickOnMenuCanvasEditor() throws InterruptedException {
		try {
			menuCanvasEditor.click();
			Thread.sleep(2000);
			logger.info("Clicked on the menuCanvasEditor");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
		
	}
	
	
	public void clickOnMenuUiversalUpscaler() throws InterruptedException {
		try {
			menuMniversalUpscaler.click();
			Thread.sleep(2000);
			logger.info("Clicked on the menuMniversalUpscaler");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
		
	}
	
	
	public void clickOnLogoBackButton() throws InterruptedException {
		try {
			if (logoBackButton.isDisplayed() && logoBackButton.isEnabled()) {
				logoBackButton.click();
				Thread.sleep(2000);
				logger.info("Clicked on the logoBackButton");
			}
		} catch (Exception e) {
			logger.info("Exception from: clickOnLogoBackButton >> " + e.getMessage());
		}

	}

	public void clickOnLogout() throws InterruptedException {
		try {
			userLogout.click();
			Thread.sleep(2000);
			logger.info("Clicked on the logout");
		}catch(Exception e) {
			logger.info(e.getCause());
		}
		
	}

	// =========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {
			Thread.sleep(2000);
			clickOnLogoBackButton();
			clickOnUserLogoIcon();
			clickOnLogout();
			Thread.sleep(1000);
			if (driver.getPageSource().contains("Sign up or Login with")) {
				softAssert.assertTrue(true);
				logger.info("✅✅✅ LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("❎❎❎ LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [Login with Google] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
	}
	
	//TO CHECK AI TOOLS SUB MENUS
	public PO_HomePage checkAIToolSubMenus() throws InterruptedException {
		Thread.sleep(5000);
		clickOnMenuImageGeneration();
		driver.navigate().back();
		Thread.sleep(1000);
		
		clickOnMenuRealtimeCanvas();
		driver.navigate().back();
		Thread.sleep(1000);
		
		clickOnMenuMotion();
		Thread.sleep(1000);
		clickOnCloseButtonModelImage2Motion();
		driver.navigate().back();
		
		clickOnMenuCanvasEditor();
		driver.navigate().back();
		Thread.sleep(1000);
		
		clickOnMenuUiversalUpscaler();
		driver.navigate().back();
		Thread.sleep(1000);
		
		return new PO_HomePage(driver);
	}

}
