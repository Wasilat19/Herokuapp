package herokuapp.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import herokuapp.qa.base.TestBase;


public class ValidLoginTest extends TestBase {

	@Test (description = "Valid Login test with valid login credentials")
	public void ValidloginTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
		System.out.println("User clicks on Form Authentication");

		driver.findElement(By.id("username")).sendKeys("tomsmith");
		System.out.println("User enters a valid username into the textbox");

		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		System.out.println("User enters a valid password into the textbox");


		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
		System.out.println("User clicks Login button");


		//This will assert success message
		String actual_msg= driver.findElement(By.id("flash-messages")).getText();
		String expect="You logged into a secure area!\n"
				+ "×";
		Assert.assertEquals(actual_msg, expect);
		System.out.println("Success message asserted");

		Thread.sleep(3000);


	}

}

