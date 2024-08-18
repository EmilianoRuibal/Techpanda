package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaPopUp extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By pageTitleMessageBy = By.cssSelector("[class='page-title title-buttons']>h1");
    private By compareProductsListBy = By.cssSelector("[class='product-shop-row top first odd']");
    
    
    //Constructor
  	public PaginaPopUp(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public boolean verificarTituloPagina() {
  		String pageTitle = "COMPARE PRODUCTS"; 
		WebElement pageTitleMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleMessageBy));
        return pageTitle.equals(pageTitleMessage.getText());
	}
  	
  	public boolean verificarProductosAComparar(String producto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(compareProductsListBy));
		By product1 = By.cssSelector("h2>[title='"+ producto +"']");
		WebElement compareProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(product1));
		return producto.toUpperCase().equals(compareProduct.getText());
  	}
  	
  	public String tituloPagina() {
		WebElement pageTitleMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleMessageBy));
		String pageTitle = pageTitleMessage.getText();
		return pageTitle;
	}
  	
}
