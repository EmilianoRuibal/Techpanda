package pagina;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaMobile extends BaseTest{
    private WebDriverWait wait;
    
    //Elementos Web
    private By pageTitleMessageBy = By.cssSelector("[class='page-title category-title']");
	private By sortByListBy = By.cssSelector("[class='category-products']>div>div>div>select");
    private By productNameBy = By.cssSelector("h2[class='product-name']");
    private By productsListBy = By.cssSelector("[class='products-grid products-grid--max-4-col first last odd']");
    private By compareButtonBy = By.cssSelector("[title='Compare']");
	
	//Constructor
	public PaginaMobile(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos	
	public boolean verificarTituloPagina(String tituloEsperado) {
		WebElement pageTitleMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleMessageBy));
		return pageTitleMessage.getText().contains(tituloEsperado);
	}
	
	public PaginaMobile seleccionarProducto(String producto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productsListBy));
		By product = By.cssSelector("[title='"+ producto +"']");
        WebElement productoSeleccionado = wait.until(ExpectedConditions.elementToBeClickable(product));
        productoSeleccionado.click();		
		return this;
	}
	
	public PaginaMobile ordenarPor(String sortBy) {
		WebElement sortByList = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByListBy));
        Select dropdown = new Select(sortByList);
        dropdown.selectByVisibleText(sortBy);
		return this;
	}
	
	public boolean ordenadoPorNombre() {
        List<WebElement> productos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNameBy));
        List<String> nombresProductos = new ArrayList<>();
        for (WebElement element : productos) {
            nombresProductos.add(element.getText());
        }
        List<String> nombresOrdenados = new ArrayList<>(nombresProductos);
        Collections.sort(nombresOrdenados);
        return nombresProductos.equals(nombresOrdenados);
    }
	
	public String precioProductos(int producto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productsListBy));
		By product = By.cssSelector("span[id='product-price-"+ producto +"']");
        WebElement priceProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
        String precio = priceProduct.getText();
        return precio;
	}
	
	public PaginaMobile addToCart(int producto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productsListBy));
		By product = By.cssSelector("button.btn-cart[onclick*='/product/"+ producto +"/']");
		WebElement productMobile = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		productMobile.click();
		return this;
	}
	
	public PaginaMobile compararProductos(String producto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productsListBy));
		By product = By.cssSelector("button.btn-cart[onclick*='/product/"+ producto +"/']+ul>li+li>a");
        WebElement productoAComparar = wait.until(ExpectedConditions.elementToBeClickable(product));
        productoAComparar.click();		
		return this;
	}
	
	public PaginaMobile clickComparar() {
        WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(compareButtonBy));
        compareButton.click();
		return this;
	}

}