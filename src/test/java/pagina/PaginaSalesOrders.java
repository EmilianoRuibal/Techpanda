package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;



public class PaginaSalesOrders extends BaseTest{
	private WebDriverWait wait;
	
	//Elementos Web
	private By exportToListBy = By.id("sales_order_grid_export");
	private By exportButtonBy = By.cssSelector("onclick='sales_order_gridJsObject.doExport()'");
	private By statusListBy = By.id("sales_order_grid_filter_status");
	private By searchButtonBy = By.cssSelector("[onclick='sales_order_gridJsObject.doFilter()']");
	private By orderCheckBoxBy = By.xpath("//tbody/tr[1]//input[@type='checkbox']");
	private By actionsListBy = By.id("sales_order_grid_massaction-select");
	private By submitButtonBy = By.cssSelector("[onclick='sales_order_grid_massactionJsObject.apply()']");
	private By errorMessageBy = By.cssSelector("[class='error-msg']>ul>li>span");
	
	//Constructor
  	public PaginaSalesOrders(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
  	public PaginaSalesOrders seleccionarFormatoExportacion(String formato) {
  	    WebElement exportToList = wait.until(ExpectedConditions.visibilityOfElementLocated(exportToListBy));
  	    Select select = new Select(exportToList);
  	    select.selectByVisibleText(formato);
  	    return this;
  	}
  	
  	public PaginaSalesOrders exportarArchivo() {
  		WebElement exportButton = wait.until(ExpectedConditions.elementToBeClickable(exportButtonBy));
  		exportButton.click();
  		return this;
  	}
  	
  	public PaginaSalesOrders seleccionarEstatus(String estatus) {
  	    WebElement statusList = wait.until(ExpectedConditions.visibilityOfElementLocated(statusListBy));
  	    Select select = new Select(statusList);
  	    select.selectByVisibleText(estatus);
  	    return this;
  	}
  	
  	public PaginaSalesOrders buscarPedidos() {
  		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonBy));
  		searchButton.click();
  		return this;
  	}
  	
  	public PaginaSalesOrders seleccionarPrimerPedido() {
  		int attempts = 0;
  	    while (attempts < 3) {
  	        try {
  	            WebElement orderCheckBox = wait.until(ExpectedConditions.elementToBeClickable(orderCheckBoxBy));
  	            orderCheckBox.click();
  	            return this;  // Salir del método si el clic es exitoso
  	        } catch (StaleElementReferenceException e) {
  	            attempts++;
  	        }
  	    }
  	    throw new RuntimeException("No se pudo seleccionar el primer pedido después de varios intentos.");
  	}
  	
  	public PaginaSalesOrders seleccionarAccion(String accion) {
  	    WebElement actionsList = wait.until(ExpectedConditions.visibilityOfElementLocated(actionsListBy));
  	    Select select = new Select(actionsList);
  	    select.selectByVisibleText(accion);
  	    return this;
  	}
  	
  	public PaginaSalesOrders realizarAccionSeleccionada() {
  		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonBy));
  		submitButton.click();
  		return this;
  	}
  	
  	public boolean verificarMensajeError() {
  		String errorMessageEsperado = "There are no printable documents related to selected orders."; 
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageBy));
        return errorMessageEsperado.equals(errorMessage.getText());
	}
  	
}
