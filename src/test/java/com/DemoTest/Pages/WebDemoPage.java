package com.DemoTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDemoPage {

    @FindBy(linkText = "i am a link")
    private WebElement theActiveLink;

    @FindBy(id = "password")
    private WebElement password;
    
    @FindBy(id = "user-name")
    private WebElement username;  

  //  @FindBy(css = "#login_button_container > div > form > input.login-button")
    @FindBy(css = "[type='submit']")
    private WebElement LoginButton; 
    
    @FindBy(css = "#logout_sidebar_link")
    private WebElement LogoutButton; 
    
    // menu_button_container
    
    @FindBy(css = "#menu_button_container > div > div:nth-child(3) > div > button")
    private WebElement hamburgericon; 
    
    @FindBy(id = "comments")
    private WebElement commentsTextAreaInput;

    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/";

    public static WebDemoPage visitPage(WebDriver driver) {
        WebDemoPage page = new WebDemoPage(driver);
        page.visitPage();
        return page;
    }

    public WebDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void followLink() {
        theActiveLink.click();
    }

    public Boolean  Login(String user, String passwd) {
    	
    	Boolean value = false;
    	int delay = 3000;
    	
    	try
    	
    	{
    	
    	System.out.printf("\nStarting login function now");
    	
    	System.out.printf("\nEnter username: " +user);
    	username.sendKeys(user);
    	
    	System.out.printf("\nEnter Password: " +passwd);
    	password.sendKeys(passwd);
    	
    	System.out.printf("\nClick Login button");   	
    	Thread.sleep(delay);
    	LoginButton.click();
    	
    	System.out.printf("\nClick on Hamburger icon");   
    	Thread.sleep(delay);
    	hamburgericon.click();
    	
    	System.out.printf("\nPerforming validation");   
    	Thread.sleep(delay);
    	
    	
    	if(driver.getPageSource().contains("Logout")){
    		
    		System.out.println("\nYay Login Passed");
    		value = true;
    		
    		}
    	
    	else {
    		System.out.println("\nLogin Failed");
    		
    		}
    	
    	  // Race condition for time to populate yourCommentsSpan
         //  WebDriverWait wait = new WebDriverWait(driver, 15);
        //   wait.until(ExpectedConditions.textToBePresentInElement(username, user));
    	
    	LogoutButton.click();
    	
    	
    	
    	}
    	
    	catch (Exception ex)
    	{
    		
    		System.out.printf("\nCan't execute login function: " +ex);
    	}
    	
    	return value;

      
    }
    
public Boolean  LoginPerfGlitchUser(String user, String passwd) {
    	
    	Boolean value = false;
    	int delay = 3000;
    	
    	try
    	
    	{
    	
    	System.out.printf("\nStarting Login Performance Glitch User function now");
    	
    	System.out.printf("\nEnter username: " +user);
    	username.sendKeys(user);
    	
    	System.out.printf("\nEnter Password: " +passwd);
    	password.sendKeys(passwd);
    	
    	System.out.printf("\nClick Login button");   	
    	Thread.sleep(delay);
    	LoginButton.click();
    	
    	System.out.printf("\nClick on Hamburger icon");   
    	Thread.sleep(delay);
    	hamburgericon.click();
    	
    	System.out.printf("\nPerforming validation");   
   // 	Thread.sleep(delay);
    	
    	
if(driver.getPageSource().contains("Logout")){
	
			// Race condition for time to populate yourCommentsSpan
		    WebDriverWait wait = new WebDriverWait(driver, 15);
		    wait.until(ExpectedConditions.textToBePresentInElement(LogoutButton, "Logout"));		   		
    		System.out.println("\nLogin Locked out User Passed");
    		
    		
    		value = true;
    		
    		}
    	
    	else {
    		System.out.println("\nLogin Locked out User Failed");
    		
    		}
    	
    	  
    	LogoutButton.click();
    	
    	
    	
    	}
    	
    	catch (Exception ex)
    	{
    		
    		System.out.printf("\nCan't execute login Performance Glitch User function: " +ex);
    	}
    	
    	return value;

      
    }
    
 public Boolean  LoginLockedoutUser(String user, String passwd) {
    	
    	Boolean value = false;
    	int delay = 3000;
    	
    	try
    	
    	{
    	
    	System.out.printf("\nStarting Login Locked out User function now");
    	
    	System.out.printf("\nEnter username: " +user);
    	username.sendKeys(user);
    	
    	System.out.printf("\nEnter Password: " +passwd);
    	password.sendKeys(passwd);
    	
    	System.out.printf("\nClick Login button");   	
    	Thread.sleep(delay);
    	LoginButton.click();
    	
    	/**
    	System.out.printf("\nClick on Hamburger icon");   
    	Thread.sleep(delay);
    	hamburgericon.click();
    	
    	**/
    	
    	System.out.printf("\nPerforming validation");   
    	Thread.sleep(delay);
    	
    	
    	if(driver.getPageSource().contains("Epic sadface:")){
    		
    		System.out.println("\nLogin Locked out User Passed");
    		value = true;
    		
    		}
    	
    	else {
    		System.out.println("\nLogin Locked out User Failed");
    		
    		}
    	
    	  // Race condition for time to populate yourCommentsSpan
         //  WebDriverWait wait = new WebDriverWait(driver, 15);
        //   wait.until(ExpectedConditions.textToBePresentInElement(username, user));
    	
    //	LogoutButton.click();
    	
    	
    	
    	}
    	
    	catch (Exception ex)
    	{
    		
    		System.out.printf("\nCan't execute login Locked out User function: " +ex);
    	}
    	
    	return value;

      
    }
 
 
public Boolean LoginProblemUser(String user, String passwd) {
  	
  	Boolean value = false;
  	int delay = 3000;
  	
  	try
  	
  	{
  	
  	System.out.printf("\nStarting Login Problem User function now");
  	
  	System.out.printf("\nEnter username: " +user);
  	username.sendKeys(user);
  	
  	System.out.printf("\nEnter Password: " +passwd);
  	password.sendKeys(passwd);
  	
  	System.out.printf("\nClick Login button");   	
  	Thread.sleep(delay);
  	LoginButton.click();
  	
  	System.out.printf("\nClick on Hamburger icon");   
  	Thread.sleep(delay);
  	hamburgericon.click();
  	
  	System.out.printf("\nPerforming validation");   
 // 	Thread.sleep(delay);
  	
  	
if(driver.getPageSource().contains("Logout")){
	
			// Race condition for time to populate yourCommentsSpan
		    WebDriverWait wait = new WebDriverWait(driver, 15);
		    wait.until(ExpectedConditions.textToBePresentInElement(LogoutButton, "Logout"));		   		
  		System.out.println("\nLogin Problem User Passed");
  		
  		
  		value = true;
  		
  		}
  	
  	else {
  		System.out.println("\nLogin Problem User Failed");
  		
  		}
  	
  	  
  	LogoutButton.click();
  	
  	
  	
  	}
  	
  	catch (Exception ex)
  	{
  		
  		System.out.printf("\nCan't execute login Problem User function: " +ex);
  	}
  	
  	return value;

    
  }


    public String getSubmittedCommentText() {
        return username.getText();
    }

    public boolean isOnPage() {
        String title = "Swag Lab";
        return driver.getTitle() == title;
    }

}
