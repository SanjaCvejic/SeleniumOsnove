package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		// Ucitava stranicu https://demoqa.com/login
		// Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
		// Zatim ceka 5sekundi da se korisnik uloguje
		// Proverava da li se korisnik ulogovao, tako sto se proverava postojanje
		// dugmeta Logout. Ispisati odgovarajucu poruku u konzoli za rezultat
		// loginovanja.
		// Klikce na dugme za logout
		// Gasi stranicu

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
//		WebElement searchInput = driver.findElement(By.xpath("//*[@name='q']"));
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		try {
			driver.findElement(By.id("submit"));
			System.out.println("Ima dugme za log out.");
		} catch (NoSuchElementException error) {
			System.out.println("Nema dugme.");
		}
		WebElement logout = driver.findElement(By.id("submit"));
		logout.click();
		driver.quit();
	}
}
