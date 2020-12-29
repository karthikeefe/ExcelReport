package TestMaven.TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class utils {
	
	public void movetoelement(WebDriver driver , WebElement elemnt) {
		Actions a = new Actions( driver);
		a.moveToElement(elemnt);

	}

}
