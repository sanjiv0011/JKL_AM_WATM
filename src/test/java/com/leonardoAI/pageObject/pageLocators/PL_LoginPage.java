package com.leonardoAI.pageObject.pageLocators;

public class PL_LoginPage {

	public static final String address_tabCloseModel = "(//button[@aria-label='Close Modal'])[1]";;
	public static final String address_btnSignIn = "(//button[normalize-space()='Sign in'])[1]";
	public static final String address_textpassword = "(//input[@id='password'])[1]";
	public static final String address_textemail = "(//input[@id='email'])[1]";
	public static final String address_elementSingUpOrLoginWith = "//*[.='Sign up or Login with']";
	public static final String address_elementGetStarted = "//h1[contains(.,'Get Started Here')]";
	public static final String address_btnLaunchApp = "(//div//a[@title='Launch App'])[2]";
}
