package QualityAssurance.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QualityAssurance.AbstractComponents.Abstractcomponents;

public class cartpage extends Abstractcomponents{

WebDriver driver;
	
	public cartpage (WebDriver driver )
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	

	@FindBy(css=".totalRow button")
	  WebElement checkout ;
	
	public Boolean  verifyproduct(String productname)
	{
		Boolean match =	cartproducts.stream().anyMatch(product->
		product.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public checkoutpage  gotocheckout() {
		
		checkout.click();
		checkoutpage checkoutpage = new checkoutpage(driver);
		return checkoutpage ;
		
	}
	
	
}
