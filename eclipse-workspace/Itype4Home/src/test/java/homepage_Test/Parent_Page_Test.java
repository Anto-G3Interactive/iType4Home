package homepage_Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base_packages.Initial_step;

public class Parent_Page_Test extends Initial_step 
	{
	String Search="Petter Parker";
	String ChildName="Anto Martin";
	
	Homepage_Elements HPE;
	WebDriverWait wait;
	
	@Test (priority = 1)
	public void Check_Searchbar_is_working() throws InterruptedException, IOException 
	{
		HPE=new Homepage_Elements(driver, testcase);
	
		testcase= extendReport.createTest("Search Field");
		testcase.log(INFO, "Search Bar must Work Properly");
	
		try
		{
			HPE.Click_on_parent_module();
			Thread.sleep(1000);
			HPE.Enter_on_parents_searchbar(Search);
			Thread.sleep(1000);
		    takescreenshot(driver, "Search bar working properly");
		    Thread.sleep(1000);
		
		    String Fullname=HPE.Verify_Parents_Table_First_Name().getText();
		    System.out.println(Fullname);
		    Thread.sleep(1000);
		    
		    if (Fullname.equals(Search))
		    {	
			testcase.log(PASS, "Search bar is working fine the searched : '"+Fullname+"' is Displayed");
			takescreenshot(driver, "Searcbar");
		    }
		    else
		    {
		    	testcase.log(FAIL, "Search bar is not working as expected the searched : '"+Fullname+"' is not Displayed");
		    	takescreenshot(driver, "Search bar is not working");	
		    }
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test (priority = 2)
	public void Checkdropdown_is_working() throws InterruptedException, IOException
	{
		HPE=new Homepage_Elements(driver, testcase);
		Thread.sleep(1000);
		testcase= extendReport.createTest("Testing Dropdown in Parents page");
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		HPE.Click_on_parent_module();
		testcase.log(INFO, "Testing Dropdown in Parents page");
		if(HPE.ParentTitle().isDisplayed())
		{
			
			HPE.Select_parent_dropdown_show(1);
			Thread.sleep(1000);
			takescreenshot(driver, "chechbox");
			Thread.sleep(1000);
			testcase.log(PASS, "Dropdown is selected ,it working as expected");
			softAssert.assertEquals(true, "Dropdown is working as expected");
			
			}
		
			else
			{
				testcase.log(FAIL, "Dropdown is not working as expected");
				takescreenshot(driver, "Dropdown is not working as expected");
				softAssert.assertEquals(false, "Dropdown is not working as expected");
			}
		
	}
	
	//not completed
	
	@Test (priority = 3)
	public void click_on_pagingNavigater_button() throws InterruptedException, IOException
	{
		try
		{
			HPE=new Homepage_Elements(driver, testcase);
			Thread.sleep(1000);
			testcase= extendReport.createTest("Testing Paging ");
			wait=new WebDriverWait(driver, Duration.ofSeconds(5));
			HPE.Click_on_parent_module();
			testcase.log(INFO, "Testing Pageing Navigation");
			if(HPE.ParentTitle().isDisplayed())
			{
				
				HPE.SelectandClick_parents_list_pageing(18);
				Thread.sleep(1000);
				takescreenshot(driver, "paging");
				Thread.sleep(1000);
				testcase.log(PASS, "Page Navigation is Working Fine");
				softAssert.assertEquals(true, "Page Navigation is working");
				
				}
			
				else
				{
					testcase.log(FAIL, "Dropdown is not working as expected");
					takescreenshot(driver, "Page Navigation is not working as expected");
					softAssert.assertEquals(false, "Page Navigation is not working as expected");
				}
		}
		catch (Exception e) 
		{
			testcase.log(FAIL, e);
		
		}
		
		
		
		
		
	}
	
	
	@Test (priority = 4)
	
	public void Click_on_Action_in_parents_table() throws InterruptedException, IOException
	{
		HPE=new Homepage_Elements(driver, testcase);
		Thread.sleep(1000);
		testcase= extendReport.createTest("Testing Dropdown in Parents page");
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		HPE.Click_on_parent_module();
		testcase.log(INFO, "Testing Action Button");
		if(HPE.ParentTitle().isDisplayed())
		{
			
			HPE.click_view_button(1);
			Thread.sleep(1000);
			takescreenshot(driver, "chechbox");
			Thread.sleep(1000);
			testcase.log(PASS, "Action Button is working as expected");
			softAssert.assertEquals(true, "Action Button is working as expected");
			
			}
		
			else
			{
				testcase.log(FAIL, "Action button is not working as expected");
				takescreenshot(driver, "Action button is not working as expected");
				softAssert.assertEquals(false, "Action button is not working as expected");
			}
		
		
	}
	
	/*@Test


	public void Click_on_showbox_inside_Childrens_info() throws InterruptedException, IOException
	{
		
		
			HPE=new Homepage_Elements(driver, testcase);
			Thread.sleep(1000);
			testcase= extendReport.createTest("Testing Dropdown in Parents page");
			wait=new WebDriverWait(driver, Duration.ofSeconds(5));
			HPE.Click_on_parent();
			testcase.log(INFO, "Testing Dropdown in Parents page");
			Thread.sleep(1000);
			HPE.click_Action_button(1);
			Thread.sleep(1000);
			
			if(HPE.Profile_Title_Verification().isDisplayed())
			{
				
				HPE.click_profile_show_dropdown(3);;
				Thread.sleep(1000);
				takescreenshot(driver, "chechbox");
				Thread.sleep(1000);
				testcase.log(PASS, "Dropdown is selected ,it working as expected");
				softAssert.assertEquals(true, "Dropdown is working as expected");
				
				}
			
				else
				{
					testcase.log(FAIL, "Dropdown is not working as expected");
					takescreenshot(driver, "Dropdown is not working as expected");
					softAssert.assertEquals(false, "Dropdown is not working as expected");
				}
			
		
		
	}*/
	
	@Test (priority = 5)
	public void Search_children_And_Click_on_Actions() throws InterruptedException, IOException
	{
		HPE=new Homepage_Elements(driver, testcase);
		Thread.sleep(1000);
		testcase= extendReport.createTest("Testing search bar and status checkbox");
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		HPE.Click_on_parent_module();
		testcase.log(INFO, "Testing Action Button");
		HPE.click_view_button(1);
		
		HPE.Enter_Childrens_info_Searchbar(ChildName);
		Thread.sleep(2000);
		takescreenshot(driver, "chechbox");
		Thread.sleep(1000);
		
		HPE.Click_on_view_button_in_childrens_info();
		
		Thread.sleep(1000);
		
		if(HPE.student_verification_title().isDisplayed())
		{
			testcase.log(PASS, "The search and action button works properly");
			Thread.sleep(3000);
			takescreenshot(driver, "The search and action button works properly");
			
		}
		else
		{
			testcase.log(FAIL, "The search and action button is not works properly");
			Thread.sleep(3000);
			takescreenshot(driver, "The search and action button is not works properly");
			
		}
	}
	
	@Test (priority = 6)
	public void Click_on_Status_Checkbox_Button() throws InterruptedException, IOException
	{
		HPE=new Homepage_Elements(driver, testcase);
		testcase= extendReport.createTest("Testing Status Functionality of Student");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		testcase.log(INFO, "Testing CheckBox Button");
		
		HPE.Click_on_parent_module();
		HPE.click_view_button(1);
		HPE.Click_Checkbox_Status_View_Profile();
		Thread.sleep(1000);
		
		String Title=HPE.Validation_Messege().getText();
		Thread.sleep(1000);
		
		if(Title.toLowerCase().contains("success"))
		{
			testcase.log(PASS, "Status updated and the '"+ Title +"'message is displayed");
			takescreenshot(driver, "Status updated");
		}
		else
		{
			testcase.log(FAIL, "Status did not updated and the '"+ Title +"'message is displayed");
			takescreenshot(driver, "Status did not updated");
		}
		
	}
	
	@Test (priority = 7)
	public void click_on_Subscription_view_And_Click_on_Download_PDF() throws InterruptedException, IOException
	{
		HPE=new Homepage_Elements(driver, testcase);
		testcase= extendReport.createTest("Testing Download PDF Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		testcase.log(INFO, "Testing Subscription View and Download Invoice Pdf");
		
		HPE.Click_on_parent_module();
		HPE.click_view_button(1);
		HPE.Click_on_View_Subscription();
		HPE.Click_Download_PDF_Button();
		Thread.sleep(1000);
		
		takescreenshot(driver, "Download PDF");
		
		
		testcase.log(PASS, "Invoice Downloaded Succesfuly");
		
	}
	
	@Test (priority = 8)
	public void Click_on_Subscription_view_and_Click_On_Cancel_button() throws InterruptedException, IOException
	{
		
		HPE=new Homepage_Elements(driver, testcase);
		testcase= extendReport.createTest("Testing Back Button in Invoice Page");
		Thread.sleep(1000);
		testcase.log(INFO, "Testing Subscription View and Download Invoice Pdf");
		
		HPE.Click_on_parent_module();
		HPE.click_view_button(1);
		HPE.Click_on_View_Subscription();
		Thread.sleep(5000);
		HPE.Click_Back_button();
		
		String Title=HPE.Profile_Title_Verification().getText();
		Thread.sleep(1000);
		
		if(Title.toLowerCase().contains("info"))
		{
			testcase.log(PASS, "Succusfuly Navigated to previous Page Title : '"+ Title +"' is displayed");
			Thread.sleep(1000);
			takescreenshot(driver, "Navigation Button");
			
		}
		else
		{
			testcase.log(FAIL, "Navigation Button did not work properly Title : '"+ Title +"' is displayed");
			Thread.sleep(1000);
			takescreenshot(driver, "Navigation Button");
		}
		
		
		
		
	}
	
	
	
	
	
	
}






















