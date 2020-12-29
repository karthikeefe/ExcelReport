package TestMaven.TestMaven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class Test1 extends POM{
	

	

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:/Users/karthikeyans.ka/eclipse-workspace/TestMaven/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		
		String current_window_id = driver.getWindowHandle();
		
		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'New Tab')]"));
		btn.click();
		
		System.out.println(driver.getWindowHandles());
		
		for(String s : driver.getWindowHandles()) {
			if(!s.equals(current_window_id)) {
				driver.switchTo().window(s);
			}
		}
		
		
		
		
	}
	
	
	
	
}
