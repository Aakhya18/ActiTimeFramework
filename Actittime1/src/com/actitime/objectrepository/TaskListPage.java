package com.actitime.objectrepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseClass;


public class TaskListPage extends BaseClass {
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement addnewcustomer;
	
	@FindBy(xpath="//input[contains(@class,'inputNameField')]")
	private WebElement customername;
	
	@FindBy(xpath="(//textarea[contains(@class,'textarea')])[9]")
	private WebElement customerdescription;
	
	@FindBy(xpath="(//div[.='- Select Customer -'])[2]")
	private WebElement customerdropdown;
	
	@FindBy(xpath="(//div[@class='searchInputPlaceholder'])[15]/div/div[1]/input")
	private WebElement placeholder;
	
	@FindBy(xpath="//div[@class='searchItemList']/div[.='Our company']") //div[.='gfff' and @class='']
	private WebElement selectourcompany;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcustomerbutton;
	
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement verify;
	//
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddnew() {
		return addnew;
	}
	public WebElement getAddnewcustomer() {
		return addnewcustomer;
	}
	public WebElement getCustomername() {
		return customername;
	}
	public WebElement getCustomerdescription() {
		return customerdescription;
	}
	public WebElement getCustomerdropdown() {
		return customerdropdown;
	}
	public WebElement getPlaceholder() {
		return placeholder;
	}
	public WebElement getSelectourcompany() {
		return selectourcompany;
	}
	public WebElement getCreatecustomerbutton() {
		return createcustomerbutton;
	}
	public WebElement getVerify() {
		return verify;
	}
	
}
