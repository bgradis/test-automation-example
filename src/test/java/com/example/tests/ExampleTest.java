package com.example.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import com.example.TestAutomation;

import autoitx4java.AutoItX;

public class ExampleTest extends TestAutomation {
	
	/***
	 * Test case 1
	 * Check if Wikipedia has proper title
	 */
	@Test
	public void Test1() {
		
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
		
	}
	
	/***
	 * Test case 2
	 * Copy of Test case 1 with false data
	 */
	@Test
	public void Test2() {
		
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		assertEquals("Wikipedia", driver.getTitle());
		
	}
	
	/**
	 * Test case 3
	 * Login to facebook
	 */
	@Test
	public void Test3() {
		
		driver.get("https://www.facebook.com/");
		webElement = driver.findElement(By.id("email"));
		webElement.sendKeys("example@example.com");		
		webElement = driver.findElement(By.id("pass"));
		webElement.sendKeys("password");		
		webElement.submit();
		
		sleep(10000);
		
	}
	
	/**
	 * Test case 4
	 * Run notepad from test using AutoIt
	 */
	@Test
	public void Test4() {
		
		x.run("notepad.exe", "C:/Windows/System32", AutoItX.SW_SHOW);
		x.winWaitActive("Untitled - Notepad");
		x.send("This is example text");
		x.winClose("Untitled - Notepad");
		x.winWaitActive("Notepad", "Save");
		x.send("!n");
	}

}
