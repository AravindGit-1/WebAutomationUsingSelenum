package QualityAssurance.Tests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import QualityAssurance.TestComponents.BaseTest;
import QualityAssurance.pageobjects.cartpage;
import QualityAssurance.pageobjects.checkoutpage;
import QualityAssurance.pageobjects.confirmationpage;
import QualityAssurance.pageobjects.loginpage;
import QualityAssurance.pageobjects.orderspage;
import QualityAssurance.pageobjects.productcatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone extends BaseTest {
	String productname="ZARA COAT 3";
	String email="selenium172@gmail.com";
    String password ="Selenium@1234";	
	@Test
	public void submitorder() throws IOException
	{
		
		
		loginpage loginpage = launchApplication(email, password,productname);
		loginpage.Goto();
		productcatalogue productcatalogue =  loginpage.LogintoApplication(email, password,productname);
        productcatalogue.AddtoCart(productname);
        cartpage cartpage= productcatalogue.GotoCart();
        Boolean match=   cartpage.verifyproduct(productname);
        Assert.assertTrue(match);
        checkoutpage checkoutpage =  cartpage.gotocheckout();
        checkoutpage.addaddress();
        confirmationpage  confirm=  checkoutpage.submitaddress();
         String msg=   confirm.getconfirmationmessage();
	    Assert.assertEquals("THANKYOU FOR THE ORDER.", msg);
	}
	@Test(dependsOnMethods= {"submitorder"})
	public void ordercheck() throws IOException
	{

		loginpage loginpage = launchApplication(email,password,productname);
		loginpage.Goto();
		productcatalogue productcatalogue =  loginpage.LogintoApplication(email, password,productname);
       orderspage orderspage =  productcatalogue.goToOrdersPage();
		
	}

}