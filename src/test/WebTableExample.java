package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// Number of Rows
		List<WebElement> TableRows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("Rows : " + TableRows.size());
		
		// Number of Columns
		List<WebElement> TableColumns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("Columns : " + TableColumns.size());
		
		// 1st Column 3rd Row
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		System.out.println(data.getText());
		
		// 1st Column All Rows
		for(int i=2;i<=TableRows.size();i++) {
			
			WebElement Columndata = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[1]"));
			System.out.println(Columndata.getText());
			
		}
		
		// Scroll
		WebElement elem = driver.findElement(By.xpath("//*[text()='Define an HTML Table']"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elem);
        
  

	}

}
