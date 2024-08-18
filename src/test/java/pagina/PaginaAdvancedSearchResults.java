package pagina;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaAdvancedSearchResults extends BaseTest {
    private WebDriverWait wait;
    
	//Elementos Web
	// Localizar los nombres de los productos
	private By nombresProductosBy = By.cssSelector(".product-name > a");
    private By preciosProductosBy = By.cssSelector(".price");
		
    //Constructor
  	public PaginaAdvancedSearchResults(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
    public List<String> obtenerNombresYPrecios() {
        List<String> nombresYPrecios = new ArrayList<>();
        List<WebElement> nombresProductos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nombresProductosBy));
        List<WebElement> preciosProductos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(preciosProductosBy));
        
        for (int i = 0; i < nombresProductos.size(); i++) {
            String nombre = nombresProductos.get(i).getText();
            String precio = preciosProductos.get(i).getText();
            nombresYPrecios.add(nombre + " - " + precio);
        }
        return nombresYPrecios;
    }

}
