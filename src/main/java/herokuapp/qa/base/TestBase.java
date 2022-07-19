package herokuapp.qa.base;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;


	@BeforeClass
	public void setUp() throws Exception {		
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "/Users/onomoh1/Desktop/Automation-Projects/Herokuapp/Drivers/chromedriver");
		
		//Creating an object of ChromeDriver
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		//Specifying pageLoadTimeout and Implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//launching the specified URL
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("URL inputted");
	}


	
	@AfterClass
	public void tearDown () {
		
		driver.quit();
		
		System.out.println("Test Executed Successfully");
		}
	}



