package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaCheckout extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By addressFieldBy = By.id("billing:street1");
	private By cityFieldBy = By.id("billing:city");
	private By stateListBy = By.id("billing:region_id");
	private By zipFieldBy = By.id("billing:postcode");
	private By countryListBy = By.id("billing:country_id");
	private By telephoneFieldBy = By.id("billing:telephone");
	private By shippingInformationContinueButtonBy = By.cssSelector("[id='billing-buttons-container'] [title='Continue']");
	private By shippingMethodContinueButtonBy = By.cssSelector("[onclick='shippingMethod.save()']");
	private By paymentMethodOptionsBy = By.id("checkout-payment-method-load");
	private By paymentInformationContinueButtonBy = By.cssSelector("[onclick='payment.save()']");
	private By placeOrderButtonBy = By.cssSelector("[class='button btn-checkout']");
	
	//Constructor
	public PaginaCheckout(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaCheckout completarFormularioDireccion(String direccion) {
        WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(addressFieldBy));
        addressField.sendKeys(direccion);
		return this;
	}
	
	public PaginaCheckout completarFormularioCiudad(String ciudad) {
        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(cityFieldBy));
        cityField.sendKeys(ciudad);
		return this;
	}
	
	public PaginaCheckout seleccionarEstado(String estado) {
		WebElement stateList = wait.until(ExpectedConditions.visibilityOfElementLocated(stateListBy));
        Select dropdown = new Select(stateList);
        dropdown.selectByVisibleText(estado);
		return this;
	}
	
	public PaginaCheckout completarFormularioZip(String zip) {
        WebElement zipField = wait.until(ExpectedConditions.elementToBeClickable(zipFieldBy));
        zipField.sendKeys(zip);
		return this;
	}
	
	public PaginaCheckout seleccionarPais(String pais) {
		WebElement countryList = wait.until(ExpectedConditions.visibilityOfElementLocated(countryListBy));
        Select dropdown = new Select(countryList);
        dropdown.selectByVisibleText(pais);
		return this;
	}
	
	public PaginaCheckout completarFormularioTelefono(String telefono) {
        WebElement telephoneField = wait.until(ExpectedConditions.elementToBeClickable(telephoneFieldBy));
        telephoneField.sendKeys(telefono);
		return this;
	}
	
	public PaginaCheckout confirmarInformacionEnvio() {
        WebElement shippingInformationContinueButton = wait.until(ExpectedConditions.elementToBeClickable(shippingInformationContinueButtonBy));
        shippingInformationContinueButton.click();;
		return this;
	}
	
	public PaginaCheckout confirmarMetodoEnvio() {
        WebElement shippingMethodContinueButton = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueButtonBy));
        shippingMethodContinueButton.click();;
		return this;
	}
	
	public PaginaCheckout elegirMetodoPago(String metodoPago) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodOptionsBy)); 
        By paymentMethodBy = By.id("p_method_" + metodoPago);
        WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(paymentMethodBy));
        paymentMethod.click();
        return this;
	}
	
	public PaginaCheckout confirmarMetodoPago() {
        WebElement paymentInformationContinueButton = wait.until(ExpectedConditions.elementToBeClickable(paymentInformationContinueButtonBy));
        paymentInformationContinueButton.click();;
		return this;
	}
	
	public PaginaCheckout confirmarCompra() {
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButtonBy));
        placeOrderButton.click();;
		return this;
	}

}
