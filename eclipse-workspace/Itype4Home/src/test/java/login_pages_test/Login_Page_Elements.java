package login_pages_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import base_packages.Initial_step;

public class Login_Page_Elements extends Initial_step
{
	WebDriver driver;
	ExtentTest testcase;
	
	public Login_Page_Elements(WebDriver driver, ExtentTest testcase)
	{
		this.driver= driver;
		this.testcase= testcase;
	}
	
	public WebElement Alert_or_Confirmation_Messege() 
	{	
		return driver.findElement(By.xpath("//div[@role='alert']"));
	}
	
	public WebElement Validation_Messege_EmailID()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[1]"));
	}
	
	public WebElement Validation_Messege_password()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[2]"));
	}
	
	// Login Page Elements
	
	public void EnterEmailID(String Email) throws InterruptedException
	{
		WebElement e= driver.findElement(By.xpath("//input[@name='email']"));
		Thread.sleep(1000);
		ClearAndEnterValue(e, Email);
	}
	
	public void EnterPassword(String Password)throws InterruptedException
	{
		WebElement p=driver.findElement(By.xpath("//input[@name='password']"));
		Thread.sleep(1000);
		ClearAndEnterValue(p, Password);
	}
	
	public void Click_CheckboxRememberme(String EnableOrDisable)
	{
		WebElement Rememberme=driver.findElement(By.xpath("//input[@id='rememberMe']"));
		
		if(EnableOrDisable.toLowerCase().contains("enable") && !Rememberme.isSelected())
		{
			Rememberme.click();
		}
		else if(EnableOrDisable.toLowerCase().contains("disable") && Rememberme.isSelected())
		{
			Rememberme.click();			
		}			
	}
	
	public void ClickSigninButton()
	{
		WebElement Signin=driver.findElement(By.xpath("//button[@type='submit']"));
		Signin.click();		
	}
	
	public void Click_forgot_password()
	{
		WebElement Forgetpassword= driver.findElement(By.xpath("(//span[text()='forgot password?'])[1]"));
		Forgetpassword.click();
	}
	
	public void Click_Login_as_a_student_Button()
	{
		WebElement StudentLogin=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-euvj2v'])[1]"));
		StudentLogin.click();
	}
	
	public void Click_Sign_Up_Button()
	{
		WebElement create_account=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		create_account.click();	
	}
	
	//Sign Up For An Account
	
	public void Signup_Enter_Firstname(String Firstname) throws InterruptedException

	{
		WebElement First_name=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		ClearAndEnterValue(First_name, Firstname);
		First_name.click();
		First_name.sendKeys(Firstname);
	}
	
	public void signup_Enter_Lastname(String LastName) throws InterruptedException
	{
		WebElement Lastname=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		ClearAndEnterValue(Lastname, LastName);
		Lastname.click();
		Lastname.sendKeys(LastName);
	}
	
	public void Signup_Enter_Phonenumber(String Enter_phonNo) throws InterruptedException
	{
		WebElement phon=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		ClearAndEnterValue(phon, Enter_phonNo);
		phon.click();
		phon.sendKeys(Enter_phonNo);
	}
	
	public void Signup_Enter_Email(String Email) throws InterruptedException
	{
		WebElement emailid=driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		ClearAndEnterValue(emailid, Email);
		emailid.click();
		emailid.sendKeys(Email);
	}
	
	public void Signup_Enter_password(String password)
	{
		try {
		WebElement EnPassword=driver.findElement(By.xpath("//input[@type='password']"));
		ClearAndEnterValue(EnPassword, password);
		EnPassword.click();
		EnPassword.sendKeys(password);
		}
		catch (Exception e) 
		{
			testcase.log(FAIL, "An Exception messege is Occured Messege is : '"+e+"' ");
		}
	}
	
	public void Signup_Click_on_PrivacyPolicy_checkbox()
	{
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	
	public void Click_SignUp()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void Click_signup_Already_have_an_account_Signin()
	{
		driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 css-1fbgaka']")).click();
	}
	
	
	//Validation Messeges In Sign Up
	
	public WebElement Signup_Validation_Messege_FirstName()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[1]"));
	}
	
	public WebElement Signup_Validation_Messege_Lastname()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[2]"));
	}
	
	//there is no validation for phonnumber
	
	public WebElement Signup_Validation_Messege_Phone()
	{
		return driver.findElement(By.xpath(""));
	}
	
	public WebElement Signup_Validation_Messege_Emailid()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[3]"));
	}
	
	public WebElement Signup_Validation_Messege_password()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[4]"));
	}
	
	public WebElement Signup_Validation_Messege_privacy_policy()
	{
		return driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k'])[5]"));
	}
	
	public WebElement Login_page_Title_Verification()
	
	{
		return driver.findElement(By.xpath("(//h4[@class='MuiTypography-root MuiTypography-body1 css-bukayz'])[1]"));
	}
	
	// Forgot Password Page Elements

	public void Click_Forgot_password_button()
	{
		WebElement Forgotpassword= driver.findElement(By.xpath("(//span[text()='forgot password?'])[1]"));
		Forgotpassword.click();
	}
	
	public WebElement Verify_Forgot_password_title()
	{
		return driver.findElement(By.xpath("//h4[@class='MuiTypography-root MuiTypography-body1 css-1fpf3xw']"));
	}
	
	
	public void Enter_forgotpassword_emailID(String email) throws InterruptedException
	{
		WebElement Forgetpassword= driver.findElement(By.xpath("//input[@type='text']"));
		Forgetpassword.sendKeys(email);
	}
	
	public void Click_forgotpassword_continue_button()
	{
		WebElement continueclick= driver.findElement(By.xpath("//button[@type='submit']"));
		continueclick.click();
	}
	
	public void Click_forgotpassword_backtoSignin_button()
	{
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
	}
	
	public WebElement Verify_validationMessage_Email()
	
	{
		return driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k']"));
	}
	
	public WebElement Verify_Reset_Password_Link()
	{
		return driver.findElement(By.xpath("//div[@id='2']"));
	}
	
	public WebElement inValidemail_Varification()
	{
		return driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-mp3c2k']"));
	}
	
	public WebElement Validation_Message_Using_Emailid_Withouthaving_account()
	
	{
		return driver.findElement(By.xpath("//div[@id='5']"));
	}
	
	
	// student Login
	
	public void Enter_parent_code(String EParent_Code) throws InterruptedException
	{
	WebElement Parent_Code= driver.findElement(By.xpath("//input[@name='parentCode']"));
	ClearAndEnterValue(Parent_Code, EParent_Code);
	Parent_Code.click();
	Parent_Code.sendKeys(EParent_Code);
	
	}
	
	public void ChildEnter_username(String EUsername) throws InterruptedException
	{
		WebElement Username=driver.findElement(By.xpath("//input[@name='parentCode']"));
		ClearAndEnterValue(Username, EUsername);
		Username.click();
		Username.sendKeys(EUsername);
	}
	
	public void ChildEnter_password(String Epassword) throws InterruptedException
	{
		WebElement Password=driver.findElement(By.xpath("//input[@name='childpassword']"));
		ClearAndEnterValue(Password, Epassword);
		Password.click();
		Password.sendKeys(Epassword);
		
	}
	
	public void ChildClick_on_Rememberme_checkbox()
	{
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	}
	
	public void child_Click_SignIn_Button()
	{
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
	}
	
	public void ChildClickonPasswordView()
	{
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/form/div[1]/div[3]/div/svg")).click();
	}
	
	public void Click_Login_as_a_parent_Click_Here()
	{
		driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-euvj2v'])[2]")).click();
	}
	
	public void Click_Dont_Have_An_Account_Signup()
	{
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	}
	
	// Student Forgot Password
	
	public void StudentClick_ForgotPassword_button()
	{
		driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 css-18qzgij'])[2]")).click();
		
	}
	
	public void StudentEnter_Emailid(String studentemail) throws InterruptedException
	{
		WebElement StEmail=driver.findElement(By.xpath("//input[@type='text']"));
		ClearAndEnterValue(StEmail, studentemail);
		StEmail.click();
		StEmail.sendKeys(studentemail);
	}
	
	public void StudentClick_continue_button()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void StudentClick_back_to_sign_in()
	{
		driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	
	//Reset Password Page
	
	public void Enter_New_ResetPassword(String NewPassword)
	{
		WebElement New_password=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		New_password.click();
		New_password.sendKeys(NewPassword);
		
	}
	
	public void Enter_ResetConfirmPassword(String ConfirmNewPassword) throws InterruptedException
	{
		WebElement New_password=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		ClearAndEnterValue(New_password, ConfirmNewPassword);
		New_password.click();
		New_password.sendKeys(ConfirmNewPassword);
	}
	
	public void Click_Signin_ResetPassword()
	
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	
	
	
}
