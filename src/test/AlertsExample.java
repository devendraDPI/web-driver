package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement Button1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
		Button1.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();  // Clicks on OK
		
		WebElement Button4 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		Button4.click();
		Alert alert4 = driver.switchTo().alert();
		alert4.sendKeys("ABCD");
		alert4.accept();
		
		
		
		
		
		
		
		

	}

}
