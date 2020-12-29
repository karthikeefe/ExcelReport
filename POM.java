package TestMaven.TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class POM {

	
	@FindBy(xpath = "//input[@id='userName']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@id='login']")
	public WebElement login;
	
	@FindBy(xpath = "(//span[text()='Intermediary Login'])[2]")
	public WebElement intermediary;
	
	@FindBy(xpath = "(//span[text()='Surveyor'])[2]")
	public WebElement surveyor;
	
	@FindBy(xpath = "(//a[text()='Login'])[2]")
	public WebElement survlogin;
	
	@FindBy(xpath ="(//a[text()='Close'])[1]")
	public WebElement close;
	
	@FindBy(xpath = "//span[text()='Draggable 4']")
	public WebElement drag;
	
	@FindBy(xpath = "//div[@id='mydropzone']")
	public WebElement drop;

}
