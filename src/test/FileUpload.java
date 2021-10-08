package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.monsterindia.com/seeker/registration");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// 1st Way
		/*WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
		file.sendKeys("/home/dindapawcisco/Downloads/Resume.txt");*/
		
		// 2nd Way
		WebElement file = driver.findElement(By.xpath("//*[@class='upload-file']"));
        file.click();
  
        // creating object of Robot class
        Robot rb = new Robot();
     
        // copying File path to Clipboard
        StringSelection str = new StringSelection("/home/dindapawcisco/Downloads/Resume.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
     
        // press Ctrl+v for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
     
        // release Ctrl+v for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
     
        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
		
		

	}

}
