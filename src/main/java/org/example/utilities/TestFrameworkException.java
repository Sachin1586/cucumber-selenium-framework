package org.example.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.example.stepdefinitions.Hooks;


public class TestFrameworkException extends Exception {
		
	private static final long serialVersionUID = 1L;
	private String exceptionURL = "";
	private Hooks hook = new Hooks();

	public TestFrameworkException()	{
		super();
	}
	
	public TestFrameworkException(String message, Exception e){			
		try{
			message = message  + Character.toString ((char) 10) +
					"URL: " + getExceptionURL() + Character.toString ((char) 10) + 
					getStackTrace(e);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getExceptionURL()	{
		if(hook.getWebDriver() != null){
			exceptionURL = hook.getWebDriver().getCurrentUrl();
		}
		return exceptionURL;
	}
	
	public String getStackTrace(Exception e){
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		return exceptionAsString;
	}
	
}
