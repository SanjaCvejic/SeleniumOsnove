package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) {
		// Ucitati stranicu https://demoqa.com/modal-dialogs
		// Kliknuti na dugme Large modal
		// Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/modal-dialogs");
		driver.findElement(By.id("showLargeModal")).click();

		try {
			driver.findElement(By.className("modal-body"));
			System.out.println("Ima Large modala");
		} catch (NoSuchElementException error) {
			System.out.println("Desila se greska.");
		}
		driver.quit();
	}
}
