package com.DemoTest.Tests;

import com.DemoTest.Pages.WebDemoPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;


public class WebDemoTest extends TestBase {

    /**
     * 
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
	
	


	 @Test(dataProvider = "hardCodedBrowsers")
	    public void Login(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
		 
		 System.out.println("\nStarting Login Function for Dataprovider HardCOdedBrowsers");
		 // add boolean variable 
	    	Boolean value = true;
	    	
	    	// Added comment to sync file 

		System.out.println("\nConnecting the SauceLabs EU Data Center, we are about to run our tests.");
	    	
	    	 System.out.println("\nCreate an instance of the driver");
	        //create webdriver session
	        this.createDriver(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	       

	        System.out.println("\nStarting login function");
	        this.annotate("Login Test..");
	        Boolean returnvalue = page.Login("standard_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login: result");
	        Assert.assertEquals(value,returnvalue);

	        
	     
	    }
	    
	    
	 @Test(dataProvider = "hardCodedBrowsers")
	    public void LoginLockedoutUser(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
	    	Boolean value = true;

	        //create webdriver session
	        this.createDriver(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	       
	         // 
	        this.annotate("Login LoginLockedoutUser user Test..");
	        Boolean returnedvaluelockedout = page.LoginLockedoutUser("locked_out_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login LoginLockedoutUser user Test: result");
	        Assert.assertEquals(value, returnedvaluelockedout);
	        
	             
	    }

	 
	@Test(dataProvider = "hardCodedBrowsers")
	    public void LoginPerfGlitchUser(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
	    	Boolean value = true;

	        //create webdriver session
	        this.createDriver(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	       
	         // 
	        this.annotate("Login Performance Glitch user Test..");
	        Boolean returnedvalueglitch = page.LoginPerfGlitchUser("performance_glitch_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login Performance Glitch user Test: result");
	        Assert.assertEquals(value,returnedvalueglitch);
	        
	             
	    }
	

	@Test(dataProvider = "hardCodedBrowsers")
	    public void LoginProblemUser(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
	    	Boolean value = true;

	        //create webdriver session
	        this.createDriver(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	       
	         // 
	        this.annotate("Login ProblemUser user Test..");
	        Boolean returnedvaluelockedout = page. LoginProblemUser("problem_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login ProblemUser user Test: result");
	        Assert.assertEquals(value, returnedvaluelockedout);
	        
	             
	    }






}
