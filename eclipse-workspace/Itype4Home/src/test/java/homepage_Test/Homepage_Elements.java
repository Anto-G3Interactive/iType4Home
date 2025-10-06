package homepage_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import base_packages.Initial_step;

public class Homepage_Elements extends Initial_step {
	
	WebDriver driver;
	ExtentTest testcase;
	
	public Homepage_Elements(WebDriver driver,ExtentTest testcase)
	{
		this.driver=driver;
		this.testcase=testcase;
	}
	
	//click On Home Page
	
	public void Click_on_home_button()
	{
	driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
	}
	
	public WebElement ParentTitle()
	
	{
		return driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-r9wa9a']"));
	}
	
	//Click on Parents Page
	
	public void Click_on_parent()
	{
		driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
	}
	
	public WebElement Parents_Table_First_Name()	
	{
		return driver.findElement(By.xpath("(//div[@class='MuiBox-root css-g8x3li'])[1]"));
	}
	
	public void Enter_on_parents_searchbar(String search) throws InterruptedException
	{
		WebElement Search=driver.findElement(By.xpath("//input[@type='text']"));
		Thread.sleep(1000);
		Search.sendKeys(search);
	}
	
	public void Select_parent_dropdown_show(int intex) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@role='combobox']")).click();
		Thread.sleep(1000);
		
		WebElement dataValues=driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-5dycmn'])['"+intex+"']"));
		Thread.sleep(1000);
		
		if(dataValues.isDisplayed())
		{
		
			dataValues.click();
			testcase.log(PASS, "The drpdown is selected succesfuly, the selected value is '"+intex);
		}
		else
		{
			
			testcase.log(FAIL, "There is no such values inside dropdown, the expected value is '"+intex+"'");
		}
		
	}
			
	public void SelectandClick_parents_list_pageing(int Page) throws InterruptedException
	{
		
		//	int Exactintex=Page+1;
		
			if (ParentTitle().isDisplayed())
			{
				int Exactintex=Page+1;
				driver.findElement(By.xpath("//*[@id=\"root\"]/section[2]/main/div/div/div/div/div[2]/div/ul/li['"+Exactintex+"']")).click();
				
			}
			else
			{
			testcase.log(FAIL, "");
			}
		}
	
	
	public void click_Action_button(int Select_Action_by_index)
	{
		try
		{
			driver.findElement(By.xpath("(//button[@type='button'])['"+Select_Action_by_index+"']")).click();
			Thread.sleep(1000);
			testcase.log(PASS, "The action button is clicked succesfuly by this intex : '"+Select_Action_by_index+"'");
			
		}
		catch (Exception e) {
			testcase.log(FAIL, "A Exception is occured Messege : '"+e+"'");
			
		}
	}
	
	//Select Checkbox by index
	
	public void select_checkbox_in_parents(int Select_status_by_index)
	{
		try
		{
			
			driver.findElement(By.xpath("(//input[@type='checkbox'])['"+Select_status_by_index+"']")).click();
			}
		catch(Exception e)
		{
			testcase.log(FAIL, "An Exception is occured Messege is : '"+e+"'");
		}
	}
	
	//click on change button(confirmation messege)
	
	public void Click_on_Change_button_Confirmation()
	{
		driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
	}
	
	//click on change button(confirmation messege)
	
	public void Click_on_Cancel_button_Confirmation()
	{
		driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
	}
	
	//Not completed
	public void NextAndPrevious()
	{
		WebElement Previous=driver.findElement(By.xpath("(//*[name()='svg'])[14]"));
		WebElement Nextpage=driver.findElement(By.xpath("(//*[name()='svg'])[15]"));
		
		
		
	}
	
	
	
	 
}
