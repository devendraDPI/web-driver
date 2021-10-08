package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.manage().window().maximize();
		
		WebElement Header = driver.findElement(By.xpath("//h2"));
		if(Header.isDisplayed()) {
			System.out.println("Header is displayed");
		}else {
			System.out.println("Hedaer not displayed");
		}
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println(UserName.getAttribute("placeholder"));
		UserName.sendKeys("abc@gmail.com");
		
		WebElement Password = driver.findElement(By.xpath("//*[@name='pass']"));
		System.out.println(Password.getAttribute("placeholder"));
		Password.sendKeys("asd@#515.");
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[@name='login']"));
		LoginButton.click();
		
		

		driver.quit();

	}

}
