package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement CreateAccount = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		CreateAccount.click();
		
		WebElement FirstName = driver.findElement(By.cssSelector("input[name=firstname]"));
		FirstName.sendKeys("ABCD");
		
		WebElement LastName = driver.findElement(By.cssSelector("input[name=lastname]"));
		LastName.sendKeys("WXYZ");
		
		WebElement Email = driver.findElement(By.cssSelector("input[name=reg_email__]"));
		Email.sendKeys("abcdwxyz@gmail.com");
		
		WebElement ReEmail = driver.findElement(By.cssSelector("input[name=reg_email_confirmation__]"));
		ReEmail.sendKeys("abcdwxyz@gmail.com");
		
		WebElement Password = driver.findElement(By.cssSelector("input[name=reg_passwd__]"));
		Password.sendKeys("s4d5@@,#");
		
		WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
		Select ddDay = new Select(Day); 
		ddDay.selectByVisibleText("15"); //desired day
		//ddDay.selectByValue("18");
		//ddDay.deselectByIndex(4);
		
		WebElement Months = driver.findElement(By.xpath("//select[@id='month']"));
		Select ddMonths = new Select(Months);
		ddMonths.selectByVisibleText("Aug");
		
		WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
		Select ddYear = new Select(Year);
		ddYear.selectByVisibleText("1947");
		
		WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		Female.click();
		if(Female.isSelected()) {
			System.out.println("Radio button selected");
		}else {
			System.out.println("Radio button not selected");
		}
		
		List<WebElement> Monthss = driver.findElements(By.xpath("//select[@id='month']/option"));
		for(int i=1;i<=Monthss.size();i++) {
			
			//WebElement data = driver.findElement(By.xpath("//select[@id='month']/option[" + i + "]"));
			//System.out.println(data.getText());
			
			System.out.println(Monthss.get(i).getText());
			
		}
		
		

	}

}
