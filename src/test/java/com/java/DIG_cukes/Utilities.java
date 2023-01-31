/* 
 * File Name: Utilities.java
 * Copyright 2015, Opex Software
 * Apache License, Version 2.0
 * This file contains the utility methods frequently used by the step definitions
 */


package com.java.DIG_cukes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.java.DIG_cukes.Hooks;



public class Utilities {


	private static final WebDriver driver = null;

	public static String generateRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
				.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		return sb.toString();
	}

	public static String generateRandomEmail() {
		String[] domain = { "@gmail.com", "@ymail.com", "@live.com",
				"@hotmail.com", "@yahoo.com", "@msn.com", "@google.com",
		"@rocketmail.com" };
		String[] midChars = { "_", "", ".", "-" };
		Random random = new Random();
		String domainName = domain[random.nextInt(domain.length)];
		String midCharInsert = midChars[random.nextInt(midChars.length)];
		return generateRandomString(random.nextInt(5) + random.nextInt(5) + 1)
				+ midCharInsert	+ 
				Utilities.generateRandomString(random.nextInt(5) + random.nextInt(5) + 1)
				+ domainName;
	}

	//Generate random number by sequence.
	public static String randomNumberGenerator(String maxNumber){
		if (maxNumber.equalsIgnoreCase("Ten")){
			//random numbers are 0,1,2,3 
			ArrayList<Integer> numbers = new ArrayList<Integer>();   
			Random randomGenerator = new Random();
			while (numbers.size() < 10) {
				int random = randomGenerator .nextInt(4);
				if (!numbers.contains(random)) {
					numbers.add(random);
				}
			}
		}
		return maxNumber;
	}

	//Generate random number generator.
	public static int rndmNumGen(int min, int max){
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static void doubleClickOnFile() throws InterruptedException
	{
		WebDriver driver = null;
		Actions action = new Actions (driver);
		action.doubleClick().build().perform();
		Thread.sleep(3000);
	}

	public static void clickOnElement(String parameter) {

		Hooks.driver.findElement(By.xpath(parameter)).click();
		sleepTime();
	}
	public static void enterText(String locater,String text) {
		Hooks.driver.findElement(By.id(locater)).sendKeys(text);
		sleepTime();
	}
	public static void enterTextUsingXpath(String locater,String text) {
		Hooks.driver.findElement(By.xpath(locater)).sendKeys(text);
		sleepTime();
	}

	//Date for today, tomorrow and yesterday
	public static String dateForTodayTomorrowAndYestderday(String expectingDate){
		String date = null;
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if (expectingDate.equalsIgnoreCase("Today")){
			Date today = calendar.getTime();
			date = dateFormat.format(today);
			System.out.println(date);
		} else if (expectingDate.equalsIgnoreCase("Tomorrow")){
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow = calendar.getTime();
			date = dateFormat.format(tomorrow);
			System.out.println(date);
		} else if (expectingDate.equalsIgnoreCase("Yesterday")){
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			Date yesterday = calendar.getTime();
			date = dateFormat.format(yesterday);
			System.out.println(date);
		} 
		return date;
	}
	//This method created to wait for element presence.
	public static WebElement waitForElementPresence(final By propertyValue){
		WebDriverWait wait = new WebDriverWait(Hooks.driver, 600);
		return wait.until(ExpectedConditions.presenceOfElementLocated(propertyValue));

	}

	//This method created to enter select parameter from drop down.
	public static void selectDropDownValue(String propertyValue, String parameter){
		//			Utilities.waitForElementPresence(propertyValue);
		new Select(Hooks.driver.findElement(By.xpath(propertyValue))).selectByVisibleText(parameter);
	}

	public static WebElement waitForElementPresence(final By propertyValue, long waitFor){
		WebDriverWait wait = new WebDriverWait(Hooks.driver, waitFor);
		return wait.until(ExpectedConditions.presenceOfElementLocated(propertyValue));
	}

	//This method created for get text.
	public static String getElementText(final By propertyValue){
		Utilities.waitForElementPresence(propertyValue);
		return Hooks.driver.findElement(propertyValue).getText();
	}

	//This method counting row.
	public static int countRow(final By propertyValue){
		Utilities.waitForElementPresence(propertyValue);
		//System.out.println("inside countRow function");
		List<WebElement> elements = Hooks.driver.findElements(propertyValue);
		//System.out.println(elements);
		int rowCount = elements.size();
		System.out.println("Number of Elements Displayed "+rowCount);
		return rowCount;
	}

	//This method created for check element is present.
	public static Boolean isElementPresent(final By propertyValue){
		Hooks.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean elementPresent = true;
		if (Hooks.driver.findElements(propertyValue).isEmpty()){
			elementPresent = false;
			System.out.println("Element Not Present.");
		};
		Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return elementPresent;

	}

	public static String currentMonth() {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };

		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];

		return month;
	}

	//This method created to wait for random second.
	public static void waitRandomMs(){
		Random random = new Random();
		int timeRange = 5000 - 2000 + 1;
		int waitTime = random.nextInt(timeRange) + 1000;
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Perform escape key.
	public static void hitEscapeKey() {
		Actions action = new Actions(Hooks.driver);
		//		waitLikeRealUser();
		waitRandomMs();
		action.sendKeys(Keys.ESCAPE).build().perform();		
	}
	
	//This method created to clear text on text box.
		public static void clearText(final By propertyValue){
			//		SwdFunctions.waitRandomMs();
			Utilities.waitForElementPresence(propertyValue);
			Hooks.driver.findElement(propertyValue).clear();
		}
		
		public static void doubleclick(WebElement name) {
			Actions action = new Actions (driver);
			action.doubleClick(name).perform();
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

