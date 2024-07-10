package org.example.stepdefinitions;

import org.example.pages.HomePage;
import org.example.pages.SolutionsPage;
import org.openqa.selenium.WebDriver;


public class BaseSteps {
	
	protected WebDriver driver;
	protected HomePage homePage;
	protected SolutionsPage solutionsPage;
	protected Hooks hooks;
	
	public BaseSteps (Hooks setUp) {
		driver = setUp.getWebDriver();
		initPage();
	}
	
	public void initPage() {
		homePage = new HomePage(driver);
		solutionsPage = new SolutionsPage(driver);
	}

}
