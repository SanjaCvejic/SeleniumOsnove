package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {

		// Napisati program koji prijavljivanju na stranicu
		// http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cms.demo.katalon.com/my-account/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'rememberme')]")).click();
		Thread.sleep(5000);

		// (DOPUNA)
		// Na kraju programa proverite da li je element cekiran.
		// Izguglajte kako mozemo da proverimo da li je element cekiran.

		if (driver.findElement(By.xpath("//*[contains(@id,'rememberme')]")).isSelected() == true) {
			System.out.println("Cekiran je.");
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
