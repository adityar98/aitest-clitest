/* 
* File Name: Hooks.java
* Copyright 2015, Opex Software
* Apache License, Version 2.0
* This file contains the setup and teardown methods, browser initializations and screenshot functionality
*/

package com.java.DIG_cukes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;

public class Hooks {

	public static WebDriver driver;
	public String browser;
	public static Har har;
	public static BrowserMobProxy myProxy;

	

	// Contains declaration of all browsers (FF, Chrome, IE, Opera, Android)
	// This method is a hook which runs before every test
	@Before
	public void beforeEach() throws IOException, URISyntaxException {
		browser = System.getenv("BROWSER");
		
		System.out.println("Browser selected is " + browser);
		if (browser == null) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();	
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1400,600");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		if (browser.equalsIgnoreCase("Chrome")) {
			myProxy=new BrowserMobProxyServer();
			
			myProxy.start(0);
			
			//2. Set SSL and HTTP proxy in SeleniumProxy
			Proxy seleniumProxy=new Proxy();
			seleniumProxy.setHttpProxy("localhost:" +myProxy.getPort());
			seleniumProxy.setSslProxy("localhost:" +myProxy.getPort());
			
			//3. Add Capability for PROXY in DesiredCapabilities
			DesiredCapabilities capability=new DesiredCapabilities();
			capability.setCapability(CapabilityType.PROXY, seleniumProxy);
			capability.acceptInsecureCerts();
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
			//4. Set captureTypes
			EnumSet <CaptureType> captureTypes=CaptureType.getAllContentCaptureTypes();
			captureTypes.addAll(CaptureType.getCookieCaptureTypes());
			captureTypes.addAll(CaptureType.getHeaderCaptureTypes());
			captureTypes.addAll(CaptureType.getRequestCaptureTypes());
			captureTypes.addAll(CaptureType.getResponseCaptureTypes());
			
			//5. setHarCaptureTypes with above captureTypes
			myProxy.setHarCaptureTypes(captureTypes);
			
//			//6. HAR name
			myProxy.newHar("MyHAR");
//			

			
			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1400,600");
			chromeOptions.merge(capability);
			driver = new ChromeDriver(chromeOptions);
			System.out.println("Driver Capabilities===> \n" +((RemoteWebDriver)driver).getCapabilities().asMap().toString());

			driver.manage().window().maximize();
			

			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			
			
            myProxy=new BrowserMobProxyServer();
			
			myProxy.start(0);
			Proxy seleniumProxy=new Proxy();
			//6. HAR name
			myProxy.newHar("MyHAR");
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			myProxy.addRequestFilter(new RequestFilter() {
				   @Override
				    public HttpResponse filterRequest(HttpRequest request, HttpMessageContents contents, HttpMessageInfo messageInfo) {
				        // capture the request headers
				        Map<String, String> headers = (Map<String, String>) request.headers();
				        System.out.println("Request Headers: " + headers);
				        System.out.println("Request Headers");
				        return null;
				    }
				});
			myProxy.addResponseFilter(new ResponseFilter() {
				@Override
			    public void filterResponse(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
			        // capture the response headers
			        Map<String, String> headers = (Map<String, String>) response.headers();
			        System.out.println("Response Headers: " + headers);
			        System.out.println("Response Headers");

			        // capture the response body
			        String body = contents.getTextContents();
			        System.out.println("Response Body: " + body);
			    }
			});
			// get the Selenium proxy object
			Proxy seleniumProxy1 = ClientUtil.createSeleniumProxy(myProxy);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProxy(seleniumProxy1);
			// create a new FirefoxDriver using the FirefoxOptions
//			firefoxOptions.addArguments("--no-sandbox");
//			firefoxOptions.addArguments("--disable-dev-shm-usage");
			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("--window-size=1400,600");
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			List<String> args = Arrays.asList("--no-sandbox", "--disable-dev-shm-usage", "--headless");
			Map<String, Object> map = new HashMap<>();
			map.put("args", args);
			options.setCapability("ms:edgeOptions", map);
			driver = new EdgeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method kills the browser after the test is over
	// It also takes a screenshot and embeds it in the report if the test fails
	// This method is a hook which runs after every test
	@After
	public void afterEach(Scenario scenario) throws IOException {
				String status = scenario.getStatus();
				String scenario_name = scenario.getName();
				String new_scenario_name = scenario_name.replaceAll("\\s", "");
				System.out.println("scenario name="+scenario_name);
				System.out.println("scenario name="+new_scenario_name);
		System.out.println("scenario status:"+status);
		if (scenario.isFailed()) {
            har=myProxy.getHar();
            int num = (int)(Math.random() * 500 + 1);
            System.out.println("random number="+num);
			//File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/"+browser+"HAR"+num+".har");
			File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/HARFolder/Failed"+new_scenario_name+".har");
			har.writeTo(myHARFile);
			
			System.out.println("==> HAR details has been successfully written in the file when scenario failed.....");
			
			try {
				

				scenario.write("Current Page URL is " + driver.getCurrentUrl());

				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
		}
		else if(status.equals("passed"))
		{
			har=myProxy.getHar();
			int num = (int)(Math.random() * 100 + 1);
            System.out.println("random number="+num);
			//File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/"+browser+"HAR"+num+".har");
			File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/HARFolder/Passed"+scenario_name+".har");
			//File myHARFile=new File(System.getProperty("user.dir")+"/HARFolder/googleHAR.har");
			har.writeTo(myHARFile);
			
			System.out.println("==> HAR details has been successfully written in the file.....");
			try {
				

				
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				scenario.write("test case is pass successfuly  Screenshot is attached below");
				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
		
			
		driver.quit();

	}
	}
}

