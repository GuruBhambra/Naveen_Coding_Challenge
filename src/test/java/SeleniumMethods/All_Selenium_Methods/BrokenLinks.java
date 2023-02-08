package SeleniumMethods.All_Selenium_Methods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Test
public class BrokenLinks {
public WebDriver driver;
SoftAssert soft;
@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Altorum Leren Employ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

public void testMethod() throws MalformedURLException, IOException {
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	soft = new SoftAssert();
	List<WebElement> actualLinks = new ArrayList<>();
	System.out.println(links.size());
	for(int i=0;i<links.size();i++) {
		
		
		if(links.get(i).getAttribute("href").contains("https")||links.get(i).getAttribute("href").contains("http") && (!links.get(i).getAttribute("href").contains("#"))) {
			actualLinks.add(links.get(i));
			
		}
		//System.out.println(actualLinks.size());
	}
	for(int j=0; j<actualLinks.size();j++) {
		HttpURLConnection myurl = (HttpURLConnection)new URL(actualLinks.get(j).getAttribute("href")).openConnection();
		myurl.connect();
		int code =myurl.getResponseCode();
		System.out.println(code);
		soft.assertTrue(code<400, "The link with the text " + actualLinks.get(j).getText() + " is broken with " + code);
	}
}
	
@AfterMethod
public void tearDown() {
	soft.assertAll();
	driver.quit();
}

}////input[@aria-labelledby= 'i16']
