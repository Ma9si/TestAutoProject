package Project;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.LogStatus;
public class Validate {
	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;
	WebDriverWait wait;
	String baseurl="https://www.instagram.com/";
	String driverpath="E:\\Semester 6\\TestAutomation\\WebDrivers\\chromedriver_win32\\chromedriver.exe";
	
	@BeforeClass
	public void initReport(){
		report = new ExtentReports("E:\\Semester 6\\TestAutomation\\Validate.html");
	}
	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,40);
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public static void startReport(Method result){
		test = report.startTest("My Project Register Report - "+result.getName());
	}
	@AfterMethod
	public void endReport(){
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=0)
	public void Login() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("ma9si.07");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("***");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]"))).click();
		test.log(LogStatus.PASS, "Login SUccesful");
	}
	@Test(priority=1)
	public void FindPeople() throws InterruptedException
	{
		
		boolean status = driver.findElement(By.cssSelector("#react-root > section > nav > div._8MQSO.Cx7Bp > div > div > div.ctQZg > div > div:nth-child(3) > a > svg")).isDisplayed();
		
		if(status){
			System.out.println("Find people Element is visible");
			test.log(LogStatus.PASS, "Find people Element is visible");
			
		} else {
			System.out.println("Find people is hidden");
			test.log(LogStatus.FAIL, "Find people is hidden");
		}
    }
	@Test(priority=2)
	public void ActivityButton() throws InterruptedException
	{
		boolean status = driver.findElement(By.cssSelector("#react-root > section > nav > div._8MQSO.Cx7Bp > div > div > div.ctQZg > div > div:nth-child(4) > a > svg")).isDisplayed();

		if(status){
			System.out.println("ActivityButton Element is visible");
			test.log(LogStatus.PASS, "ActivityButton Element is visible");
			
		} else {
			System.out.println("ActivityButton is hidden");
			test.log(LogStatus.FAIL, "ActivityButton is hidden");
		}
	}
	@Test(priority=3)
	public void Messenger() throws InterruptedException
	{
		boolean status =driver.findElement(By.cssSelector("#react-root > section > nav > div._8MQSO.Cx7Bp > div > div > div.ctQZg > div > div:nth-child(4) > a > svg")).isEnabled();
				if(status){
					System.out.println("Messenger Button Element is visible");
					test.log(LogStatus.PASS, "Messenger Button Element is visible");
					
				} else {
					System.out.println("Messenger Button is hidden");
					test.log(LogStatus.FAIL, "Messenger Button is hidden");
				}
    }
	
	@Test(priority=4)
	public void Home() throws InterruptedException
	{
		boolean status =driver.findElement(By.cssSelector("#react-root > section > nav > div._8MQSO.Cx7Bp > div > div > div.ctQZg > div > div:nth-child(1) > div > a > svg > path")).isEnabled();
		if(status){
			System.out.println("Home Logo Button Element is visible");
			test.log(LogStatus.PASS, "Home Logo Button Element is visible");
			
		} else {
			System.out.println("Home Logo Button Button is hidden");
			test.log(LogStatus.FAIL, "Home Logo Button Button is hidden");
		}
	}
	
}
