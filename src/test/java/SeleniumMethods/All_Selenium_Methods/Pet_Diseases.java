package SeleniumMethods.All_Selenium_Methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class Pet_Diseases {
	WebDriver driver;
	Actions a;
	List<WebElement> statesName;
	
	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Altorum Leren Employ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public void petDiseasesMap() throws InterruptedException {
		
		 driver.switchTo().frame(driver.findElement(By.xpath("//div/iframe")));
	
		a = new Actions(driver);
		a.scrollByAmount(0, 500).build().perform();
		statesName = 	driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='features']//*[@class = 'region']"));
	
	System.out.println(statesName.size());
	for(int i=0;i<statesName.size();i++) {
		System.out.println(statesName.get(i).getAttribute("id"));
		a.moveToElement(statesName.get(i)).perform();
		
		Thread.sleep(200);
		
	if(statesName.get(i).getAttribute("id").equalsIgnoreCase("new-york")) {
		a.moveToElement(statesName.get(i)).click().perform();
		Thread.sleep(200);
		break;
		}
	
	}
	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.quit();
	}

}
