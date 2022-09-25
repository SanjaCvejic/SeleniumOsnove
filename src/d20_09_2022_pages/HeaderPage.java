package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

//HeaderPage koja pribavlja:
//shop phone element - gde je prikazan broj telefona
//contact us link
//sign in link

public class HeaderPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement getShopPhoneElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'shop-phone')]//strong"));
	}

	public WebElement getContactUsLink() {
		return driver.findElement(By.xpath("//*[@id='contact-link']/a"));
	}

	public WebElement getSingInLink() {
		return driver.findElement(By.className("login"));
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean getVisibilityOfPhoneNumber() {
		boolean visiblePhoneNumber = true;

		try {
			driver.findElement(By.className("shop-phone")).findElement(By.tagName("strong"));
		} catch (Exception e) {
			visiblePhoneNumber = false;
		}

		return visiblePhoneNumber;
	}
}
