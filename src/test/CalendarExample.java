package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// 1st Way
		/*driver.switchTo().frame(0);
		
		WebElement date = driver.findElement((By.id("datepicker")));
		date.sendKeys("10/15/2021"); */
		
		//2nd Way
		/*driver.switchTo().frame(0);
		
		WebElement date = driver.findElement(By.id("datepicker"));
		date.click();
		
		WebElement day = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='18']"));
		day.click();*/
		
		//3rd Way
		driver.switchTo().frame(0);
		WebElement date = driver.findElement(By.id("datepicker"));
		date.click();
		
		WebElement arrow = driver.findElement(By.xpath("//a[@title='Next']"));
		WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		
		String sMonth = month.getText();
		
		while(!sMonth.equals("December")) {
			
			arrow.click();
			month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			arrow = driver.findElement(By.xpath("//a[@title='Next']"));
			sMonth = month.getText();
			
		}
		
		WebElement day = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		day.click();
			
		

	}

}
