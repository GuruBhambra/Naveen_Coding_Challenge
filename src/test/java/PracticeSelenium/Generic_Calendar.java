//package PracticeSelenium;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//@Test
//public class Generic_Calendar {
//	static WebDriver driver;
//	static Actions a;
//	static WebDriverWait wait;
//	static String url = "https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only+Goibibo&utm_term=%21SEM%21DF%21G%21Brand%21RSA%21108599293%216504095653%21602838584772%21e%21goibibo%21c%21&gclid=CjwKCAiA0JKfBhBIEiwAPhZXD23Zn4r2ubXFcdqM_EjJNa_cbV0s1J2gzeyduPlY6s6n51v-usd11xoC-gEQAvD_BwE";
//	static By deptCity = By.xpath("(//input[@type='text'])[1]");
//	static By deptCityList = By.xpath("//ul[@id='autoSuggest-list']//li/descendant::div[@class='sc-jObWnj bRMwkb']");
//	static	By arrivalCity = By.cssSelector("input[type='text']");
//	static	By arrivalCityList = By.xpath("//ul[@id='autoSuggest-list']//li/descendant::div");
//	static	By closeBtn = By.xpath(".//*[@class = 'logSprite icClose']");
//	static	By mutli = By.xpath("//ul[@class = 'sc-gsNilK hRWUSL']//li/descendant::span[text()='Multi-city']");
//	static	By goScan = By.cssSelector("p[class = 'sc-jlwm9r-1 dRQhOp']");
//	static	By deptPlaceHolder = By.cssSelector(".sc-bYoBSM.eyNSEu.fswWidgetPlaceholder");
//	static	By Month = By.cssSelector(".DayPicker-Caption");
//	static	By nextMonth = By.cssSelector("span[aria-label='Next Month']");
//	static	By date = By.cssSelector("div[aria-label = 'Wed Jul 12 2023']");
//	static	By done = By.xpath("//span[text()='Done']");
//	public static void main(String[]args) throws InterruptedException {
//
//		System.setProperty("webdriver.chome.driver",
//				"C:\\Users\\Altorum Leren Employ\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(url);
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//
//		a = new Actions(driver);
//		try {
//			if (driver.findElement(closeBtn).isDisplayed()) {
//				a.moveToElement(driver.findElement(closeBtn)).click().build().perform();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(mutli));
//			}
//		} catch (Exception e) {
//			System.out.println("No Webelement found");
//		}
//		a.moveToElement(driver.findElement(goScan)).click().build().perform();
//
//		driver.findElement(deptPlaceHolder).click();
//		Thread.sleep(1000);
//		driver.findElement(deptCity).sendKeys("De");
//		Thread.sleep(1000);
//		try {
//
//			List<WebElement> deptCities = driver.findElements(deptCityList);
//			for (int i = 0; i < deptCities.size(); i++) {
//
//				if (deptCities.get(i).getText().contains("Dimapur")) {
//					System.out.println(deptCities.get(i).getText());
//					deptCities.get(i).click();
//				}
//			}
//		} catch (StaleElementReferenceException e) {
//
//			System.out.println("Sorry No Data Found");
//
//		}
//		driver.findElement(arrivalCity).sendKeys("a");
//
//		try {
//
//			List<WebElement> arrivalCities = driver.findElements(arrivalCityList);
//			for (int j = 0; j < arrivalCities.size(); j++) {
//
//				if (arrivalCities.get(j).getText().contains("Guru")) {
//					System.out.println(arrivalCities.get(j).getText());
//					arrivalCities.get(j).click();
//				}
//			}
//		}
//
//		catch (StaleElementReferenceException e) {
//			System.out.println("Sorry No Data Found");
//
//		}
//		
//		selectDate("23", "November", "2023");
//
//	}
//	
//	public static String[] splitDate(String getMonthYear) {
//		
//		return getMonthYear.split(" ");
//	}
//	
//	public static void selectDate(String expectedDate, String expectedMonth, String expectedYear) throws InterruptedException {
//		
//		String getMonthYear = driver.findElement(Month).getText();
//
//		while (!(splitDate(getMonthYear)[0].equalsIgnoreCase(expectedMonth)) && (splitDate(getMonthYear)[1].equalsIgnoreCase(expectedYear))) {
//
//			driver.findElement(nextMonth).click();
//			getMonthYear = driver.findElement(Month).getText();
//
//		}
//
//		driver.findElement(By.xpath("(//p[text()='"+expectedDate+"'])[2]")).click();
//		a.scrollByAmount(0, 180).build().perform();
//		Thread.sleep(1500);
//		driver.findElement(done).click();
//		Thread.sleep(3000);
//		driver.quit();
//		
//	}
//
//}

package PracticeSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic_Calendar {

	static WebDriver driver;
	static Actions a;
	static WebDriverWait wait;
	static String url = "https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only+Goibibo&utm_term=%21SEM%21DF%21G%21Brand%21RSA%21108599293%216504095653%21602838584772%21e%21goibibo%21c%21&gclid=CjwKCAiA0JKfBhBIEiwAPhZXD23Zn4r2ubXFcdqM_EjJNa_cbV0s1J2gzeyduPlY6s6n51v-usd11xoC-gEQAvD_BwE";
	static By deptCity = By.xpath("(//input[@type='text'])[1]");
	static By deptCityList = By.xpath("//ul[@id='autoSuggest-list']//li/descendant::div[@class='sc-jObWnj bRMwkb']");
	static By arrivalCity = By.cssSelector("input[type='text']");
	static By arrivalCityList = By.xpath("//ul[@id='autoSuggest-list']//li/descendant::div");
	static By closeBtn = By.xpath(".//*[@class = 'logSprite icClose']");
	static By mutli = By.xpath("//ul[@class = 'sc-gsNilK hRWUSL']//li/descendant::span[text()='Multi-city']");
	static By goScan = By.cssSelector("p[class = 'sc-jlwm9r-1 dRQhOp']");
	static By deptPlaceHolder = By.cssSelector(".sc-bYoBSM.eyNSEu.fswWidgetPlaceholder");
	static By Month = By.cssSelector(".DayPicker-Caption");
	static By nextMonth = By.cssSelector("span[aria-label='Next Month']");
	static By date = By.cssSelector("div[aria-label = 'Wed Jul 12 2023']");
	static By done = By.xpath("//span[text()='Done']");

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chome.driver",
				"C:\\Users\\Altorum Leren Employ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		a = new Actions(driver);
		try {
			if (driver.findElement(closeBtn).isDisplayed()) {
				a.moveToElement(driver.findElement(closeBtn)).click().build().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(mutli));
			}
		} catch (Exception e) {
			System.out.println("No Webelement found");
		}
		a.moveToElement(driver.findElement(goScan)).click().build().perform();

		driver.findElement(deptPlaceHolder).click();
		Thread.sleep(1000);
		driver.findElement(deptCity).sendKeys("De");
		Thread.sleep(1000);
		try {

			List<WebElement> deptCities = driver.findElements(deptCityList);
			for (int i = 0; i < deptCities.size(); i++) {

				if (deptCities.get(i).getText().contains("Dimapur")) {
					System.out.println(deptCities.get(i).getText());
					deptCities.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {

			System.out.println("Sorry No Data Found");

		}
		driver.findElement(arrivalCity).sendKeys("a");

		try {

			List<WebElement> arrivalCities = driver.findElements(arrivalCityList);
			for (int j = 0; j < arrivalCities.size(); j++) {

				if (arrivalCities.get(j).getText().contains("Guru")) {
					System.out.println(arrivalCities.get(j).getText());
					arrivalCities.get(j).click();
				}
			}
		}

		catch (StaleElementReferenceException e) {
			System.out.println("Sorry No Data Found");

		}
		selectDate("34", "February", "2024");
	}

	public static String[] splitDate(String getMonthYear) {
		return getMonthYear.split(" ");
	}

	public static void selectDate(String expectedDate, String expectedMonth, String expectedYear)
			throws InterruptedException {
		
		if(expectedMonth=="February" && (Integer.parseInt(expectedDate))>29) {
			
			System.out.println("Sorry" +" "+expectedDate+" "+"February"+ " "+"is not valid date!!");
		}
		if((Integer.parseInt(expectedDate))<32) {

		String getMonthYear = driver.findElement(Month).getText();

		while (!(splitDate(getMonthYear)[0].equalsIgnoreCase(expectedMonth))
				&& (splitDate(getMonthYear)[1].equalsIgnoreCase(expectedYear))) {

			driver.findElement(nextMonth).click();
			getMonthYear = driver.findElement(Month).getText();
		}

		driver.findElement(By.xpath("(//p[text()='" + expectedDate + "'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//p[text()='" + expectedDate + "'])[2]")).getText());
		a.scrollByAmount(0, 180).build().perform();
		Thread.sleep(1500);
		driver.findElement(done).click();
		Thread.sleep(3000);
		driver.close();

	}
		else {
			System.out.println("sorry " + expectedDate + " "+expectedMonth + " is not a valid date");
		}

		driver.quit();
}
}