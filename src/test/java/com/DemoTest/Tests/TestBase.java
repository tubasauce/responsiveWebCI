package com.DemoTest.Tests;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Simple TestNG test which demonstrates being instantiated via a DataProvider in order to supply multiple browser combinations that execute in parallel
 *
 * 
 */
public  class TestBase  {

    private static final int sauce = 0;

	public String buildTag = System.getenv("BUILD_TAG");

    public String username = System.getenv("SAUCE_USERNAME");

    public String accesskey = System.getenv("SAUCE_ACCESS_KEY");

    /**
     * ThreadLocal variable which contains the  {@link WebDriver} instance which is used to perform browser interactions with.
     */
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    /**
     * ThreadLocal variable which contains the Sauce Job Id.
     */
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();

    /**
     * DataProvider that explicitly sets the browser combinations to be used.
     *
     * @param testMethod
     * @return Two dimensional array of objects with browser, version, and platform information
     */
    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
        	
        	 
        	 // windows 10 
        	 
        	 new Object[]{"chrome", "latest", "Windows 10"},
        	 
           
     			 // windows 8.1
     			new Object[]{"firefox", "latest", "Windows 8.1"},
     			new Object[]{"chrome", "latest", "Windows 8.1"},
     			new Object[]{"firefox", "latest -1", "Windows 8.1"},
     			new Object[]{"chrome", "latest -1", "Windows 8.1"},
     
     			
     			new Object[]{"safari", "latest", "macOS 10.14"}, //12.0 safari version
     			
     			
     			
     			// windows 8
     			new Object[]{"chrome", "latest", "Windows 8"},
     			
     			// windows 7
     		
     			new Object[]{"firefox", "latest", "Windows 7"},
     			new Object[]{"chrome", "latest", "Windows 7"},
     		
     			
                
        };
    }
    

    

    @DataProvider(name = "hardCodedBrowsersemulator", parallel = true)
       	    public static Object[][] sauceBrowserDataProviderEmulator(Method testMethod) {
       	        return new Object[][]{
       	        	
       	         new Object[]{"Android GoogleAPI Emulator", "portrait", "Chrome", "8.0", "Android"},
       	             
       	        };
       	    }
    
    

    /**
     * @return the {@link WebDriver} for the current thread
     */
    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    /**
     *
     * @return the Sauce Job id for the current thread
     */
    public String getSessionId() {
        return sessionId.get();
    }

    /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the browser,
     * version and os parameters, and which is configured to run against ondemand.saucelabs.com, using
     * the username and access key populated by the {@link #authentication} instance.
     *
     * @param browser Represents the browser to be used as part of the test run.
     * @param version Represents the version of the browser to be used as part of the test run.
     * @param os Represents the operating system to be used as part of the test run.
     * @param methodName Represents the name of the test case that will be used to identify the test on Sauce.
     * @return
     * @throws MalformedURLException if an error occurs parsing the url
     */
    protected void createDriver(String browser, String version, String os, String methodName)
            throws MalformedURLException, UnexpectedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // set desired capabilities to launch appropriate browser on Sauce
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        capabilities.setCapability("name", methodName);
        capabilities.setCapability("extendedDebugging", true);
        capabilities.setCapability("tags", "Smoke_Test");
        capabilities.setCapability("tags", "Regression_Test");
      
    	

        if (buildTag != null) {
        	
            capabilities.setCapability("build", buildTag);
        }
        

        // Launch remote browser and set it as the current thread
        webDriver.set(new RemoteWebDriver(
        		
               new URL("https://" + username + ":" + accesskey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capabilities));
            
        // set current sessionId
        String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
        sessionId.set(id);
    }
    

    protected void createDriverlinux(String browser, String version, String os, String methodName)
               throws MalformedURLException, UnexpectedException {
    	
    	
    	  
    	//  String prerunFile = "disablewarnonfraudsites";
    	  
    	/**
    	  HashMap<String, String> prerunParams = new HashMap<String, String>();         
          prerunParams.put("executable", "sauce-storage:Ianprerun");
          prerunParams.put("background","false");
          prerunParams.put("timeout","60");
    	 **/
    	
    	/**
      JSONObject obj = new JSONObject();
      obj.put("executable","sauce-storage:Ianprerun");
      LinkedList<String> list = new LinkedList<String>();
      list.add("/S");
      list.add("-a");
      list.add("-q");
      obj.put("args",list);
      obj.put("background","false");     
      System.out.print("\nHere is the arguments for prerun on the VM:\n" +obj);
    **/
    	
    	 JSONObject obj = new JSONObject();
    	// obj.put("executable","sauce-storage:preruntest.sh");
    	 obj.put("executable","https://gist.githubusercontent.com/iflanagan/5af7ff6027ff9d0f3dbb3bea55d670b9/raw/17c4c6a908080af704478f17f5ef750d575cbcdb/preruntest.sh");
    	 obj.put("background","false");
      
    	
           DesiredCapabilities capabilities = new DesiredCapabilities();

  
           // set desired capabilities to launch appropriate browser on Sauce
           capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
           capabilities.setCapability(CapabilityType.VERSION, version);
           capabilities.setCapability(CapabilityType.PLATFORM, os);
           capabilities.setCapability("name", methodName);
           capabilities.setCapability("extendedDebugging", true);
           // commented out line below
           capabilities.setCapability("prerun", obj);
          

           if (buildTag != null) {
               capabilities.setCapability("build", buildTag);
           }

    // Launch remote browser and set it as the current thread
           webDriver.set(new RemoteWebDriver(
                   new URL("https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub"),
                   capabilities));

           // set current sessionId
           String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
           sessionId.set(id);

   }



    /**
     * Method that gets invoked after test.
     * Dumps browser log and
     * Closes the browser
     */
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        ((JavascriptExecutor) webDriver.get()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        webDriver.get().quit();
    }

    protected void annotate(String text) {
        ((JavascriptExecutor) webDriver.get()).executeScript("sauce:context=" + text);
    }
}
