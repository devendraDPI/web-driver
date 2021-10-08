package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement Link = driver.findElement(By.linkText("Terms of Use"));
		String KeystoSend = Keys.chord(Keys.CONTROL, Keys.ENTER);
		Link.sendKeys(KeystoSend);

		ArrayList<String> allWindows = new ArrayList<String> (driver.getWindowHandles());
		
		for(String window:allWindows) {
			
			System.out.println(window);
			
		}
		
		driver.switchTo().window(allWindows.get(1));
		WebElement element = driver.findElement(By.tagName("h1"));
		System.out.println(element.getText());
		//driver.close();
		//driver.switchTo().window(allWindows.get(0));
		driver.quit();

	}

}
