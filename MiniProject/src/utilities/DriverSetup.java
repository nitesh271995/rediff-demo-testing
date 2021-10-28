package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup extends Baseclass{
	static String driverpath=System.getProperty("user.dir");
	static FileInputStream fis;
	static Properties p;
	public DriverSetup(WebDriver driver,WebElement element) {
		//
		super(driver,element);
	}

public static void Initiate(int i) throws FileNotFoundException {
		switch (i) {
		case 1:
			System.setProperty("webdriver.chrome.driver", driverpath+"\\Drivers\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fis=new FileInputStream(driverpath+"\\Resources\\data.properties");
			p=new Properties();
			driver.get(p.getProperty("baseurl"));
			
		case 2:
			//firefox code
		case 3:
			//IE code
		}
			
	}
public static void Kill() {
	driver.close();
}
}
