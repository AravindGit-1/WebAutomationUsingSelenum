package QualityAssurance.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import QualityAssurance.pageobjects.cartpage;

public class Abstractcomponents {
	WebDriver driver;

	public Abstractcomponents(WebDriver driver) {
		this.driver= driver;
		
	}
	
	@FindBy(css="[routerlink*=cart]")
	 WebElement cart;

	@FindBy(css=".ng-animating")
	 WebElement spinner;
	
	
	
	
	public void  waitforElement(By findby)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
	}
	
	public cartpage GotoCart()
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(spinner));
	cart.click();
	driver.manage().window().fullscreen();
	cartpage cartpage = new cartpage(driver);
	return cartpage;
	}
	
	
	

}
