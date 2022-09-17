package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// Napisati program koji ucitava stranicu 
		//https://s.bootsnipp.com/iframe/klDWV i ceka
		//da se ucita progress bar na 100% a zatim ispisuje tekst
		//u konzoli �Stranica ucitana�

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.get("https://s.bootsnipp.com/iframe/klDWV");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.attributeToBe(By.className("glow"), "style", "width: 100%;"));
		System.out.println("Stranica ucitana.");
		Thread.sleep(5000);
		driver.quit();
	}

}
