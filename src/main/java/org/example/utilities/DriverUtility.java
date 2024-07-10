package org.example.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverUtility {
	
	protected WebDriver driver;
	public WebDriverWait wait;
	
	public DriverUtility(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public List<WebElement> findElements(String locator) throws Exception {
		return driver.findElements(By.xpath(locator));
	}
	
	public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
	
	public boolean click(String locator) throws Exception {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			element.click();
			return true;
		}catch(Exception e) {
			throw new TestFrameworkException("Failed to click on element for locator " + locator, e);
		}
	}
	
	public boolean click(WebElement element) throws Exception {
		try {
			element.click();
			return true;
		}catch(Exception e) {
			throw new TestFrameworkException("Failed to click on element " + element.toString(), e);
		}
	}
	
	public boolean isWebElementDisplayed(String locator){
		try{
			if(driver.findElement(By.xpath(locator)).isDisplayed()){
				return true;
			}
		}catch(Exception e){}
		return false;
	}
	
}
