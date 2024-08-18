package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.GeneradorDatos;
import base.BaseTest;

public class PaginaCheckoutSuccess extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By orderConfirmationMessageBy = By.cssSelector("[class=' checkout-onepage-success']>div>div>div+header+div>div>div>div>h1");
	private By orderNumberMessageBy = By.cssSelector("[href*='view/order_id/']");
	
	//Constructor
	public PaginaCheckoutSuccess(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public boolean confirmarCompraRealizada() {
		String mensaje = "YOUR ORDER HAS BEEN RECEIVED.";
		WebElement orderConfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessageBy));
		return mensaje.equals(orderConfirmationMessage.getText());
	}
	
	public PaginaCheckoutSuccess confirmarNumeroCompra() {
		WebElement orderNumberMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberMessageBy));
	    String numeroOrden = orderNumberMessage.getText();
	    GeneradorDatos.agregarDato("Numero de Orden", numeroOrden);
	    return this;
	}
	
	
	
}
