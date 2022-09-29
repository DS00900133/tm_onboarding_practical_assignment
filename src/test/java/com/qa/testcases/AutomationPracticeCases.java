package com.qa.testcases;

import com.qa.pages.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.base.TestBase;
import com.google.common.base.Verify;

public class AutomationPracticeCases extends TestBase {

	HomePage homepage;

	public AutomationPracticeCases() {
		super();
	}

	/*
	 * @BeforeTest public void setExtentReport() { setExtend(); }
	 */

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		initializaton();
		homepage = new HomePage();
	}

	@Test(groups = { "Simple", "UI" })
	public void TC001_CheckifLogoisPresent() {
		boolean flag = homepage.isLogoDisplayed();
		Assert.assertTrue(flag);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		// FormatResult();
		tearDownMain();
	}

}
