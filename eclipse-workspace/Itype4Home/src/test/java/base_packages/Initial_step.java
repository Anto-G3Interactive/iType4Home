package base_packages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Initial_step 
{	
	public WebDriver driver;
	public ExtentReports extendReport=new ExtentReports();
	public ExtentSparkReporter spark;
	public ExtentTest testcase;
	public Status PASS=Status.PASS;
	public Status FAIL=Status.FAIL;
	public Status INFO=Status.INFO;
	public SoftAssert softAssert;
	public  WebDriverWait wait;
	public JavascriptExecutor js;
	
	
	@BeforeClass
	public void Login()throws IOException, InterruptedException 
	{
		
		FileInputStream file=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(file);
		String path= properties.getProperty("Path");
		String url=properties.getProperty("LoginURL");
		String dashboard=properties.getProperty("DashboarURL");
		String eemail =properties.getProperty("Email");
		String pass=properties.getProperty("Password");
		
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		testcase= extendReport.createTest("Veify the Login Process");
		driver.get(dashboard);
		testcase.log(Status.INFO,"Navigating To Dashboard Page to confirm the login");
		Thread.sleep(1000);
		wait.until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
	    String currenturl= driver.getCurrentUrl();
	  
		String Otpurl="http://13.239.43.115/otp-verification";
		
			if(currenturl.equals(url))
			{
				WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
				email.sendKeys(eemail);
				Thread.sleep(500);
				WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
			    password.sendKeys(pass);
			    Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(1000);
				wait.until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
				String curl=driver.getCurrentUrl();
				Thread.sleep(1000);
				
				if(dashboard.equals(curl))
				{
					testcase.log(PASS,"Successfully logged-in");
					takescreenshot(driver, "Succesfully Logged In");
				}
				else if(Otpurl.equals(curl)) 
				{	
						testcase.log(INFO, "Please enter the OTP manually to Console");
						Thread.sleep(1000);
						
						Scanner scr=new Scanner(System.in);
						Thread.sleep(1000);
						System.out.println("Please enter the OTP: ");
						String otp= scr.nextLine();
						
						testcase.log(INFO, "The Entered OTP is: "+ otp);
						WebElement EnterOTP=driver.findElement(By.xpath("//input[@inputmode]"));
						EnterOTP.sendKeys(otp);
					    driver.findElement(By.xpath("//button[@type='submit']")).click();
					    takescreenshot(driver, "Enter OTP");
					    scr.close();
				}
				else
				{
					takescreenshot(driver, "Login Failed");
					testcase.log(FAIL, "Login Failed!. Did not redirected to the Dashboard page.");
					
				}
			}
			
			else if (currenturl.equals(dashboard))
		    {
				testcase.log(PASS, "Successfully logged-in");
				takescreenshot(driver,"Succesfully Logged in");
		    }
			
			else
			{
				testcase.log(FAIL, "Login Failed");
				takescreenshot(driver, "Login FAiled");
			}  
			
		spark= new ExtentSparkReporter("ExtentReport.html");
		extendReport.attachReporter(spark);	
		softAssert = new SoftAssert();
	}
	
	public void Logout()
	{
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1oq45jy']")).click();
		driver.findElement(By.xpath("//li[@role='menuitem']")).click();
	}
	
	public void RestPassword(String Password) throws IOException
	
	{
		try
		{
			driver.get("http://13.239.43.115/reset-password/7PzBTwzwBz10CSLP4IZK4gHktr0Df7tiWo9Q7bAoW5JRkunaTmr3ORdRaK6SDIAY");
			testcase=extendReport.createTest("Reset New Password");
			WebElement TitleDisplayed=driver.findElement(By.xpath("//h4[@class='MuiTypography-root MuiTypography-body1 css-1fpf3xw']"));
		
		if(TitleDisplayed.isDisplayed())
		{
			WebElement ResetPassword=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
			ResetPassword.sendKeys(Password);
			Thread.sleep(1000);
			
			WebElement ConfirmPassword=driver.findElement(By.xpath("(//input[@type='password'])[2]"));
			ConfirmPassword.sendKeys(Password);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			takescreenshot(driver, "Password is changed Succesfuly");
			Thread.sleep(1000);
			
			softAssert.assertEquals(true, "Password Reset Succesfuly");
		}
		else
		{
			testcase.log(FAIL, "Failed To Reset Password");
			takescreenshot(driver, "Failed to Reset Password");
		}
		}
		catch (Exception e) {
			testcase.log(FAIL, "An Exception Error is Occured Exception Error is : '"+e+"'");
		}
	}
	
// Taking screenshot	
	public void takescreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		String userHome=System.getProperty("user.Home");
		String downloadsFolder=userHome+File.separator+"Pictures"+File.separator;
		String currentdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
		
		File screenshotLocation=new File(downloadsFolder+screenshotName+currentdate+".png");
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot, screenshotLocation);
		testcase.addScreenCaptureFromPath(screenshotLocation.getAbsolutePath());
	}
		
//Generating Unique name method
	public static String generateDummyName()
	{
		Date d=new Date();
		String s=d.toString().replace(":","").replace(" ","");
		return s;
	}
		
//Failed to Run Script
	public void FailedToRunScript(Exception e)throws IOException
	{
		testcase.log(FAIL,"Failed to Run The Script.<br>"+"Error"+e.getMessage().split("\\R",2)[0]);
		takescreenshot(driver, "Failed to Run the Script");
		Assert.fail("Failed to Run the Script."+"\n"+"\n"+e.getMessage());
	}
	
	public void SelectDrpdownValue(WebDriver driver,ExtentTest testcase,String Name)
	{
		
	}
		
//Clearing the field and entering the value into it
	public void ClearAndEnterValue(WebElement e,String Value)throws InterruptedException
	{
		e.click();
		Thread.sleep(500);
		e.sendKeys(Keys.CONTROL,"a");
		Thread.sleep(500);
		e.sendKeys(Value);
	}
	public void ClearValue(WebElement e)throws InterruptedException
	{	
		e.click();
		Thread.sleep(500);
		e.sendKeys(Keys.CONTROL,"a");
		Thread.sleep(500);
		e.sendKeys("");
	}
		
	@AfterClass
	public void close()throws InterruptedException
	{
		Thread.sleep(20000);
		driver.quit();
		extendReport.flush();
		softAssert.assertAll();
	}

}

