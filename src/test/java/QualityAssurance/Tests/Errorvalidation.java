package QualityAssurance.Tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import QualityAssurance.TestComponents.BaseTest;
import QualityAssurance.TestComponents.Retry;
import QualityAssurance.pageobjects.loginpage;
import QualityAssurance.pageobjects.productcatalogue;

public class Errorvalidation extends BaseTest{
	
	@Test(dataProvider ="getdata",groups="ErrorHandling",retryAnalyzer=Retry.class)
	
	public void loginerrorvalidation(HashMap<String,String> input) throws IOException, InterruptedException
	{	
		loginpage loginpage = launchApplication(input.get("email"),input.get("password"),input.get("productname"));
		loginpage.Goto();
		 loginpage.LogintoApplication(input.get("email"),input.get("password"),input.get("productname"));
		  String msg =loginpage.geterrormsg();
		  Assert.assertEquals(msg,"Incorrect email or password."); 
        System.out.println(msg);
	}
	@Test
	public void producterrorvalidations() throws IOException
	{
		String productname="ZARA COAT 3";
		String email="selenium172@gmail.com";
	    String password ="Selenium@1234";	
		loginpage loginpage = launchApplication(email,password,productname);
		loginpage.Goto();
		productcatalogue productcatalogue =  loginpage.LogintoApplication(email, password,productname);
        productcatalogue.AddtoCart(productname);
        
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
		{
		
		
		List<HashMap<String,String>>	data =jsonToMap(System.getProperty("user.dir")+"//src//test//java//QualityAssurance//dataprovider//data.json");
		
		return new  Object[][] {{data.get(0)},{data.get(1)}};
		}
	
	

}