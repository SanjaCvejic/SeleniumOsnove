package p19_09_2022;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Kreirati klasu KatalonLoginTests za testove
//Base url: https://cms.demo.katalon.com

public class KatalonLoginTest {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	// Test #1: Visit login page from Nav bar
	// Koraci:
	// Ucitati home stranicu
	// Kliknuti na My account link
	// Verifikovati da je naslov stranice My account – Katalon Shop
	// Verifikovati da se u url-u stranice javlja /my-account
	// Za sve validacije ispisati odgovarajuce poruke u slucaju greske
	//

	@Test(priority = 100)
	public void visitLoginPageFromNavBar() {
		driver.get(baseUrl + "/my-account/");

		String actualTitle = driver.getTitle();
		String expectedTitle = "My account – Katalon Shop";

		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");
		String expectedText = "/my-account";
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains(expectedText), "Url not contains /my-account");

	}

	// Test #2: Check input types
	// Koraci:
	// Ucitati /my-account stranicu
	// Verifikovati da polje za unos email-a za atribu type ima vrednost text
	// Verifikovati da polje za unos lozinke za atribut type ima vrednost password
	// Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
	// Verifikovati da je Remember me checkbox decekiran.
	// Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test(priority = 200)
	public void checkInputTypes() {
		driver.findElement(By.xpath("//*[@class=' nav-menu']/li[3]/a")).click();

		String actualType = driver.findElement(By.xpath("//input[@name = 'username']")).getAttribute("type");
		String expectedType = "text";
		Assert.assertEquals(actualType, expectedType, "ERROR: Type no expected - text.");

		String actualType2 = driver.findElement(By.xpath("//input[@name = 'password']")).getAttribute("type");
		String expectedType2 = "password";
		Assert.assertEquals(actualType2, expectedType2, "ERROR: Type no expected - password.");

		String actualType3 = driver.findElement(By.xpath("//input[@value = 'forever']")).getAttribute("type");
		String expectedType3 = "checkbox";
		Assert.assertEquals(actualType3, expectedType3, "ERROR: Type no expected - checkbox.");

		WebElement checkbox = driver.findElement(By.id("rememberme"));
		boolean check = checkbox.isSelected();
		System.out.println("PROVERA " + check);
		Assert.assertFalse(check, "EROR: Checkbox - check.");
	}

//	Test #3: Display error when credentials are wrong
//		Podaci: 
//		email: invalidemail@gmail.com
//		password: invalid123
//		Koraci: 
//		Ucitati /my-account stranicu
//		Unesite email
//		Unesite password
//		Kliknite na login dugme
//		Verifikovati da postoji element koji prikazuje gresku
//		Verifikovati da je prikazana greska ERROR: Invalid email address
//		Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//		Verifikovati da smo idalje na login stranici posle greske,
//		tako sto proveravamo da se url-u javlja /my-account

	@Test(priority = 300)
	public void displayErrorWhenCredentialsAreWrong() {
		driver.findElement(By.xpath("//*[@class=' nav-menu']/li[3]/a")).click();
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("invalidemail@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("invalid123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		boolean hasError = 
//		driver.findElements(By.className("woocommerce-error")).size() >= 0;
//Assert.assertFalse(hasError, "");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-error")));

		Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
				"ERROR: Invalid email address. Lost your password?",
				"Error is not displayed when credentials are invalid.");

		Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Not on my account page.");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
