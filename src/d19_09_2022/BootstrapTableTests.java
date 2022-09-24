package d19_09_2022;

//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.imageio.ImageIO;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class BootstrapTableTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

//	Test #1: Edit Row
//	Podaci:
//	First Name: ime polaznika
//	Last Name: prezime polaznika
//	Middle Name: srednje ime polanzika
//	Koraci:
//	Ucitati stranu /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Klik na Edit dugme prvog reda
//	Sacekati da dijalog za Editovanje bude vidljiv
//	Popuniti formu podacima. 
//	Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. 
//	Klik na Update dugme
//	Sacekati da dijalog za Editovanje postane nevidljiv
//	Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//	Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//	Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test(priority = 100)
	public void editRow() throws InterruptedException {
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Not on my account page.");
		driver.findElement(By.xpath("//button[@data-target='#edit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-header")));
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).clear();
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Sanja");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).clear();
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Cvejic");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder='Middle Name']")).clear();
		driver.findElement(By.xpath("//*[@placeholder='Middle Name']")).sendKeys("M");
		Thread.sleep(5000);
		driver.findElement(By.id("up")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-title")));

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='d1']/td[2]")).getText(), "Sanja",
				"Invalid First Name input.");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='d1']/td[3]")).getText(), "Cvejic",
				"Invalid Last Name input.");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='d1']/td[4]")).getText(), "M",
				"Invalid Midle Name input.");
	}

//	Test #2: Delete Row
//	Podaci:
//	First Name: ime polaznika
//	Last Name: prezime polaznika
//	Middle Name: srednje ime polanzika
//	Koraci:
//	Ucitati stranu /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Klik na Delete dugme prvog reda
//	Sacekati da dijalog za brisanje bude vidljiv
//	Klik na Delete dugme iz dijaloga 
//	Sacekati da dijalog za Editovanje postane nevidljiv
//	Verifikovati da je broj redova u tabeli za jedan manji
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test(priority = 200)
	public void deleteRow() {

		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Not on my account page.");
		driver.findElement(By.xpath("//button[@data-target='#delete']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("strong")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-body[2]")));
		List<WebElement> x = driver.findElements(By.xpath("//tbody/tr[1]"));
		Assert.assertFalse(x.size() != 1, "Error - nr rows > 1");

	}

//	Test #3: Take a Screenshot
//	Koraci:
//		Ucitati stranu  /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Kreirati screenshot stranice. 
//		Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg.
//		Na putanji: src/paket_za_domaci/nazivslike.png

	@Test(priority = 300)
	public void takeAScreenshoot() throws IOException {

		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Not on my account page.");

		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File("src/d19_09_2022/screenshot.jpg");
		com.google.common.io.Files.copy(SourceFile, DestFile);
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
