package login_pages_test;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import base_packages.Initial_step;

public class ForgotPassword_Test extends Initial_step {
	
	Login_Page_Elements LPE;
	String Mail="anto.g3interactive+superadmin@gmail.com";
	
	
	@Test (priority = 1)
	public void Check_Forgot_Password_button_IS_Working() throws IOException, InterruptedException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify forgotpassword button is working");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LPE.Click_forgot_password();
		Thread.sleep(2000);
		
		if(LPE.Verify_Forgot_password_title().isDisplayed())
		{
			testcase.log(PASS, "Forgot password button is working properly");
			Thread.sleep(2000);
			takescreenshot(driver, "succesfully login" );
		}
		else
		{
			testcase.log(FAIL, "Forgot password is not working as expected");
			Thread.sleep(2000);
			takescreenshot(driver, "failed");
		}
		

	}
	
	@Test (priority = 2)
	public void click_Forgot_Password_Continue() throws IOException, InterruptedException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify forgotpassword continue button is working");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LPE.Click_forgot_password();
		Thread.sleep(2000);
		
		if(LPE.Verify_Forgot_password_title().isDisplayed())
		{
			LPE.Enter_forgotpassword_emailID(Mail);
			Thread.sleep(2000);
			LPE.Click_forgotpassword_continue_button();
			testcase.log(PASS, "Continue Button is working as expected");
			Thread.sleep(2000);
			takescreenshot(driver, "succesfully login" );
		}
		else
		{
			testcase.log(FAIL, "continue button is not working as expected");
			Thread.sleep(2000);
			takescreenshot(driver, "failed");
		}
		
	}
	
	@Test (priority = 3)
	public void click_backto_signin_button() throws IOException, InterruptedException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify forgotpassword - back to signin button is working");
		
		Thread.sleep(2000);
		LPE.Click_forgot_password();
		Thread.sleep(2000);
		LPE.Click_forgotpassword_backtoSignin_button();
		
		if(LPE.Login_page_Title_Verification().isDisplayed())
		{
			
			testcase.log(PASS, "Back To Signin Button is working as expected");
			Thread.sleep(2000);
			takescreenshot(driver, "Back To Signin Nutton is working as expected" );
		}
		else
		{
			testcase.log(FAIL, "Back To Signin Button is not working");
			Thread.sleep(2000);
			takescreenshot(driver, "failed");
		}
		
	}
	
	@Test (priority = 4)
	public void Verify_forgot_password_email_validation_message() throws IOException, InterruptedException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify validation messege is apearing in emailid feild without enter emailid");
		
		Thread.sleep(2000);
		LPE.Click_forgot_password();
		Thread.sleep(2000);
		LPE.Click_forgotpassword_continue_button();
		
		if(LPE.Verify_validationMessage_Email().isDisplayed())
		{
			
			testcase.log(PASS, "Validation messege is displayed succsfully");
			Thread.sleep(2000);
			takescreenshot(driver, "Back To Signin Nutton is working as expected" );
		}
		else
		{
			testcase.log(FAIL, "Validation messege is not displayed");
			Thread.sleep(2000);
			takescreenshot(driver, "failed");
		}
	}
	
	@Test (priority = 5)
	public void Verify_Resetpassword_link_is_sent() throws IOException, InterruptedException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify reset password link is sent succesfully");
		
		Thread.sleep(2000);
		LPE.Click_forgot_password();
		LPE.Enter_forgotpassword_emailID(Mail);
		LPE.Click_forgotpassword_continue_button();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
	
		if(LPE.Verify_Reset_Password_Link().isDisplayed())
		{
			takescreenshot(driver, "The Success Messege is displayed Succesfuly" );
			testcase.log(PASS, "The Success Messege is displayed Succesfuly");
			Thread.sleep(2000);
			
		}
		else
		{
			testcase.log(FAIL, "messege is not displayed");
			Thread.sleep(2000);
			takescreenshot(driver, "failed");
		}
		
		
	

	}
	
	
	
	
	}