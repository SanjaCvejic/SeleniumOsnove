package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3_1 {

	public static void main(String[] args) throws InterruptedException {
		// Ucitati stranicu https://cms.demo.katalon.com/
		// Maksimizovati prozor
		// Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
		// Prostavite duzinu prozora na 700px i visinu na 700px
		// Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cms.demo.katalon.com/");
		WebElement dugme = driver.findElement(By.className("menu-toggle"));
		if (dugme.isDisplayed()) {
			System.out.println("Dugme je vidljivo.");
		} else {
			System.out.println("Dugme nije vidljivo.");
		}

		Thread.sleep(5000);
		driver.manage().window().setSize(new Dimension(700, 700));
		Thread.sleep(5000);
		WebElement dugme2 = driver.findElement(By.className("menu-toggle"));
		Thread.sleep(5000);
		if (dugme2.isDisplayed()) {
			System.out.println("Dugme je vidljivo.");
		} else {
			System.out.println("Dugme nije vidljivo.");
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
