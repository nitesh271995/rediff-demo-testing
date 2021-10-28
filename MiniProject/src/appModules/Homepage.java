package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppageobjectmodel.rediff;
import utilities.Baseclass;
import utilities.ExcelUtils;

public class Homepage extends Baseclass
{

	public Homepage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	public static void execution(){
		rediff.createAccount().click();
		System.out.println(rediff.webpageValidation().getText());
		String[] links = new String[rediff.linkscount().size()];
		for (int i = 0; i < rediff.linkscount().size() - 1;i++) {
			WebElement linkurl = rediff.linkscount().get(i + 1);
			links[i] = linkurl.getAttribute("href");
		
			
		}
		ExcelUtils.writeExcel(links, "Details","Links");
		ExcelUtils.takeScreenShot("filepath");
		rediff.termsandConditions().click();
	}
}
