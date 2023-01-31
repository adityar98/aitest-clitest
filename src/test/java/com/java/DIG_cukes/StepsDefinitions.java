
package com.java.DIG_cukes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;


public class StepsDefinitions {	
	public static WebDriver driver;
	private String testdriveURL;
//	public static Har har;
//	public static BrowserMobProxy myProxy;
	public static String currentDate= Utilities.dateForTodayTomorrowAndYestderday("Today");
	public static String firstname = "Automation"+Utilities.rndmNumGen(1, 100000);
	//	public static String firstname = "Automation12366";
	public static String commEmailID = "cucumber.automation+"+Utilities.rndmNumGen(1, 100000)+"@gmail.com";
	public static String scheduleName = "ScheduleAutomation"+Utilities.rndmNumGen(1, 100000);
	static String updateddate="";
	static String randomString="";
	static String assistantname="";
	//add new
	public StepsDefinitions()
	{
		//testdriveURL = "https://dev.docuphase-erp.com/";
		testdriveURL = System.getenv("TESTDRIVE_URL");
		if(testdriveURL == null){
			testdriveURL = System.getenv("TEST_URL");
		}
		driver = Hooks.driver;
	}



	@Given("^I on Docuphase Login Page$")
	public void i_on_Docuphase_Login_Page() throws Throwable {
	   driver.get("https://dev.docuphase-erp.com/");
	   //Hooks.harfile();
	  
	}
	

	
	@Given("^I enter (.*) and (.*)$")
	public void i_enter_username_as_and_password_as(String username, String password) throws Throwable {
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	}

	


	@When("^I click on Dlogin button$")
	public void i_click_on_Dlogin_button() throws Throwable {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
    
	@Then("^I should be on homepage page$")
	public void i_should_be_on_homepage_page() throws Throwable {
	    Thread.sleep(5000);
	    String login_url = driver.getCurrentUrl();
	    Assert.assertEquals(login_url, "https://dev.docuphase-erp.com/");
	}
	
	
	@Given("^I m on Docuphase login page$")
	public void i_m_on_Docuphase_login_page() throws Throwable {
		driver.get("https://dev.docuphase-erp.com/");
	//Hooks.harfile();
		
	}


	@When("^I enter adminid as \"([^\"]*)\"$")
	public void i_enter_adminid_as(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}
	
	@When("^I enters pswd as \"([^\"]*)\"$")
	public void i_enters_pswd_as(String pwd) throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd); 
	}
	
	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Hooks.harfile();
	}


	
	@Then("^then I will be on Docuphase homepage$")
	public void then_I_will_be_on_Docuphase_homepage() throws Throwable {
		Thread.sleep(5000);
		  
	    String flow_url = driver.getCurrentUrl();
	    Assert.assertEquals(flow_url, "https://dev.docuphase-erp.com/flows");
//	    File myHARFile=new File(System.getProperty("user.dir")+"/HARFolder/googleHAR1.har");
//	    har.writeTo(myHARFile);
//		
//		System.out.println("==> HAR details has been successfully written in the file.....");
	    
	}
	
	



	static void sleepTime(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}