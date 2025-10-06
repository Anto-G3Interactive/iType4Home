package homepage_Test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base_packages.Initial_step;

public class Parent_Page_Test extends Initial_step 
	{
	String Search="Petter Parker";
	
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
			HPE.Click_on_parent();
			Thread.sleep(1000);
			HPE.Enter_on_parents_searchbar(Search);
			Thread.sleep(1000);
		    takescreenshot(driver, "Search bar working properly");
		    Thread.sleep(1000);
		
		    String Fullname=HPE.Parents_Table_First_Name().getText();
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
		HPE.Click_on_parent();
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
			HPE.Click_on_parent();
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
	
	
	
	}