package org.example.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	
	public WebDriver driver = null;
	public WebDriver webdriver = null;
	
	@Before
	public void beforeScenario(Scenario scenario) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		setWebDriver(driver);
		Reporter.log("Driver initialized", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(getUrl());
	}
	
	@After
	public void afterScenario(Scenario scenario) throws Exception {
		try{
			if(scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
	            Reporter.log("Scenario_is_failed: " + scenario.getName(), true );
	        }
		}catch(Exception e){
			Reporter.log("Error in Initializing the test", true);
			e.printStackTrace();
		}
		finally{
			try {
				if(driver != null) {
					Reporter.log("Quiting driver", true);
					driver.quit();
				}
			}catch(Exception e){
				Reporter.log("Error quiting driver", true);
				e.printStackTrace();
			}

		}
    }
	
	public WebDriver getWebDriver() {
		return webdriver;
	}
	
	public void setWebDriver(WebDriver driver) {
	    this.webdriver = driver;
	}
	
	public String getUrl(){
		Properties properties = new Properties();
	    InputStream input = null;
	    String url = "";
        try {
            input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            properties.load(input);
            url = properties.getProperty("BaseURL");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return url;
	}

}
