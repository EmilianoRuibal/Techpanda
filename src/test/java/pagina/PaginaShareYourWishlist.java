package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaShareYourWishlist extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By emailFieldBy = By.id("email_address");
	private By messageFieldBy = By.id("message");
	private By shareWishlistButtonBy = By.cssSelector("[title='Share Wishlist']");
	
	//Constructor
  	public PaginaShareYourWishlist(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public PaginaShareYourWishlist emailCompartirWishlist(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldBy));
        emailField.sendKeys(email);
		return this;
	}
  	
  	public PaginaShareYourWishlist mensajeCompartirWishlist(String message) {
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(messageFieldBy));
        messageField.sendKeys(message);
		return this;
	}
  	
  	public PaginaShareYourWishlist compartirWishlist() {
        WebElement shareWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(shareWishlistButtonBy));
        shareWishlistButton.click();
		return this;
	}

}
