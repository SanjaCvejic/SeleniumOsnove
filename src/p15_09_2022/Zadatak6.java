package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) {
		// Napisati program koji ucitava stranicu Zadatak6.html
		// Skinite Zadatak6.html sa drajva. Otvorite u pretrazivacu duplim klikom na
		// fajl i Downloads-a i ikopirajte url. To je url za get u programu
		// I na stranici dodaje 5 poruka �IT Bootcamp�
		// Potrebno je u svakoj iteraciji kliknuti na dugme Show in
		// Sacekati da se novi element pojavi pre nego sto se doda sledeci

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Sanja/Downloads/Zadatak6.html");

		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("showInBtn")).click();
			driver.findElement(By.id("id-" + i));
		}
		driver.quit();
	}
}
