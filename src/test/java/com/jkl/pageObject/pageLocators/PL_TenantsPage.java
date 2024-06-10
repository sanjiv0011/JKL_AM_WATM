package com.jkl.pageObject.pageLocators;

public class PL_TenantsPage {

	public static final String ADD_PAGETITLE = "//div[@class='capitalize heading-18 sm:heading-22 ml-4']";
	public static final String ADD_TENANT_TAB = "(//div[@class='flex w-full items-center'])[1]";
	public static final String ADD_ADMIN_TAB = "(//div[@class='flex w-full items-center'])[2]";
	public static final String ADD_TENANT_LIST = "//div[contains(@class,'flex flex-col gap-2 items-center')]";
	public static final String ADD_TENANT_NAME= "//input[placeholder='Enter Tenant Name']";
	public static final String ADD_TENANT_ASSET_CODE = "//input[@placeholder='Enter Asset Code']";
	public static final String ADD_TENANT_DESCRIPTION = "//textarea[@placeholder='Enter Overview']";
	public static final String ADD_TENANT_IMAGE = "//input[@type='file']";
}
