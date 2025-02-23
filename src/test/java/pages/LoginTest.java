package pages;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtil.CommonUtils;

public class LoginTest {
	private WebDriver driver;
	private CommonUtils util;
	public LoginTest(WebDriver driver2, CommonUtils ss) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
		this.util=ss;
	}


		public void homePage() {
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		
		driver.get(baseURL);
	}

	public void updatedUserNamePass(String name, String pass) {
		WebElement signupLink = driver.findElement(By.xpath("//a[text()='Sign In']"));
		util.clickElem(signupLink);	
		
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		emailField.sendKeys(name);
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
		passwordField.sendKeys(pass);
		
	}
	
	
	public void visitPracticePage() throws InterruptedException {
		
		// TODO Auto-generated method stub
		WebElement PracticeDD=driver.findElement(By.xpath("//a[@class='dynamic-link dropdown-toggle']"));
    	util.clickElem(PracticeDD);
    	
    	
    	String parentWindow=driver.getWindowHandle();
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
    	WebElement Practice=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/practice']")));
    	util.clickElem(Practice);
    
    	Set<String> lst=driver.getWindowHandles();
    	for(String i :lst)
    	{
    		if(!i.equals(parentWindow));
    		{
    			driver.switchTo().window(i);
    			
    		}
    	}
    	
    	
	}


	public void mouseHoverCode(String string) {
		WebElement mouseHover=driver.findElement(By.id("mousehover"));
		Actions act=new Actions(driver);
		act.moveToElement(mouseHover).perform();
		WebElement mouseHoverSubElem=driver.findElement(By.xpath("//div/a[text()='Top']"));
		if(string.equalsIgnoreCase(mouseHoverSubElem.getText()))
		{act.moveToElement(mouseHoverSubElem);}
	}


	public void checkIframe() {
		// TODO Auto-generated method stub

		//second comment

		//added comment
		

	}


	

}
