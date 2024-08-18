package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaTV extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By productsListBy = By.cssSelector("[class='products-grid products-grid--max-4-col first last odd']");
	
	//Constructor
  	public PaginaTV(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public PaginaTV agregarProductoWishlist(String producto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productsListBy));
		By product = By.cssSelector("a.link-wishlist[href*='/product/"+ producto +"/']");
        WebElement productTV = wait.until(ExpectedConditions.elementToBeClickable(product));
        productTV.click();		
		return this;
	}

}
