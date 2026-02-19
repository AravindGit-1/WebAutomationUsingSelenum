package QualityAssurance.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QualityAssurance.AbstractComponents.Abstractcomponents;

public class checkoutpage extends Abstractcomponents {
	
	
	WebDriver driver;
	
	public checkoutpage (WebDriver driver )
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement address;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement button;
	
	
	public void addaddress()
	{
		Actions a = new Actions(driver);
	  a.sendKeys(address, "India").build().perform();
	  country.click();
	}
	
	public confirmationpage   submitaddress()
	{
		button.click();
		confirmationpage  confirm = new confirmationpage(driver);
		return confirm;
	
	}
	

}
