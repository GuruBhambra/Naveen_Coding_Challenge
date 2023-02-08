package SeleniumMethods.All_Selenium_Methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class GoogleFlights {

	WebDriver driver;
	WebDriverWait wait;
	String destination = "Guwahati";
	String destAirport = "Bordoloi";
	String Budget = "11044";
	String travelDate = "Sun, Feb 26";
	String returnDate = "Sun, Apr 16";
	
	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Altorum Leren Employ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://www.google.com/travel/flights");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void getFlightName() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		/*driver.findElement(By.xpath("//input[@aria-labelledby= 'i16']")).clear();
		
		driver.findElement(By.xpath("//input[@aria-labelledby= 'i16']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//input[@aria-label='Where else?']")).sendKeys("Delhi");

		try {
			List<WebElement> fromList = driver
					.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='w1ZvBc']"));
			for (int k = 0; k < fromList.size(); k++) {
				if (fromList.get(k).getText().contains("Indira")) {
					fromList.get(k).click();
				}
			}
		}
		catch (StaleElementReferenceException e) {
			List<WebElement> fromList = driver
					.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='w1ZvBc']"));
			for (int k = 0; k < fromList.size(); k++) {
				if (fromList.get(k).getText().contains("Indira")) {
					fromList.get(k).click();
				}
			}
		}*/
		driver.findElement(By.xpath("//input[@aria-labelledby = 'i22']")).sendKeys(destination);
		driver.findElement(By.xpath("(//input[@aria-label='Where else?'])[2]")).sendKeys(destination);
		try {
			List<WebElement> destLists = driver
					.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@jsname='V1ur5d']"));
			for (int i = 0; i < destLists.size(); i++) {
				if (destLists.get(i).getText().contains(destAirport)) {
					destLists.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> destLists = driver
					.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@jsname='V1ur5d']"));
			for (int i = 0; i < destLists.size(); i++) {
				if (destLists.get(i).getText().contains(destAirport)) {
					destLists.get(i).click();
				}
			}
		}

		driver.findElement(By.xpath("(//input[@placeholder='Departure'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label= \"" + travelDate + "\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label= \"" + returnDate + "\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Done'])[2]")).click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'xOtf5 QB2Jof']")));
		//String flightdeatils = driver.findElement(By.xpath("(//ul[@class= 'Rk10dc']/li/descendant::div[@class = 'yR1fYc'])[2]")).getText();
		//System.out.println(flightdeatils);
		List<WebElement> flightDetailList = driver
				.findElements(By.xpath("//ul[@class= 'Rk10dc']/li/descendant::div[@class = 'yR1fYc']"));

		for (int j = 0; j < flightDetailList.size(); j++) {
			String name = flightDetailList.get(j).getText();
			if (name.contains("Nonstop") && name.contains("2 hr 55 min") && name.contains("8:25 AM\r\n"
					+ " – \r\n"
					+ "11:20 AM")) {
				String flightName = driver
						.findElement(By
								.xpath("//ul[@class='Rk10dc']/li/descendant::div[@class='sSHqwe tPgKwe ogfYpf']/span"))
						.getText();

				System.out.println(flightName);
			}
			else {
				System.out.println("No Flights to display for these records");
			}
		}
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
