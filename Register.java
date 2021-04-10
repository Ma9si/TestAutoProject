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
import static org.testng.Assert.assertNotNull;
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
public class Register {
	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;
	WebDriverWait wait;
	String baseurl="https://www.instagram.com/";
	String driverpath="E:\\Semester 6\\TestAutomation\\WebDrivers\\chromedriver_win32\\chromedriver.exe";
	
	@BeforeClass
	public void initReport(){
		report = new ExtentReports("E:\\Semester 6\\TestAutomation\\Register.html");
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
	public void SignUp() throws InterruptedException
	{
		//click on signup
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > article > div.rgFsT > div:nth-child(2) > div > p > a > span")));	
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Signup button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > article > div.rgFsT > div:nth-child(2) > div > p > a > span"))).click();	
		}
		else{
			test.log(LogStatus.FAIL, "Signup button absent or Disabled");
		}
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void EnterMobile() throws InterruptedException
	{	
	//enter mobile
		WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[3]/div/label/input")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Mobile button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[3]/div/label/input"))).sendKeys("9759093000");
		}
		else{
			test.log(LogStatus.FAIL, "Mobile button absent or Disabled");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=2)
	public void EnterName() throws InterruptedException
	{//enter full name
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[4]/div/label/input")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Name button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[4]/div/label/input"))).sendKeys("Mansi Saini");
		}
		else{
			test.log(LogStatus.FAIL, "Name button absent or Disabled");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=3)
	public void UserName() throws InterruptedException
	{
		//enter username
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[5]/div/label/input")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Name button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[5]/div/label/input"))).sendKeys("saini.mansii");
		}
		else{
			test.log(LogStatus.FAIL, "Name button absent or Disabled");
		}
		Thread.sleep(3000);
	}
		
	@Test(priority=4)
	public void EnterPassword() throws InterruptedException
	{
		// enter password
		WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[6]/div/label/input")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Password button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[6]/div/label/input"))).sendKeys("Hello@1234");
		}
		else{
			test.log(LogStatus.FAIL, "Password button absent or Disabled");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void Submit() throws InterruptedException
	{	
	//signup submit
		WebElement btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > div > div > div:nth-child(1) > div > form > div:nth-child(8) > div > button")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Submit button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > div > div > div:nth-child(1) > div > form > div:nth-child(8) > div > button"))).click();
		}
		else{
			test.log(LogStatus.FAIL, "Submit button absent or Disabled");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void EnterBirthMonth() throws InterruptedException
	{
		//birthday month
		WebElement btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[1]/select")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "BirthMonth button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[1]/select"))).sendKeys("September");
		}
		else{
			test.log(LogStatus.FAIL, "BirthMonth button absent or Disabled");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=7)
	public void EnterBirthDay() throws InterruptedException
	{
		//birth day
		WebElement btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[2]/select")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "BirthDay button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[2]/select"))).sendKeys("17");
		}
		else{
			test.log(LogStatus.FAIL, "BirthDay button absent or Disabled");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public void EnterBirthYear() throws InterruptedException
	{
		//birth year
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > div > div > div:nth-child(1) > div > div.Igw0E.IwRSH.eGOV_._4EzTm.bkEs3.DhRcB > div > div > span > span:nth-child(3) > select")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "BirthYear button is enabled");
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > div > div > div:nth-child(1) > div > div.Igw0E.IwRSH.eGOV_._4EzTm.bkEs3.DhRcB > div > div > span > span:nth-child(3) > select"))).sendKeys("1999");
		}
		else{
			test.log(LogStatus.FAIL, "BirthYear button absent or Disabled");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=9)
	public void NextSignup() throws InterruptedException
	{
		//next button
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[6]/button")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Next button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[6]/button"))).click();
		}
		else{
			test.log(LogStatus.FAIL, "Next button absent or Disabled");
		}
		Thread.sleep(20000);
		System.out.println("Thread will wait for otp");	
	}
	
	@Test(priority=10)
	public void ConfirmOTP() throws InterruptedException
	{
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div/div/form/div[2]/button")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "Confirm button is enabled");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div/div/form/div[2]/button"))).click();
		}
		else{
			test.log(LogStatus.FAIL, "Confirm button absent or Disabled");
		}
	}
	
}

