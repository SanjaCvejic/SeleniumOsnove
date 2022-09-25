package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {

//		TopMenuPage koja pribavlja:
//		metodu koja vraca WOMEN link iz glavnom menija
//		metodu koja vraca DRESSES link iz glavnom menija
//		metodu koja vraca T-SHIRTS link iz glavnom menija
//		metodu koja vraca podmeni za WOMEN
//		metodu koja vraca podmeni za DRESSES

	private WebDriver driver;
	private WebDriverWait wait;

	public TopMenuPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public WebElement getWomanLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[1]/a"));
	}

	public WebElement getDressesLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[2]/a"));
	}

	public WebElement getTshirtsLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[3]/a"));
	}

	public void getHoverWomenMenu() {
		WebElement womenMenu = driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[1]"));
		new Actions(driver).moveToElement(womenMenu).perform();
	}

	public WebElement getWomanDropdownVisibiliti() {
		return driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[1]/ul"));
	}

	public void waitForWomanDropdownVisibiliti() {
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'menu-content')]/li[1]/ul"), "style",
				"display: block;"));
	}

	public void getHoverDressesMenu() {
		WebElement dressesMenu = driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[2]"));
		new Actions(driver).moveToElement(dressesMenu).perform();
	}

	public WebElement getDressesDropdownVisibiliti() {
		return driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[2]/ul"));
	}

	public void waitForDressesDropdownVisibiliti() {
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'menu-content')]/li[2]/ul"), "style",
				"display: block;"));
	}

	public void getHoverTShirtLink() {
		WebElement tShirtMenu = driver.findElement(By.xpath("//*[contains(@class, 'menu-content')]/li[3]"));
		new Actions(driver).moveToElement(tShirtMenu).perform();
	}
}
