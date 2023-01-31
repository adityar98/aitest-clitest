package com.java.DIG_cukes;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;

public class OracleFlow {
	public static WebDriver driver;
	public static Har har;
	public static BrowserMobProxy myProxy;
	
	Hooks hook=new Hooks();
	
	@Then("^I clcik on Create flow button$")
	public void i_clcik_on_Create_flow_button() throws Throwable {
		Hooks.driver.findElement(By.xpath("(//button[normalize-space()='Create Flow'])[1]")).click();
		//Hooks.harfile();
	}

	@Then("^Clicked on OracleNS button$")
	public void clicked_on_OracleNS_button() throws Throwable {
		Hooks.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div")).click();
		String Error_msg=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
		System.out.println("error message"+Error_msg);
		Thread.sleep(5000);
		Assert.assertEquals(Error_msg, "Please provide flow name.");    
	}
    
	@Then("^I entered flow name \"([^\"]*)\"$")
	public void i_entered_flow_name(String arg1) throws Throwable {
		Hooks.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/input")).sendKeys(arg1);
	}
    
	@When("^Clicked on OracleNS button for next page$")
	public void clicked_on_OracleNS_button_for_next_page() throws Throwable {
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("//img[@alt='erpLogo']")).click();
		
	}

	@Then("^I click on Next button without Adaptor action$")
	public void i_click_on_Next_button_without_Adaptor_action() throws Throwable {
	    //Hooks.driver.findElement(By.id("nextButton")).click();//clicked on next btn
	    Hooks.driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    //String Error_msg2=Hooks.driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]")).getText();
	    String Error_msg2=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
	    Thread.sleep(5000);
		Assert.assertEquals(Error_msg2, "Please provide action.");
	}
     
	@Then("^I enter existing flowname \"([^\"]*)\"$")
	public void i_enter_existing_flowname(String arg1) throws Throwable {
	    Hooks.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div")).click(); //Clicked on OracleNS button
	    Thread.sleep(3000);
	    Hooks.driver.findElement(By.xpath("(//*[name()='svg'][@stroke='currentColor'])[2]")).click();  //click on back button
	    Hooks.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/input")).sendKeys(arg1); 
	}

	
	@Then("^Click on OracleNS button$")
	public void click_on_OracleNS_button() throws Throwable {
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div")).click(); //Clicked on OracleNS button
		Thread.sleep(2000);
		String Error_msg3 =Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
		System.out.println("Error handler="+Error_msg3);
	    Assert.assertEquals(Error_msg3, "Please assign a new name to flow");
	}
	
	@Then("^I clicked on dropdown action$")
	public void i_clicked_on_dropdown_action() throws Throwable {
	    Hooks.driver.findElement(By.xpath("//div[@id='demo-simple-select']")).click();//clicked on dropdown btn
	}
	
	@Then("^I Select Create Customer action & clicked on next btn$")
	public void i_Select_Create_Customer_action_clicked_on_next_btn() throws Throwable {
	    Hooks.driver.findElement(By.xpath("//li[normalize-space()='Create Customer']")).click();//clicked on create customer action from dropdown
	    Thread.sleep(5000);
	    Utilities.clickOnElement("(//button[@type='button'])[2]");
	}

	@When("^I click on SignIn To Oracle Adaptor$")
	public void i_click_on_SignIn_To_Oracle_Adaptor() throws Throwable {
	    Hooks.driver.findElement(By.xpath("(//p[normalize-space()='Sign in to Oracle Adapter'])[1]")).click();//clicked on oracle signin to Oracle adpator btn
	}

	@Then("^I filled valid OAuth  Details$")
	public void i_filled_valid_OAuth_Details() throws Throwable {
		String brow = System.getenv("BROWSER");
		boolean name = brow.equalsIgnoreCase("chrome");
		boolean namec= brow.equalsIgnoreCase("chromeheadless");
		boolean Chrome= name || namec;
		if(Chrome==true)
		{
		
		Hooks.driver.findElement(By.xpath("(//textarea[@name='client_certificate_pem_file_content'])[1]")).sendKeys("-----BEGIN PRIVATE KEY-----\r\n"
				+ "MIIG/wIBADANBgkqhkiG9w0BAQEFAASCBukwggblAgEAAoIBgQDE4QGM1zWfBFIl\r\n"
				+ "R0AJ37Ki3kD2uGb/NE1K+3vhh3FGlLNbxJrh+OnIzZb0wcfWHVMlhS2gWjdm7zwl\r\n"
				+ "QdOizSYA+CO8QpYKB9sLn5mw1SG8oA8hwpPAA7VxVbtKOshYHBty+zItDyFv+VEs\r\n"
				+ "ih4SqzXjHdyCD0FluB13eV5ReHRk+agDToDGAR6AkG5SYDn5otaNpKH6j8/gRgdX\r\n"
				+ "BpM7YluptLwuKVHeTq9dtM14CewBEV1ExnF0Yrb3QCSmrz2SLIWezSdwg5nxrQPy\r\n"
				+ "5gcGjPGyhyW+6H/971YdC5lFOBHaluzh+/hWWnCHlhiUordxB+z5l0USzNECZYZR\r\n"
				+ "+rp8s6QvmmSpIMI23uK/wlW+zbOvxR+mYzlpL1N2QHYEnVtshOPxqTCPCcLD0QW5\r\n"
				+ "Xsi1Nc7LZD1LF1wAPPNN5RysRYu+orqge/bXbNqY2YhNFSdFRknOTHwkln62eFVB\r\n"
				+ "L7iU3E7xksafwl6QTCYWWpaCzJadD9Jj/LaVzI76cDdDPYoUvL8CAwEAAQKCAYEA\r\n"
				+ "guvRuRO/z5/y9GE+H5LHWvELKEYWD+163LsBdUc5N6NY5lSGXnDFHkhA80ANoL/d\r\n"
				+ "c9ztK23y25uJVolAsElV1V0tflqVJdR1gHRAoswIZEPX7C5VTGHq/ZPyOPmAEr+W\r\n"
				+ "LU8H3djq9mhH56NtPiLmccKAyWhVp8vYpINsCidc120BojlI/uLtorbo9hSRWQVF\r\n"
				+ "QenR4SpTJSPMa72umNXeeKr8XIITtA6FJX4/CG0oqMkgScTg23FtlFvuQ33TJuo9\r\n"
				+ "QgvEwuVrz/Scb0rlkHYftnTB/0CVc6e049c3jzgt3YtvR/9f8biKEL4N3Ly5R5lY\r\n"
				+ "gtfeYY7AGYL7v9xx0nBNO0nd7tqXyRQ9ft3RMWhnkYcXZKgdBlXHvHS5w44P0m3K\r\n"
				+ "s3chtAofs530J3CouUg6htGTk6nvDbB3iwQLRflm2yw2eN8qMpbQ77P4BJs1iTmj\r\n"
				+ "CG+wRroQXFcMH10M5rgeqOpQAIEM/4ZEhbQL6hfClGtHLayuj60zQA/Io+OYIU2B\r\n"
				+ "AoHBAOzJHHsSV48fNQd9daPbzATxmb+0fdxOt2R5flzRIKwtFXBVBvOM93pZEAsW\r\n"
				+ "LOrFsNpwLNUBILkvWQmlOT3KrnrcgIgPGCQOXfSnOaud8Z/PzLuV4b2L1bja4lpg\r\n"
				+ "OFIHbHo5ghtUx2fbfUj2Aam7zzoLMZPoCnfngaZpKTA+SYPKNl9q98Kc+BcAU5RH\r\n"
				+ "X2/VZllkpfQJD22yEOLAb+r+o5EaFwsul99pIgS3UPbeNVNpWtlkyUdvRg1YZoss\r\n"
				+ "gXDyQQKBwQDU2uPNyQC0SLDrxs6oBqrezPdtuKdPaM0JAqIdoQliYUi0yJiZGyRH\r\n"
				+ "2AM3cWcPfHnhjfF+QenEwXBgrlvRCKuTuQarrvIuJAoZmxU38XsUcrgctKZH+r6z\r\n"
				+ "SOLmO3L0EFqoifwZ2H+RzaYnaabcYk8h50eEwKVXQJ/tfo65wWkZ9khp/NYFzDdc\r\n"
				+ "mGkBCVrmysdUuRMSjSV3vFTKXuG6EQxStuMsgVKUadIfFg9haoyRMSbCwbnPvMZl\r\n"
				+ "UwW2G+yb7v8CgcEAuw5hVoR18VXI8cLV9X2E3f7y4/Q1XZ492Lz162M2OW5gOl6h\r\n"
				+ "YDPjqZ7EQs3g7BMClH37nMYIUOMrpqgE4WDFl7+sNlAeVRWYedbFg2MB56skZKiS\r\n"
				+ "LchTLXaVTKoos/yzYJcfxnGiGdTWU5YsWCdLHOKM5vhvlKupy4nWBQufzeIoNBbv\r\n"
				+ "5alVf+49GK2Nom5mLYaKZ4/kxVbfahJ2F6HUG6QNwkKrrc2DF1CuQGfonp1jLMwn\r\n"
				+ "CizInXBRie69zzlBAoHASYtn8o5kw+Xp201R0hSbrWe8hhirFnDrhxV11i7yAyAB\r\n"
				+ "8xTsRNpv6rLkSZ/RMDSeGCTnL+yuTOFZZs5Xwx3vypa/i0pjOzYQl1BSQIYbNLF+\r\n"
				+ "k8yHN4+XnHKuk0YvLc0IxfsHNBbt3P7lTfDfSn5dQSWcPG4jssYNfA2iWuRM4D+M\r\n"
				+ "PbKycEZjSocOoOEOm3es78USpfJG49wan+GwtI13aIzwaUw1sDnv8/W3Ur1x3CjT\r\n"
				+ "b69n+DMNiazp6EY1tpsZAoHBANl3QW7/hIReYXU3J0e9IDkX5klKcKAam9LeQ6CL\r\n"
				+ "UcDM0Rf4yL7tieltZYnj/U4EcwVA5o/GqCoXoSG3tproS5/ErF0/PyJ+M7N2Vjnq\r\n"
				+ "8YvRmrVlQaJc/xR/SqhKWGGq3eaBvX14ic1MJKyVUfW3M0MYkJ3dQSAYaCHahNSW\r\n"
				+ "Ir9E2C5q82wPY7vg6pCrM3vSbKuxHhhog5PeQofqpBbxV+qR9/QZ3+GBD06fEVHO\r\n"
				+ "gicZyI923eeNMH4br1DMoPk6Dw==\r\n"
				+ "-----END PRIVATE KEY-----");
		}
		else if (Chrome==false) {
			System.out.println("browser selected is Firefox");
		}
		
		boolean ffname = brow.equalsIgnoreCase("firefox");
		boolean nameffh= brow.equalsIgnoreCase("firefoxheadless");
		boolean Firefox= ffname || nameffh;
		//System.out.println("chrome browser result="+Firefox);
		 if(Firefox==true)
		{
			Hooks.driver.findElement(By.xpath("(//textarea[@name='client_certificate_pem_file_content'])[1]")).sendKeys("-----BEGIN PRIVATE KEY-----\r"
					+ "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\r"
					+ "gicZyI923eeNMH4br1DMoPk6Dw==\r"
					+ "-----END PRIVATE KEY-----");
		}
		
		
		Hooks.driver.findElement(By.xpath("//textarea[@name='erp_acc_endpoint']")).sendKeys("https://TSTDRV1667270.suitetalk.api.netsuite.com");
		Hooks.driver.findElement(By.xpath("//textarea[@name='client_certificate_id']")).sendKeys("y_3ax_vwj1CsGDUbFN2vidHwAHmy58qcyGlKc1M-ILI");
		Hooks.driver.findElement(By.xpath("//textarea[@name='token_url']")).sendKeys("https://tstdrv1667270.suitetalk.api.netsuite.com/services/rest/auth/oauth2/v1/token");
		Hooks.driver.findElement(By.xpath("//textarea[@name='client_id']")).sendKeys("76385a230f853a77ffaa341ef9d1b6d34130519e0c1efc221ae1ec172d06f3d0");
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	}
	
	@Then("^I create filter$")
	public void i_create_filter() throws Throwable {
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter Field']")).sendKeys("cname");// enter the values in create filter field
		Hooks.driver.findElement(By.xpath("//div[@id='mui-component-select-selectCondition']")).click();
		Hooks.driver.findElement(By.xpath("//li[normalize-space()='equal to']")).click();
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter Select Value']")).sendKeys("tcs");// enter the values in create filter field
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();//clicked on next btn
	    
	}
	
	@Then("^I added adaptor mapping$")
	public void i_added_adaptor_mapping() throws Throwable {

		
		Actions actions= new Actions(Hooks.driver);
		actions.click(Hooks.driver.findElement(By.xpath("//div[@class='ace_content']")))
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
	    .build()
	    .perform();
		Thread.sleep(2000);
		
		Hooks.driver.switchTo().activeElement().sendKeys("{\"entityid\": \"Anjali\",\r\n"
				+ "\"companyname\": \"tests\",\r\n"
				+ "\"subsidiary\": {\r\n"
				+ "\"id\": \"2\"\r\n"
				+ "}");
		Thread.sleep(3000);//it will enter input json
		Hooks.driver.findElement(By.xpath("(//button[@type='button'])[13]")).click(); //click on next btn
	}
	
	
	@Then("^I was on response mapping page and clicked on save button$")
	public void i_was_on_response_mapping_page_and_clicked_on_save_button() throws Throwable {
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Create']")).click(); //clicked on create btn of response mapping
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Close']")).click(); //clicked on close btn of popup
	}
	
	@Then("^I goto homepage and search for the flowname \"([^\"]*)\"$")
	public void i_goto_homepage_and_search_for_the_flowname(String arg1) throws Throwable {
	    Hooks.driver.findElement(By.xpath("//img[@alt='LOGO']")).click(); //clicked on Docuphase img
	    Thread.sleep(2000);
	    Hooks.driver.findElement(By.id("text_id_undefined")).sendKeys(arg1);
	}
	    
	
	
	@Then("^I clicked on clone icon and clone the flow$")
	public void i_clicked_on_clone_icon_and_clone_the_flow() throws Throwable {
		Hooks.driver.findElement(By.xpath("//span[@aria-label='Clone Flow']//button[@type='button']")).click();//click on clone icon
		Utilities.enterTextUsingXpath("//input[@id='flowName']", "clone2");//enter text in clone popup field
	    Thread.sleep(2000);
	    Utilities.clickOnElement("//button[normalize-space()='Clone']"); //clicked on clone btn
	    Thread.sleep(2000);
	    String Error_msg6=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
	    Thread.sleep(2000);
	    Assert.assertEquals(Error_msg6, "Flow Cloned Successfully");
	}
	
	@Then("^I searched for cloned flow \"([^\"]*)\"$")
	public void i_searched_for_cloned_flow(String clone_name) throws Throwable {
		Thread.sleep(2000);
		Hooks.driver.findElement(By.id("text_id_undefined")).sendKeys(clone_name);
	}
	
	@Then("^Again search flowname \"([^\"]*)\"$")
	public void again_search_flowname(String flowname) throws Throwable {
		Hooks.driver.findElement(By.id("text_id_undefined")).sendKeys(flowname);
	}

	
	
	@Then("^I click on delete icon and deleted flow$")
	public void i_click_on_delete_icon_and_deleted_flow() throws Throwable {
		Thread.sleep(2000);
	    Utilities.clickOnElement("(//*[name()='svg'][@stroke='currentColor'])[7]"); //click on delete icon
	    Thread.sleep(2000);
	    Utilities.clickOnElement("//div[@role='presentation']//button[2]"); //click on delete confirmation btn
	    String Error_msg7=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
	    Assert.assertEquals(Error_msg7, "Flow object has been updated for delete");
	 
	}
	
	
	@Then("^I clicked on edit button checked$")
	public void i_clicked_on_edit_button_checked() throws Throwable {
		Utilities.clickOnElement("(//*[name()='svg'][@stroke='currentColor'])[5]"); //click on edit btn
	}
	
	@Then("^I added adaptor mapping and generate mapping$")
	public void i_added_adaptor_mapping_and_generate_mapping() throws Throwable {
		Actions actions= new Actions(Hooks.driver);
		actions.click(Hooks.driver.findElement(By.xpath("//div[@class='ace_content']")))
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
	    .build()
	    .perform();
		Thread.sleep(2000);
		
		Hooks.driver.switchTo().activeElement().sendKeys("{\"entityid\": \"Anjali\",\r\n"
				+ "\"companyname\": \"tests\",\r\n"
				+ "\"subsidiary\": {\r\n"
				+ "\"id\": \"2\"\r\n"
				+ "}");
		Thread.sleep(8000);
		Utilities.clickOnElement("//p[normalize-space()='Click Here']");
		Thread.sleep(15000);
		Utilities.clickOnElement("//button[normalize-space()='Generate Mapping']");
		Thread.sleep(5000);
		Utilities.clickOnElement("(//button[@type='button'])[16]");
	}

	@Then("^I was on response mapping page and clicked on continue button and publish flow$")
	public void i_was_on_response_mapping_page_and_clicked_on_continue_button_and_publish_flow() throws Throwable {
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Create']")).click(); //clicked on create btn of response mapping
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click(); //clicked on continue btn of popup
		String Error_msg8=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
		Thread.sleep(3000);
		System.out.println("Published flow msg="+Error_msg8);
		boolean alert_msg = Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).isDisplayed();
		Assert.assertTrue(alert_msg);
	}
	
	@Then("^I will click on  re-auth button to reauthorize it\\.$")
	public void i_will_click_on_re_auth_button_to_reauthorize_it() throws Throwable {
		Utilities.clickOnElement("(//*[name()='svg'][@stroke='currentColor'])[8]");
		Thread.sleep(3000);
		Utilities.clickOnElement("//button[normalize-space()='Submit']");//clicked on OAuth submit btn
		String Error_msg9=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
	    Assert.assertEquals(Error_msg9, "Flow re-Authorize Successfully");
	}
	
	@Then("^I clicked on next button without adding fliter$")
	public void i_clicked_on_next_button_without_adding_fliter() throws Throwable {
	    Utilities.clickOnElement("(//button[@type='button'])[6]");//click on next btn
	}

	@Then("^I clicked on publish button to unpublish flow$")
	public void i_clicked_on_publish_button_to_unpublish_flow() throws Throwable {
	    Utilities.clickOnElement("//input[@aria-label='Demo switch']");
	    Thread.sleep(2000);
	    Utilities.clickOnElement("//div[@role='presentation']//button[2]");//clciked on upublished popup btn
	    String Error_msg10=Hooks.driver.findElement(By.xpath("(//div[@class='MuiAlert-message'])[1]")).getAttribute("innerHTML");
		Thread.sleep(3000);
		System.out.println("unpublished msg="+Error_msg10);
	    
	    Assert.assertEquals(Error_msg10, "Flow unpublished successfully");
	}
	
	@Then("^I added response mapping and created flow$")
	public void i_added_response_mapping_and_created_flow() throws Throwable {
		Actions actions= new Actions(Hooks.driver);
		actions.click(Hooks.driver.findElement(By.xpath("//div[@class='ace_content']")))
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
	    .build()
	    .perform();
		Thread.sleep(2000);
		
		Hooks.driver.switchTo().activeElement().sendKeys("{ \"error_type\": \"sample\", \"error_title\":\"sample\", \"message\": \"Success\",\r\n"
				+ "  \"code\":\"200\"}");
		Thread.sleep(8000);
		Utilities.clickOnElement("//p[normalize-space()='Click Here']");
		Thread.sleep(10000);
		Utilities.clickOnElement("//button[normalize-space()='Generate Mapping']");
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Create']")).click(); //clicked on create btn of response mapping
		Thread.sleep(2000);
		Hooks.driver.findElement(By.xpath("//button[normalize-space()='Close']")).click(); //clicked on continue btn of popup
	}
	
	@Then("^I clicked on re-auth button$")
	public void i_clicked_on_re_auth_button() throws Throwable {
	   boolean reauth_btn= Hooks.driver.findElement(By.xpath("(//button[@type='button'])[7]")).isEnabled();
	   System.out.println("re-auth button is clicked"+reauth_btn);
	   Assert.assertTrue(reauth_btn);
	   
	}
	
	@Then("^I will check number of row in page$")
	public void i_will_check_number_of_row_in_page() throws Throwable {
	    int num_of_rows= Utilities.countRow(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-hover']"));
	    String num="1-"+num_of_rows+" of "+num_of_rows;
	    //System.out.println(num);
	    String Actual_rows=Hooks.driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTablePagination-caption MuiTypography-body2 MuiTypography-colorInherit'][2])")).getText();
	    //System.out.println("Actual row count"+Actual_rows);
	    Assert.assertEquals(num, Actual_rows);
	}

	  

	

	static void sleepTime(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
