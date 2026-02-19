package QualityAssurance.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import QualityAssurance.AbstractComponents.Abstractcomponents;

public class loginpage extends Abstractcomponents{
	
	
	WebDriver driver;
	
	public loginpage(WebDriver driver )
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	
	@FindBy(id="login")
	WebElement loginbutton;
	

	@FindBy(css="[class*=flyInOut]")
	WebElement errormsg;
	
	
	public productcatalogue LogintoApplication(String email,String password,String productname)
	{
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		loginbutton.click();
		productcatalogue productcatalogue =new productcatalogue(driver);
		return  productcatalogue;

		
	}
	
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String geterrormsg() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*=flyInOut]")));
		return errormsg.getText();
		
	}



}
