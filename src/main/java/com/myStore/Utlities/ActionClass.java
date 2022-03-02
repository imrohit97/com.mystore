package com.myStore.Utlities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

public class ActionClass extends MainClass {

	public static void HoverOverNClick(WebDriver driver, WebElement HoverElement, WebElement clickElement,
			ExtentTest logger) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(HoverElement).perform();
		ExtentReportsNew.logwithSS(driver, "Hovered over Image," + HoverElement.getText() + " is clickable", logger);
		Thread.sleep(2000);
		try {
			if (clickElement.isDisplayed()) {
				System.out.println("Text:" + clickElement.getText());
				ExtentReportsNew.logwithSS(driver, "clicking on " + clickElement.getText() + " Element.", logger);
				JScript.scrollIntoView(driver,clickElement);
				clickElement.click();
			}
		} catch (Exception e) {
			System.out.println("Issue in action class ");
		}
	}

	public static void scrollPage() {
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			Thread.sleep(2000);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
