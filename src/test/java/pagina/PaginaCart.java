package pagina;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaCart extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By quantityFieldBy = By.cssSelector("[title='Qty']");
	private By updateButtonBy = By.cssSelector("[title='Update']");
	private By errorMessageBy = By.cssSelector("[class='item-msg error']");
	private By emptyCartButtonBy = By.cssSelector("[title='Empty Cart']");
	private By emptyCartMessageBy = By.cssSelector("[class='page-title']");
	private By countryListBy = By.id("country");
	private By stateListBy = By.id("region_id");
	private By zipFieldBy = By.id("postcode");
	private By estimateButtonBy = By.cssSelector("[title='Estimate']");
	private By flatRateRadioBy = By.name("estimate_method");
	private By updateTotalButtonBy = By.cssSelector("[title='Update Total']");
	private By productoPriceMessageBy = By.cssSelector("[class='cart-totals']>table>tbody>tr>td+td>span");
	private By shippingPriceMessageBy = By.cssSelector("[class='cart-totals']>table>tbody>tr+tr>td+td>span");
	private By totalPriceMessageBy = By.cssSelector("[class='cart-totals']>table>tfoot>tr>td+td>strong>span");
	private By proceedToCheckoutButtonBy = By.cssSelector("[class='method-checkout-cart-methods-onepage-bottom'] [title='Proceed to Checkout']");
	private By discountCodesFieldBy = By.id("coupon_code");
	private By applyDiscountCodeButtonBy = By.cssSelector("[onclick='discountForm.submit(false)']");
	private By discountPriceMessageBy = By.cssSelector("[class='cart-totals']>table>tbody>tr+tr>td+td>span");
	
	//Constructor
	public PaginaCart(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaCart cambiarCantidadProducto(String qty) {
		WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityFieldBy));
		quantityField.clear();
		quantityField.sendKeys(qty);
		return this;
	}
	
	public PaginaCart actualizarCantidadProducto() {
		WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(updateButtonBy)); 
		updateButton.click();
		return this;
	}
	
	public boolean mensajeError() {
		String error = "* The maximum quantity allowed for purchase is 500.";
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageBy));
		return error.equals(errorMessage.getText());
	}
	
	public PaginaCart vaciarCarrito() {
		WebElement emptyCartButton = wait.until(ExpectedConditions.elementToBeClickable(emptyCartButtonBy)); 
		emptyCartButton.click();
		return this;
	}
	
	public boolean mensajeCarritoVacio() {
		String mensaje = "SHOPPING CART IS EMPTY";
		WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessageBy));
		return mensaje.equals(emptyCartMessage.getText());
	}
	
	public PaginaCart seleccionarPais(String pais) {
		WebElement countryList = wait.until(ExpectedConditions.visibilityOfElementLocated(countryListBy));
        Select dropdown = new Select(countryList);
        dropdown.selectByVisibleText(pais);
		return this;
	}
	
	public PaginaCart seleccionarEstado(String estado) {
		WebElement stateList = wait.until(ExpectedConditions.visibilityOfElementLocated(stateListBy));
        Select dropdown = new Select(stateList);
        dropdown.selectByVisibleText(estado);
		return this;
	}
	
	public PaginaCart completarZip(String zip) {
        WebElement zipField = wait.until(ExpectedConditions.elementToBeClickable(zipFieldBy));
        zipField.sendKeys(zip);
		return this;
	}
	
	public PaginaCart estimarCostoEnvio() {
		WebElement estimateButton = wait.until(ExpectedConditions.elementToBeClickable(estimateButtonBy)); 
		estimateButton.click();
		return this;
	}
	
	public PaginaCart seleccionarCostoEnvio() {
		WebElement flatRateRadio = wait.until(ExpectedConditions.elementToBeClickable(flatRateRadioBy)); 
		flatRateRadio.click();
		return this;
	}
	
	public PaginaCart actualizarPrecioTotal() {
		WebElement updateTotalButton = wait.until(ExpectedConditions.elementToBeClickable(updateTotalButtonBy)); 
		updateTotalButton.click();
		return this;
	}
	
	public boolean confirmarCostoEnvio() {
		String precio = "$5.00";
		WebElement shippingPriceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingPriceMessageBy));
		return precio.equals(shippingPriceMessage.getText());
	}
		
	public boolean confirmarPrecioTotal() {
		WebElement productoPriceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(productoPriceMessageBy));
		double productoPrice = Double.parseDouble(productoPriceMessage.getText().replace("$", "").replace(",", ""));
		WebElement shippingPriceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingPriceMessageBy));
		double shippingPrice = Double.parseDouble(shippingPriceMessage.getText().replace("$", "").replace(",", ""));
        
		// Calcular el precio total
	    double totalCalculated = productoPrice + shippingPrice;
	    // Configurar el formato de moneda con Locale.US
	    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
	    symbols.setGroupingSeparator(','); // Separador de miles
	    symbols.setDecimalSeparator('.');  // Separador decimal
	    DecimalFormat formatoMoneda = new DecimalFormat("$#,##0.00", symbols);
	    String totalPriceFormatted = formatoMoneda.format(totalCalculated);
		
		WebElement totalPriceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceMessageBy));
		return totalPriceFormatted.equals(totalPriceMessage.getText());
	}
	
	public PaginaCart irACheckout() {
		WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButtonBy)); 
		proceedToCheckoutButton.click();
		return this;
	}
	
	public boolean confirmarPrecioTotalDiezProductos() {
		String totalPrice = "$6,150.00";
		WebElement totalPriceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceMessageBy));
		return totalPrice.equals(totalPriceMessage.getText());
	}
	
	public PaginaCart ingresarCodigoDescuento(String codigoDescuento) {
		WebElement discountCodesField = wait.until(ExpectedConditions.visibilityOfElementLocated(discountCodesFieldBy));
		discountCodesField.clear();
		discountCodesField.sendKeys(codigoDescuento);
		return this;
	}
	
	public PaginaCart aplicarCodigoDescuento() {
		WebElement applyDiscountCodeButton = wait.until(ExpectedConditions.elementToBeClickable(applyDiscountCodeButtonBy));
		applyDiscountCodeButton.click();
		return this;
	}
	
	public boolean confirmarPrecioDescuento() {
		String totalPrice = "-$25.00";
		WebElement discountPriceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(discountPriceMessageBy));
		return totalPrice.equals(discountPriceMessage.getText());
	}
}
