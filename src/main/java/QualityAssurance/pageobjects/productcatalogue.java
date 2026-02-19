package QualityAssurance.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import QualityAssurance.AbstractComponents.Abstractcomponents;
import QualityAssurance.pageobjects.orderspage;

public class productcatalogue extends Abstractcomponents  {
	
WebDriver driver;
	
	public productcatalogue (WebDriver driver )
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	public void AddtoCart(String productname)
	{
		driver.manage().window().maximize();
		WebElement prod = products.stream().filter(product->product.
		findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector("button:last-of-type")).click();	
	}
	

	public orderspage goToOrdersPage()
	{
		orderHeader.click();
		orderspage  orderPage = new orderspage(driver);
		return orderPage;
	}
	
}
