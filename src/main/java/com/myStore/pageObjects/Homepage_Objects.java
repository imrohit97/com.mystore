package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.Utlities.MainClass;

public class Homepage_Objects{



	public static String SignIn="//a[@class='login']";

	public static String contactUS="//div[@id='contact-link']/a";

	public static String Logo="//img[@class='logo img-responsive']";

	@FindBy(xpath = "//input[@id='search_query_top']")
	public WebElement searchText;

	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement searchButton;

	@FindBy(xpath="//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img")
	public WebElement firstImage;
	
	@FindBy(partialLinkText="Add to cart")
	public WebElement addTocart;
	

	public String proceedToCheckout="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span";
	
	public String summerDress="//*[@id=\"homefeatured\"]/li[6]/div/div[1]/div/a[1]/img";
	
}
