package d13_09_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		// Napisati program koji matematicku formulu koju korisnik unese izvrsaav na
		// stranici:
		// Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
		// Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
		// 1243+329=
		// 21912-4=
		// 12913÷4=
		// U programu se formula unosi kao jedan string i potrebno je razbiti formulu na
		// karaktere.
		// Zatim u odnosu na karakter uradite odredjenu logiku

		Scanner s = new Scanner(System.in);
		System.out.println(
				"Unesite matematicki izraz, poput 1243+329. Mozete uneti znak za deljenje, mnozenje, sabiranje i oduzimanje: ");
		String unos = s.next();
		ArrayList<Character> chars = new ArrayList<>();
		for (char ch : unos.toCharArray()) {
			chars.add(ch);
		}
		for (int i = 0; i < chars.size(); i++) {
			System.out.println(chars.get(i));
		}
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		for (int i = 0; i < chars.size(); i++) {
			driver.findElement(By.id("display")).sendKeys(chars.get(i).toString());
			Thread.sleep(500);
			driver.findElement(By.id("calculatorWrap"));
		}

		driver.findElement(By.id("display")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		s.close();
		driver.quit();
	}

}
