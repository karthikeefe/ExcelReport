package TestMaven.TestMaven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Whatisselenium extends Stopinher {
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		Stopinher excel = new Stopinher();
		try {
		//Stopinher excel = new Stopinher();
		excel.addTestResult_into_excelsheet();
	//excel.addimage_inexcel();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\karthikeyans.ka\\eclipse-workspace\\TestMaven\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		excel.testReport.add(new Object[] { "Test login", "Navigate to demo website", "Site gets opened","Chrome", "Pass","","./img.jpg" });
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	excel.testReport.add(new Object[] { "Test Login", "Navigate to login", "Loginpage gets opened","Chrome", "Fail","","./img.jpg" });
	/*WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.urlContains("/login"));
	
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("karthiece93@gmail.com");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Karthi@1993");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	wait.until(ExpectedConditions.urlContains("/account"));
	
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Logout']")).click();*/
	excel.addimage_inexcel();
	driver.quit();
	}catch (Exception e) {
		excel.testReport.add(new Object[] { "Test Login", "Navigate to login", "Loginpage gets Exception","Chrome", "Fail",e,"./img.jpg" });
	}
	}

}
