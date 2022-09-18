package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kocka {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji ima:
//			Podesava:
//			implicitno cekanje za trazenje elemenata od 10s
//			implicitno cekanje za ucitavanje stranice od 10s
//			eksplicitno cekanje podeseno na 10s
//			Podaci:
//			Potrebno je u projektu ukljuciti 4 slike.
//			Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
//			Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
//			Koraci:
//			Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//			Maksimizuje prozor
//			Selektuje Image - Front klikom na tu karticu u dnu ekrana	
//		Klik na add photo iz levog navigacionog menia
//		Upload slike. Upload preko File objekta koristeci getAbsolutePath
//		Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//		Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
//		Ceka da dijalog bude vidljiv
//		Klik na Use One Side Only dugme
//		Ceka da se pojavi dijalog sa slikom
//		Klik na Done
//		Ponoviti proces za Left, Right i Back
//		Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		File img = new File("img/front_sanja_cvejic.jpg");
		File img1 = new File("img/right_sanja_cvejic.jpg");
		File img2 = new File("img/left_sanja_cvejic.jpg");
		File img3 = new File("img/back_sanja_cvejic.jpg");

		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();

		driver.findElement(By.className("sc-iIPllB")).click();
		driver.findElement(By.xpath("//div[text() = '+ Add photo']")).click();
		driver.findElement(By.xpath("//input[@type ='file']")).sendKeys(img.getAbsolutePath());
		driver.findElement(By.xpath("//div[contains(@class, 'gmXCBU')]/img[last()]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));
		driver.findElement(By.xpath("//button[text() ='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text() ='Done']")).click();

		driver.findElement(By.xpath("//div[@class='sc-iIPllB icwSSx']/img")).click();
		driver.findElement(By.xpath("//div[text() = '+ Add photo']")).click();
		driver.findElement(By.xpath("//input[@type ='file']")).sendKeys(img1.getAbsolutePath());
		driver.findElement(By.xpath("//div[contains(@class, 'gmXCBU')]/img[last()]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));
		driver.findElement(By.xpath("//button[text() ='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text() ='Done']")).click();

		driver.findElement(By.xpath("//div[@class='sc-iIPllB icwSSx']/img")).click();
		driver.findElement(By.xpath("//div[text() = '+ Add photo']")).click();
		driver.findElement(By.xpath("//input[@type ='file']")).sendKeys(img2.getAbsolutePath());
		driver.findElement(By.xpath("//div[contains(@class, 'gmXCBU')]/img[last()]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));
		driver.findElement(By.xpath("//button[text() ='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text() ='Done']")).click();

		driver.findElement(By.xpath("//div[@class='sc-iIPllB icwSSx']/img")).click();
		driver.findElement(By.xpath("//div[text() = '+ Add photo']")).click();
		driver.findElement(By.xpath("//input[@type ='file']")).sendKeys(img3.getAbsolutePath());
		driver.findElement(By.xpath("//div[contains(@class, 'gmXCBU')]/img[last()]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));
		driver.findElement(By.xpath("//button[text() ='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text() ='Done']")).click();

		
		List<WebElement> listaKonfeta = driver.findElements(By.xpath("//*[contains(@class='sc-hZgfyJ')]/div"));
		
		Random rnd = new Random();
		int x = listaKonfeta.size();
		int izbor = rnd.nextInt(x);
		listaKonfeta.get(izbor).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		try {
			driver.findElement(By.xpath("//*[@action='error']"));
			System.out.println("Greska postoji."); 
		} catch (NoSuchElementException error) {
			System.out.println("Ne postoji greska.");
		}
		
//			Zatvorite pretrazivac
		driver.quit();
	}

}
