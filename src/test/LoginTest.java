package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Firefox
		//System.setProperty("webdriver.geckodriver.driver","geckodriver");
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://www.simplilearn.com/");
		
		
		//Chrome
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/"); //Website link
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS); // Wait for element to appear before throwing error (Implicit)
		
		driver.manage().window().maximize(); //Fit to Screen
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in")); // Will find Log in text
		
		WebDriverWait wait = new WebDriverWait(driver,30); // Wait for element to appear before throwing error (explicit) applies on individual element
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click(); // Click on Log in 
		
		WebElement UserName = driver.findElement(By.name("user_login")); // Will find login
		UserName.sendKeys("abc@xyz.com"); // email id
		
		WebElement Password = driver.findElement(By.id("password")); // Will find password
		Password.sendKeys("Simple@12"); // Password
		
		//WebElement Rememberme = driver.findElement(By.cssSelector(".rememberMe")); // Will find Remember me
		//Rememberme.click(); // Click on check box
		
		WebElement Rememberme = driver.findElement(By.className("rememberMe")); // Will find Remember me
		Rememberme.click(); // Click on check box
		
		WebElement LoginButton = driver.findElement(By.name("btn_login")); // Will find login button
		LoginButton.click(); // click on login
		
		WebElement Error = driver.findElement(By.id("msg_box")); //
		String ActualMsg = Error.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		if (ActualMsg.equals(ExpMsg)) {
			
			System.out.println("Test Passed");
			
		}else {
			
			System.out.println("Test Failed");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a")); // a -> input to get
		System.out.println("Total links are :" + Links.size());
		
		for (WebElement data : Links) {
			//System.out.println(data.getText()); //text
			System.out.println("Target Url is :" + data.getAttribute("href")); //Links
		}
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		/* WebElement ForgotPass = driver.findElement(By.partialLinkText("Forgot ")); // Will find Forgot password
		ForgotPass.click(); // Click on Forgot password */
		
		//Thread.sleep(5000);
		
		driver.quit(); // will close all tabs and release the RAM
		//driver.close(); // Will close current window and will not release the RAM
		
		

	}

}
