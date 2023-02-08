package SeleniumMethods.All_Selenium_Methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Test
public class Javascriptexecutorss {

	WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Altorum Leren Employ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.get("https://www.google.com/travel/flights");
		//driver.get("https://www.amazon.com");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.navigate().to("https://www.google.com");
	}
	
	
//	public void googleSearch() {
//		driver.findElement(By.name("q")).sendKeys("test");
//		//List<WebElement> lists = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class = 'pcTkSc']"));
//		
//		List<WebElement>lists = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
//		for(int i=0;i<lists.size();i++) {
//			
//			if(lists.get(i).getText().equalsIgnoreCase("testosterone")) {
//				lists.get(i).click();
//				System.out.println(lists.get(i).getText());
//				break;
//			}
//			
//		}
	
	
	public void clearData() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@aria-labelledby= 'i16']")).clear();
		driver.findElement(By.xpath("//input[@aria-labelledby= 'i16']")).sendKeys("DELHI");
//		driver.findElement(By.xpath("(//input[@placeholder='Departure'])[1]")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jscontroller='Pgogge']")));
//		driver.findElement(By.xpath("//div[@aria-label= 'Tue, Feb 28']")).click();
		Thread.sleep(4000);
		System.out.println("TestPass Congratulations");
	}
	}
	
//	public void javasc() {
//		
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	WebElement search = driver.findElement(By.xpath("(//a[text()='Best Sellers'])[1]"));
//	js.executeScript("arguments[0].click()", search);
//	//js.executeScript("window.scroll(0,700)");
//	
//	Actions a = new Actions(driver);
//	
//}
	//}
	
