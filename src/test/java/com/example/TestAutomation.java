package com.example;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class TestAutomation {

	public static WebDriver driver;
	public WebElement webElement;
	public static AutoItX x;

	@BeforeClass
	public static void setUpBeforeClass() {

		configure();
	}

	@Before
	public void beforeTest() {
		
		if(TestCommons.WEBDRIVER_TO_USE.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (TestCommons.WEBDRIVER_TO_USE.equals("gecko")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		x = new AutoItX();
	}

	@After
	public void afterEachTest() {
		driver.close();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		driver.quit();
	}

	private static void configure() {

		String pathToJacobLibrary;
		String pathToChromeDriver;
		String pathToGeckoDriver;

		if (jvmBitVersion().contains("32")) {
			pathToJacobLibrary = TestCommons.JACOB_DLL_FILE_X86;
			pathToChromeDriver = TestCommons.PATH_TO_CHROMEDRIVER_X86;
			pathToGeckoDriver = TestCommons.PATH_TO_GECKODRIVER_X86;
		} else {
			pathToJacobLibrary = TestCommons.JACOB_DLL_FILE_X64;
			pathToChromeDriver = TestCommons.PATH_TO_CHROMEDRIVER_X64;
			pathToGeckoDriver = TestCommons.PATH_TO_GECKODRIVER_X64;		
		}

		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
		File file = new File(pathToJacobLibrary);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

	}

	public static String jvmBitVersion() {
		return System.getProperty("sun.arch.data.model");
	}
	
	protected static void sleep(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}