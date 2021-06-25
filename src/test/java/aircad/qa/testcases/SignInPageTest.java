package aircad.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import aircad.qa.base.TestBase;
import aircad.qa.pages.HomePage;
import aircad.qa.pages.SignInPage;

public class SignInPageTest extends TestBase{

	
	SignInPage signInPage;
	HomePage homePage;
	
	public SignInPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		signInPage = new SignInPage();
		homePage = new HomePage();
		
	}
	
	@Test
	public void Title_SignInPage_Test(){
		
		String title = signInPage.Title_SignInPage();
	System.out.println(title);
		Assert.assertEquals(title, "Air Canada - The Official Website");
		
	}
	@Test
	public void SignIn_Test(){
		
		homePage = signInPage.validate_signIn_link(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	
	
	@AfterMethod
	public void TearDown(){
		
		driver.quit();
		
	}
	
}
