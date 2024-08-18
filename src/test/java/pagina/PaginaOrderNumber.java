package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaOrderNumber extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By printOrderButtonBy = By.cssSelector("[class='link-print']");
	
	//Constructor
  	public PaginaOrderNumber(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public PaginaOrderNumber clickImprimirPedido() {
  		WebElement printOrderButton = wait.until(ExpectedConditions.elementToBeClickable(printOrderButtonBy));
  		printOrderButton.click();
  		return this;
  	}
  	
}
