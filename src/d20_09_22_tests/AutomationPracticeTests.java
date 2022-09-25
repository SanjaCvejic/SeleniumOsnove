package d20_09_22_tests;


import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//baseUrl: http://automationpractice.com/
//	Test #1:  Adding product to the cart
//Ucitati stranicu /index.php?id_product=1&controller=product
//Odskrolati do buy box-a
//Postavite kolicinu na 3
//Izaberite velicinu L
//Izaberite plavu boju
//Kliknite na dugme add to cart
//Cekajte da dijalog layer cart bude vidljiv
//Verifikovati da je kolicina iz layer cart dijalog 3
//Verifikovati da je velicina L
//Verifikovati da je izabran proizvod sa plavom bojom
//Verifikovati da je total price 3 puta veci od cene proizvoda
//Kliknite na dugme continue shopping
//cekajte da dijalog layer cart postane nevidljiv
//Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organge
//Kliknite na dugme add to cart
//Cekajte da dijalog bude vidljiv
//kliknite na dugme proceed to checkout
//Verifikujte da je naslov stranice Order - My Store

public class AutomationPracticeTests extends BasicTest {

	@Test(priority = 100)
	public void addingProductToTheCart() throws InterruptedException {
		driver.get(baseUrl + "/index.php?id_product=1&controller=product");
		buyBoxPage.scrollToBuyBox();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");
		buyBoxPage.getSizeSelect().selectByVisibleText("L");
		buyBoxPage.getColorElementByColor("Blue").click();
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		Assert.assertEquals(layerCartPage.getProductQuantity().getText(), "3", 
				"Error:  quantity not 3!");
		Assert.assertTrue(layerCartPage.getProductAtributes().getText().endsWith("L"), 
				"Error:  size not L !");
		Assert.assertTrue(layerCartPage.getProductAtributes().getText().startsWith("Blue"), 
				"Error: collor not blue!");
		layerCartPage.getContinueShoppingButton().click();
		layerCartPage.waitForDialogToBeInvisible();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		buyBoxPage.getSizeSelect().selectByVisibleText("S");
		buyBoxPage.getColorElementByColor("Orange").click();
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		layerCartPage.getProcedToCheckoutButton().click();
		Assert.assertEquals(buyBoxPage.getTitle(), "Order - My Store", 
				"Error: title Order - My Store isn't displayed");

	}

//	Test #2:  Top menu mouse over
//Predjite misem preko women linka. Koristan link kako da predjete misem preko nekog elementa link
//Verifikujte da je podmeni za women deo vidljiv
//Predjite misem preko dresses linka. 
//Verifikujte da je podmeni za dresses deo vidljiv
//Predjite misem preko t-shirts linka. 
//Verifikujte podmeniji za womens i dresses nevidljivi
//Ukoliko je potrebno ukljucite odgovarajuca cekanja, kojim bi se sacekalo da stranica dodje u odgovarajuce stanje
//Provera preko za vidljivost preko soft assert-a

	@Test(priority = 200)
	public void topMenuMouseOver() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		topMenuPage.getHoverWomenMenu();
		topMenuPage.waitForWomanDropdownVisibiliti();
		softAssert.assertEquals(topMenuPage.getWomanDropdownVisibiliti()
				.getAttribute("style"), "display: block;",
				"Error: Dropdown menu Women  isnt visible, it should be visible!");
		topMenuPage.getHoverDressesMenu();
		topMenuPage.waitForDressesDropdownVisibiliti();
		softAssert.assertEquals(topMenuPage.getDressesDropdownVisibiliti()
				.getAttribute("style"), "display: block;",
				"Error: Dropdown menu Dresses  isnt visible, it should be visible!");
		topMenuPage.getHoverTShirtLink();
		softAssert.assertFalse(
				topMenuPage.getDressesDropdownVisibiliti().getAttribute("style")
				.equals("display: block;") &&  topMenuPage.getWomanDropdownVisibiliti()
						.getAttribute("style").equals("display: block;"),
				"Error: Dropdown menu - Dresses and Women aren't visible!");
	
	}

//	Test #3:  Phone number visibility check on resize
//Maksimizujte prozor
//Proverite da je element za broj telefona vidljiv
//Smanjite dimenziju pretrazivaca na velicinu 767 x 700
//Proverite element za broj telefona nije vidljiv
//Promenite dimenziju pretrazivaca na 768 x 700
//Proverite da je broj telefona vidljiv
//Maksimizujte prozor
//Provera preko soft asserta

	@Test(priority = 300)
	public void phoneNumberVisibilityCheckOnResize() throws InterruptedException {
		driver.manage().window().maximize();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(headerPage.getVisibilityOfPhoneNumber(),
				"Error: Phone number should be visible!");
		driver.manage().window().setSize(new Dimension(767, 700));
		softAssert.assertFalse(headerPage.getVisibilityOfPhoneNumber(),
				"Error: Phone number should not be visible on 767-700!");
		driver.manage().window().setSize(new Dimension(768, 700));
		softAssert.assertTrue(headerPage.getVisibilityOfPhoneNumber(),
				"Error: Phone number should be visible!");
		driver.manage().window().maximize();
	}
//	
//	Test #4:  Header links check
//	Kliknite na contact us link
//	Verifikujte da je naslov stranice Contact us - My Store
//	Kliknite na sign in link
//	Verifikujte da je naslov stranice Login - My Store
//	Provera preko soft asserta

	@Test(priority = 400)
	public void headerLinksCheck() {
		SoftAssert softAssert = new SoftAssert();

		headerPage.getContactUsLink().click();
		softAssert.assertEquals(headerPage.getTitle(), "Contact us - My Store",
				"Error: title Contact us - My Store isn't on page!");
		headerPage.getSingInLink().click();
		softAssert.assertEquals(headerPage.getTitle(), "Login - My Store", 
				"Error: Login - My Store isn't on page!");
	}
}
