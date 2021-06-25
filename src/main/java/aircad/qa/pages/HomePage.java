package aircad.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aircad.qa.base.TestBase;

public class HomePage extends TestBase  {

	// Page Factory ---- Object Repository -----
	
	
	@FindBy(xpath="//a[Contains(text(),'Sign in')]")
	WebElement signin_link_after_hover;
	
	@FindBy(id="fatHeader")
	WebElement mainMenu;
	
	@FindBy(xpath="//a[@class='i-focus search-active-magnet btn btn-primary dtl-singin']")
	WebElement subMenu;
	
	// Initialization Page Objects
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	// Action and Method of this Page
	
	public SignInPage click_signIn_link(){
		
		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(mainMenu).build().perform();

		//To mouseover on sub menu
		actions.moveToElement(subMenu).build().perform();

		subMenu.click();
		
		signin_link_after_hover.click();
		return new SignInPage();
	}
	
	
}
