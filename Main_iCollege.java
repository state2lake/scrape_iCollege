package testPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Main_iCollege {

	static String url = "https://gastate.view.usg.edu/";
	static WebDriver driver = new SafariDriver();
	static String user = "jclark81";
	static String pass = "Chicagokids1!";
	
	@Test (priority=1)
	public static void getConnected() {

		System.out.println("		Connection Passed \n" + " " + " ---------------------------------------------- ");

		driver.get(url);
		driver.manage().window().maximize();

	}
	@Test (priority=2)
	public static void login() {

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				".//*/div[@class='custom_portal_row']/div[@class='custom_portal_col_4']/form/button[@class='custom_portal_button']")));
		element.click();

	}
	@Test (priority=3)
	public static void credentials() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(By.id("loginForm:username")));
		element.sendKeys(user);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginForm:password")));
		element2.sendKeys(pass);

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element3 = wait1.until(ExpectedConditions.elementToBeClickable(By.id("loginForm:loginButton")));
		element3.click();

	}
	@Test (priority=4)
	public static void clickAlerts() {

		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*/div[@class='d2l-navigation-s-notification'][3]/d2l-dropdown/button[@class='d2l-navigation-s-button-highlight "
						+ "d2l-dropdown-opener']/d2l-icon[@class='x-scope d2l-icon-0']")));
		element.click();

	}
	@Test (priority=5)
	public static void getAlerts() {

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String alerts = driver.findElement(By.id("AB_DL_PH_Grades")).getText();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("alertFile.txt", true))) {
			writer.flush();
			writer.write(alerts);
			writer.newLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test (priority=6)
	public static void quitDriver( ) {
		driver.quit();
	}
}
