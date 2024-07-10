package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//a/img[@alt='Top Navigation Logo' and @title='/search']")
    WebElement link_homePage;
	
    @FindBy(xpath = "//a[@href='#edAssist']")
    WebElement link_edAssist;
    
    @FindBy(id = "onetrust-reject-all-handler")
    WebElement button_RejectAll;

    @FindBy(xpath = "//a[contains(@class, 'edassist') and text()='Learn More']")
    WebElement button_edAssistLearnMore;
    
    public HomePage(WebDriver driver) {
		super(driver);
	}
    
    public boolean isAtHomePage(){
    	return isWebElementDisplayed("//body[contains(@class,'js-Home')]");
    }
    
    public void clickHomePage() throws Exception{
    	click(link_homePage);
    }
    
    public void clickRejectAllCookies() throws Exception{
    	click(button_RejectAll);
    }
    
    public void clickEdAssistLink() throws Exception{
    	click(link_edAssist);
    }

    public void clickEdAssistLearnMore() throws Exception{
    	click(button_edAssistLearnMore);
    }

}
