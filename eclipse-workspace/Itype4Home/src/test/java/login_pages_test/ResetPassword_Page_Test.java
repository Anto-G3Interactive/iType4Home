package login_pages_test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base_packages.Initial_step;

public class ResetPassword_Page_Test extends Initial_step {
	
	String Newpassword="12345678";
	Login_Page_Elements LPE;
	WebDriver driver;
	ExtentTest testcase;

	@Test
	public void Reset_New_password() throws IOException, InterruptedException
	{
		RestPassword(Newpassword);
	}
	
	
	

}
