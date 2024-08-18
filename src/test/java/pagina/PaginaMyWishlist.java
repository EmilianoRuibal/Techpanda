package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaMyWishlist extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By shareWishlistButtonBy = By.name("save_and_share");
	private By succesShareWishlistMessageBy = By.cssSelector("[class='success-msg']");
	private By addToCartButtonBy = By.cssSelector("[title='Add to Cart']");
	
	//Constructor
  	public PaginaMyWishlist(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public PaginaMyWishlist compartirWishlist() {
        WebElement shareWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(shareWishlistButtonBy));
        shareWishlistButton.click();
		return this;
	}
  	
  	public boolean verificarMensajeWishlistCompartida() {
  		String succesShareMessage = "Your Wishlist has been shared."; 
		WebElement succesShareWishlistMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(succesShareWishlistMessageBy));
        return succesShareMessage.equals(succesShareWishlistMessage.getText());
	}
  	
  	public PaginaMyWishlist agregarProductoAlCarrito() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonBy));
        addToCartButton.click();
		return this;
	}
}
