package QualityAssurance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QualityAssurance.AbstractComponents.Abstractcomponents;
	
	
	
	public class confirmationpage extends Abstractcomponents {
		
		
		WebDriver driver;
		
		public confirmationpage (WebDriver driver )
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		
		@FindBy(css=".hero-primary")
		WebElement confirmation;
		
		public String getconfirmationmessage()
		{
			String msg =confirmation.getText();
			return msg;
		}

}
