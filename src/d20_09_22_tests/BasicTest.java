package d20_09_22_tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import d20_09_2022_pages.BuyBoxPage;
import d20_09_2022_pages.HeaderPage;
import d20_09_2022_pages.LayerCartPage;
import d20_09_2022_pages.TopMenuPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected String baseUrl = "http://automationpractice.com/";
	protected BuyBoxPage buyBoxPage;
	protected TopMenuPage topMenuPage;
	protected HeaderPage headerPage;
	protected LayerCartPage layerCartPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		topMenuPage = new TopMenuPage(driver);
		buyBoxPage = new BuyBoxPage(driver);
		headerPage = new HeaderPage(driver);
		layerCartPage = new LayerCartPage(driver);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
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
