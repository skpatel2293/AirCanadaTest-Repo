package aircad.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aircad.qa.base.TestBase;

public class SignInPage extends TestBase  {
	
	
// Page Factory ---- Object Repository -----
	
		@FindBy(name = "username")
		WebElement username;	
		
		@FindBy(name = "password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement signin_btn; 
		
		
// Initialization Page Objects
		public SignInPage(){
			
			PageFactory.initElements(driver, this);
		}
	
		public HomePage validate_signIn_link(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			signin_btn.click();
			return new HomePage();
			
		}
		public String Title_SignInPage(){
			
			return driver.getTitle();
			
		}

}
