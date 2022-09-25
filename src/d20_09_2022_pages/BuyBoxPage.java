package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {

//		BuyBoxPage koja pribavlja:
//		input za kolicinu
//		select za velicinu
//		add to cart dugme
//		add to wishlist dugme
//		metodu koja vraca element boje 
//		Metoda kao parametar prima naziv boje 
//		(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//		prema trazenoj vrednosti.
//		metodu koja skrola do ovog dela stranice

	private WebDriver driver;
	private WebDriverWait wait;

	public BuyBoxPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public WebElement getQuantityInput() {
		return driver.findElement(By.xpath("//*[@name='qty']"));
	}

	public Select getSizeSelect() {
		Select size = new Select(driver.findElement(By.tagName("select")));
		size.getOptions();
		return size;
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id='add_to_cart']/button"));
	}

	public WebElement getAddToWishListLink() {
		return driver.findElement(By.id("wishlist_button"));
	}

	public WebElement getColorElementByColor(String color) {
		return driver.findElement(By.xpath("//*[@id='color_to_pick_list']//a[@title='" + color + "']"));
	}

	public void scrollToBuyBox() {
		WebElement buyBox = driver.findElement(By.className("primary_block"));
		Actions action = new Actions(driver);
		action.scrollToElement(buyBox).perform();
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
