package login_pages_test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base_packages.Initial_step;

public class Login_Test extends Initial_step
{
	Login_Page_Elements LPE;
	
	
	String Mail="anto.g3interactive+superadmin@gmail.com";
	String Password="12345678";
	
	//Verify Login with valid credentials 
	
	@Test (priority= 1)
	public void Verify_Login_with_valid_credentials() throws InterruptedException, IOException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify Login Functionality With Valid Credentials");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LPE.EnterEmailID(Mail);
		LPE.EnterPassword(Password);
		Thread.sleep(1000);
		LPE.Click_CheckboxRememberme("enable");
		LPE.ClickSigninButton();
		Thread.sleep(1000);
		
		WebElement Dashboard=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-isa2go']"));
		String Title=Dashboard.getText();
		
		if(Dashboard.isDisplayed())
		{
			testcase.log(PASS, "Login functionality accept the valid credentials. The '"+Title+"' message is displayed");
			Thread.sleep(1000);
			takescreenshot(driver, "Using Valid Credentials");
			System.out.println("Displayed");
		}
		else
		{
			testcase.log(FAIL, "Login functionality didnt accept the valid credentials. The '"+Title+"' message is not displayed");
			Thread.sleep(1000);
			takescreenshot(driver, "Using Valid Credentials");
		}
	
	}
	
	//Verify Login With Invalid Credentials 

	@Test (priority = 2)
	public void Verify_login_with_Invalid_Credentails() throws InterruptedException, IOException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify Login Functionality With InValid Credentials");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LPE.EnterEmailID("ishtechdeveloper1000@gmail.com");
		LPE.EnterPassword(Password);
		Thread.sleep(2000);
		
		LPE.Click_CheckboxRememberme("enable");
		LPE.ClickSigninButton();
		Thread.sleep(2000);
		
		String Message=LPE.Alert_or_Confirmation_Messege().getText();
		
		if(Message.toLowerCase().contains("incorrect"))
		{
			testcase.log(PASS, "Login functionality did not accept the invalid credentials. The '"+ Message +"' message is displayed");
			takescreenshot(driver, "Using InValid Credentials");
			softAssert.assertTrue(true, "Login page did not accept invalid credentials. The '"+ Message +"' message is displayed");
			
		}
		else
		{
			testcase.log(FAIL, "Login Page Accepts invalid credentials. The '"+ Message +"' message is displayed");
			takescreenshot(driver, "Using InValid Credentials");
			softAssert.assertTrue(false, "Login Page Accepts invalid credentials. The '"+ Message +"' message is displayed");
		}

			
	}
	
	//Verify Validation Message is appearing by without entering Data 
	
	@Test (priority = 3)
	public void Verify_Validation_Messege() throws InterruptedException, IOException
	{	
		
		LPE= new Login_Page_Elements(driver, testcase);
		
		Thread.sleep(1000);
		Logout();
		
		testcase= extendReport.createTest("Verify validation messege is Working");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		LPE.Click_CheckboxRememberme("enable");
		LPE.ClickSigninButton();
		takescreenshot(driver, "Validation Messege");
		
		testcase.log(INFO, "Without Giving EmailId and Password");
		String emailvalidation=LPE.Validation_Messege_EmailID().getText();
		String passwordValidation=LPE.Validation_Messege_password().getText();
		
		if(emailvalidation.toLowerCase().contains("email")&& passwordValidation.toLowerCase().contains("password"))
		{
			testcase.log(PASS, "Alert messege is displayed. The alert messege for email is :'"+ emailvalidation +"' And alert messege for password is :'"+passwordValidation+"'");
			takescreenshot(driver, "validation messege is apeared");
			softAssert.assertTrue(true, "Alert messege is displayed. The alert messege for email is :'"+ emailvalidation +"' And alert messege for password is :'"+passwordValidation+"'");
		}
		else
		{
			testcase.log(FAIL, "There is no validation messege apeared for empty feilds");
			takescreenshot(driver, "validation not apeared");
			softAssert.assertTrue(false, "There is no validation messege apeared for empty feilds");
			
			
		}
	}
		
	}
	
	
	


