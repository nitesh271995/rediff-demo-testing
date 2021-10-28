package ppageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Baseclass;

public class rediff extends Baseclass{
	
	public rediff(WebDriver driver,WebElement element) {
		super(driver,element);
	}
	
	static By createAccount=By.linkText("Create Account");
	static By webpageValidation=By.cssSelector("td.f22");
	static By linkscount=By.tagName("a");
	static By termsandConditions=By.linkText("terms and conditions");
	
	public static WebElement createAccount() {
		element=driver.findElement(createAccount);
		return element;
	}
	public	static  WebElement webpageValidation() {
		element=driver.findElement(webpageValidation);
		return element;
	}
	public	static  List<WebElement> linkscount() {
		List<WebElement> tags=driver.findElements(linkscount);
				return tags;
	}
	
	public 	static WebElement termsandConditions() {
		element=driver.findElement(termsandConditions);
		return element;
	}
	
	

}
