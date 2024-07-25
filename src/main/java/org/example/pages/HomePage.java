package org.example.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//a/img[@alt='Top Navigation Logo' and @title='/search']")
    WebElement link_homePage;
	
    @FindBy(xpath = "//a[@href='#edAssist']")
    WebElement link_edAssist;
    
    @FindBy(id = "onetrust-reject-all-handler")
    WebElement button_RejectAll;
    
    @FindBy(xpath = "//a[contains(@class, 'edassist') and text()='Learn More']")
    WebElement button_edAssistLearnMore;
    
    @FindBy(xpath = "//a[contains(@href,'search-desktop-top')]/span[contains(@class,'icon-search')]")
    WebElement button_Icon;
    
    @FindBy(xpath = "//nav[contains(@id,'desktop-top')]//input[@id='search-field']")
    WebElement input_Search;
    
    @FindBy(xpath = "//nav[contains(@id,'desktop-top')]//input[@id='search-field']/following-sibling::button")
    WebElement button_Search;
    
    public HomePage(WebDriver driver) {
		super(driver);
	}
    
    public boolean isAtHomePage() throws Exception{
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
    
    public void clickSearchIcon() throws Exception{
    	click(button_Icon);
    	waitForVisibilityOfElement(input_Search);
    }
    
    public boolean isSearchFieldVisible() throws Exception{
    	return isWebElementDisplayed("//nav[contains(@id,'desktop-top')]//input[@id='search-field']");
    }
    
    public void enterSearchText(String text) throws Exception{
    	Reporter.log("Text searched :: " + text, true);
    	sendKeys(input_Search, text);
    }
    
    public void clickSearchButton() throws Exception{
    	click(button_Search);
    }
    
    public boolean isSearchTextPresentInSearchResults(String searchText) throws Exception{
    	List<WebElement> elementList = findElements("//h3[@class='title']");
    	for(WebElement element : elementList) {
    		if(element.getText().equals(searchText)) {
    			Reporter.log("Search result found :: " + element.getText(), true);
    			return true;
    		}
    	}
    	return false;
    }
  
}
