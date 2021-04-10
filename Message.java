package Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Message {
	WebDriver driver;
	WebDriverWait wait;
	
	String baseurl="https://www.instagram.com/";
	String driverpath="E:\\Semester 6\\TestAutomation\\WebDrivers\\chromedriver_win32\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,40);
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	@Test(priority=0, dataProvider = "logindp", dataProviderClass = LogInDetails.class)
	public void enterUsername(String username, String Password) throws InterruptedException{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
		if(driver.findElement(By.name("username")).getAttribute("value").equals(username)){
			System.out.println("Entered username successfully");
		}
		else{
			System.out.println("Couldn't enter username");
		}
		
		Thread.sleep(2000);
	}
	
	@Test(priority=1, dataProvider = "logindp", dataProviderClass = LogInDetails.class)
	public void enterPassword(String username, String Password) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(Password);
		if(!driver.findElement(By.name("password")).getAttribute("value").equals("")){
			System.out.println("Entered password successfully");
		}
		else{
			System.out.println("Couldn't enter password");
		}
		System.out.println("Moving to next step");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void clickLogin(){
		WebElement btn=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")));
		if(btn!=null && btn.isEnabled()){
			System.out.println("Username submit button present and Enabled");
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();
		}
		else{
			System.out.println("Email submit button absent or Disabled");
		}	
		System.out.println("Login Successful");
	}
	@Test(priority=3)
	public void SaveLoginInfo_Off()
	{
		WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button")));
		if(Save!=null && Save.isEnabled()){
			System.out.println("Save info off is enabled");
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button")).click();
		}
		else{
			System.out.println("Save info button absent");
		}	
		System.out.println("Save Info Off Successful");
	}
	@Test(priority=4)
	public void Notification_Off()
	{
		WebElement Notify = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")));
		if(Notify!=null && Notify.isEnabled()){
			System.out.println("Notification not now is enabled");
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click();
		}
		else{
			System.out.println("Not Now button absent");
		}	
		System.out.println("Notification not now is Successful");
	}
	
	@Test(priority=5)
	public void Message()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input"))).sendKeys("anmolsaini469");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/a/div/div[2]/div[2]/div"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div[1]/div/button"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/textarea"))).sendKeys("helllo !!!");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[3]/button"))).click();
		System.out.println("Message Sent Successfully");
	}
}