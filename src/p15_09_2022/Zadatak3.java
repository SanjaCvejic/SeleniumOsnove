package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {

		// Napisati program koji:
		// Ucitava stranicu https://www.ebay.com/
		// Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
		// Zatim bira random element iz niza opcija koristeci Random. Vodite racuna da
		// random element bude u opsegu broja elemenata niza. Random podsetnik
		// Selektuje random kategoriju izabranu u koraku iznad
		// Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Thread.sleep(5000);
		Select s = new Select(driver.findElement(By.xpath("//select[@name='_sacat']")));
		List<WebElement> opt = s.getOptions();

		for (int i = 0; i < opt.size(); i++) {
			System.out.println(opt.get(i).getText());
			Thread.sleep(1000);
		}

		Random rnd = new Random();
		int pozicija = rnd.nextInt(opt.size() - 1);
		Thread.sleep(1000);
		System.out.println("Izabrana kategorija je: " + opt.get(pozicija).getText());
		Thread.sleep(1000);
		s.selectByIndex(pozicija);
		Thread.sleep(500);
		driver.quit();

	}

}
