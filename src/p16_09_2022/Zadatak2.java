package p16_09_2022;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// Napisati program testira upload funkcionalnost:
		//Ucitava stranicu https://crop-circle.imageonline.co/#circlecropresult
		//Uploadujte sliku na sajt
		//Kliknite na dugme Crop Circle

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		Thread.sleep(5000);
//        new Actions(driver)
//                .moveToElement(driver.findElement(By.xpath("//*[text()='Check out the crop circle tool demo here']")))
//                .perform();
		
		driver
			.findElement(By.id("inputImage"))
			.sendKeys(new File("img/flowers.jng").getAbsolutePath());
			
		
		driver.findElement(By.id("photobutton")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
