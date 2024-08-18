package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaAdvancedSearch extends BaseTest {
    private WebDriverWait wait;
    
	//Elementos Web
	private By priceFromFieldBy = By.id("price");
	private By priceToFieldBy = By.id("price_to");
	private By searchButtonBy = By.cssSelector("[title='Search'][class='button']");
		
	//Constructor
	public PaginaAdvancedSearch(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaAdvancedSearch precioDesde(String precioDesde) {
		WebElement priceFromField = wait.until(ExpectedConditions.visibilityOfElementLocated(priceFromFieldBy));
		priceFromField.sendKeys(precioDesde);
		return this;
	}
	
	public PaginaAdvancedSearch precioHasta(String precioHasta) {
		WebElement priceToField = wait.until(ExpectedConditions.visibilityOfElementLocated(priceToFieldBy));
		priceToField.sendKeys(precioHasta);
		return this;
	}
	
	public PaginaAdvancedSearch clickBuscar() {
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonBy));
		searchButton.click();
		return this;
	}
		
}
