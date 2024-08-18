package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaMyOrders extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By numberOrderMessageBy = By.cssSelector("tbody>tr>td[class='number']");
	private By statusOrderMessageBy = By.cssSelector("tbody>tr>td[class='status']");
	private By viewOrderButtonBy = By.cssSelector("tbody>tr>td[class='a-center view last']>span>a");
	private By reorderButtonBy = By.cssSelector("tbody>tr>td[class='a-center view last']>span>a+span+a");
	
	//Constructor
  	public PaginaMyOrders(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public boolean verificarNumeroPedido(String numberOrder) {
		WebElement numberOrderMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(numberOrderMessageBy));
        return numberOrder.equals(numberOrderMessage.getText());
	}
  	
  	public boolean verificarEstatusPedido() {
  		String estatus = "Pending";
		WebElement statusOrderMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(statusOrderMessageBy));
        return estatus.equals(statusOrderMessage.getText());
	}
  	
  	public PaginaMyOrders verPedido() {
  		WebElement viewOrderButton = wait.until(ExpectedConditions.elementToBeClickable(viewOrderButtonBy));
  		viewOrderButton.click();
  		return this;
  	}
  	
  	public PaginaMyOrders reordenar() {
  		WebElement reorderButton = wait.until(ExpectedConditions.elementToBeClickable(reorderButtonBy));
  		reorderButton.click();
  		return this;
  	}

}
