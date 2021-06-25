package aircad.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import aircad.qa.util.Testutil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\workspace\\AirCanadaTest\\src\\main\\java\\aircad\\qa\\config\\config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
		
	}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Testing\\SW\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "D:\\Testing\\SW\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOUD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
