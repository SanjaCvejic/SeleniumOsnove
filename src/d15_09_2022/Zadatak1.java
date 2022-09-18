package d15_09_2022;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// Napisati program koji:
		//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
		//	Klikce na svaki iks da ugasi obavestenje i proverava
		//da li se nakon klika element obrisao sa stranice i 
		//ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
		//	POMOC: Brisite elemente odozdo.
	
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		Thread.sleep(5000);	
		int nrRows = driver.findElements(By.xpath("//div[@class = 'col-md-12']/div")).size();
		int n;
		for (int i = 0; i < nrRows; i ++) {
		n = nrRows-i;
		driver.findElement(By.xpath("//div[@class = 'col-md-12']/div[" + n + "]/button")).click();
		try {
			driver.findElement(By.xpath("//div[@class = 'col-md-12']/div[" + n + "]"));
			System.out.println("Red " + n + " nije obrisan.");
	} catch (NoSuchElementException error) {
		System.out.println("Red " + n + " je obrisan.");
	}
		
//		int nr = driver.findElements(By.xpath("//div[@class = 'col-md-12']/div")).size();
//		if (nr == n-1) {
//			System.out.println("Red " + n + " je obrisan.");
//		} else{
//			System.out.println("Red nije obrisan.");
//		}
		Thread.sleep(500);
		}
		
		driver.quit();

		//	(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
//		
//		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
//
//		for (int i = 0; i < 5; i ++) {
//		driver.findElement(By.className("close")).click();
//		int x = driver.findElements(By.xpath("//div[@class = 'col-md-12']/div")).size();
//		if (x == 4 - i) {
//			int red = i+1;
//			System.out.println("Red " + red + " je obrisan.");
//		} else{
//			System.out.println("Red nije obrisan.");
//			}
//		Thread.sleep(500);
//		}
//		
//		driver.quit();
	}

}
