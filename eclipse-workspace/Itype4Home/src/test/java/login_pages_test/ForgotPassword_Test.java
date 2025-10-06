package login_pages_test;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import base_packages.Initial_step;

public class ForgotPassword_Test extends Initial_step {
	
	Login_Page_Elements LPE;
	String Mail="anto.g3interactive+superadmin@gmail.com";
	String Password="";
	
	
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
	
	@Test
	public void click_backto_signin_button() throws IOException, InterruptedException
	{
		LPE= new Login_Page_Elements(driver, testcase);
		Logout();
		Thread.sleep(1000);
		
		testcase= extendReport.createTest("Verify forgotpassword - back to signin button is working");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LPE.Click_forgot_password();
		LPE.Click_forgotpassword_backtoSignin_button();
		Thread.sleep(2000);
		
		if(LPE.Login_page_Title_Verification().isDisplayed())
		{
			
			testcase.log(PASS, "back to sign in button is working as expected");
			Thread.sleep(2000);
			takescreenshot(driver, "button is working properly" );
		}
		else
		{
			testcase.log(FAIL, "continue button is not working as expected");
			Thread.sleep(2000);
			takescreenshot(driver, "failed");
		}
		
		
	

}
	
	
	}