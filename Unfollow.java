package Project;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Unfollow {
	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;
	WebDriverWait wait;
	
	String baseurl="https://www.instagram.com/";
	String driverpath="E:\\Semester 6\\TestAutomation\\WebDrivers\\chromedriver_win32\\chromedriver.exe";
	
	@BeforeClass
	public void initReport(){
		report = new ExtentReports("E:\\Semester 6\\TestAutomation\\Unfollow.html");
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
		test = report.startTest("My Project Report - "+result.getName());
	}
	@AfterMethod
	public void endReport(){
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=0, dataProvider = "logindp", dataProviderClass = LogInDetails.class)
	public void enterUsername(String username, String Password) throws InterruptedException{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
		if(driver.findElement(By.name("username")).getAttribute("value").equals(username)){
			test.log(LogStatus.PASS, "Entered username successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Couldn't enter username");
		}
		test.log(LogStatus.PASS, "Moving to next step");
		Thread.sleep(2000);
	}
	
	@Test(priority=1, dataProvider = "logindp", dataProviderClass = LogInDetails.class)
	public void enterPassword(String username, String Password) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(Password);
		if(!driver.findElement(By.name("password")).getAttribute("value").equals("")){
			test.log(LogStatus.PASS, "Entered password successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Couldn't enter password");
		}
		test.log(LogStatus.PASS, "Moving to next step");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void clickLogin(){
		WebElement btn=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")));
		if(btn!=null && btn.isEnabled()){
			test.log(LogStatus.PASS, "/Username submit button present and Enabled");
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();
		}
		else{
			test.log(LogStatus.FAIL, "Email submit button absent or Disabled");
		}	
		test.log(LogStatus.PASS, "Login Successful");
	}
	@Test(priority=3)
	public void SaveLoginInfo_Off() throws InterruptedException
	{
		WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button")));
		if(Save!=null && Save.isEnabled()){
			test.log(LogStatus.PASS, "Save info off is enabled");
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button")).click();
		}
		else{
			test.log(LogStatus.FAIL, "Save info button absent");
		}	
		test.log(LogStatus.PASS, "Save Info Off Successful");
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void Notification_Off() throws InterruptedException
	{
		WebElement Notify = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")));
		if(Notify!=null && Notify.isEnabled()){
			test.log(LogStatus.PASS, "Notification not now is enabled");
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click();
		}
		else{
			test.log(LogStatus.FAIL, "Not Now button absent");
		}	
		test.log(LogStatus.PASS, "Notification not now is Successful");
		Thread.sleep(3000);
	}
	@Test(priority=5)
	public void Unfollow()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input"))).sendKeys("anmolsaini469");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/a/div/div[2]/div[2]/div"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-root > section > main > div > header > section > div.nZSzR > div.Igw0E.IwRSH.eGOV_.ybXk5._4EzTm > div > div:nth-child(2) > div > span > span.vBF20._1OSdk > button > div > span"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[1]"))).click();
		test.log(LogStatus.PASS, "Unfollow Successfull");
	}
}