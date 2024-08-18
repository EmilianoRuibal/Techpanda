package pagina;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaSalesInvoices extends BaseTest{
	private WebDriverWait wait;
	
	//Elementos Web
	private By invoiceDateButtonBy = By.xpath("//span[@class='sort-title' and text()='Invoice Date']");
	private By invoiceDateListBy = By.xpath("//table[@id='sales_invoice_grid_table']/tbody/tr/td[3]");
		
	//Constructor
  	public PaginaSalesInvoices(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
  	public void ordenarFacturasPorFecha() {
        boolean isClicked = false;
        int attempts = 0;

        while (!isClicked && attempts < 3) {
            try {
            	WebElement invoiceDateButton = wait.until(ExpectedConditions.elementToBeClickable(invoiceDateButtonBy));
            	invoiceDateButton.click();
                isClicked = true;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        if (!isClicked) {
            throw new RuntimeException("No se pudo hacer clic en el encabezado de 'Invoice Date' después de varios intentos.");
        }
        // Esperar a que la lista de fechas se actualice después de ordenar
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(invoiceDateListBy)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceDateListBy));  
    }
  	   
  	// Método para obtener las fechas de la tabla como una lista de objetos Date
    public List<Date> obtenerFechas() throws ParseException {
        List<Date> fechas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy hh:mm:ss a", Locale.ENGLISH);
        // Esperar a que todos los elementos de la columna "Invoice Date" sean visibles
        List<WebElement> elementosFechas = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(invoiceDateListBy));
        // Iterar sobre cada elemento y convertir el texto a un objeto Date
        for (WebElement elemento : elementosFechas) {
            String textoFecha = elemento.getText().trim();
            Date fecha = sdf.parse(textoFecha);
            fechas.add(fecha);
        }
        return fechas;
    }
    
    // Método para verificar si las fechas están ordenadas ascendentemente
    public boolean fechasOrdenadasAscendente() throws ParseException {
        List<Date> fechas = obtenerFechas(); 
        List<Date> fechasOrdenadas = new ArrayList<>(fechas);
        Collections.sort(fechasOrdenadas); // Ordena las fechas ascendentemente
        fechas = obtenerFechas(); 
        return fechas.equals(fechasOrdenadas);
    }
    
    // Método para verificar si las fechas están ordenadas descendentemente
    public boolean fechasOrdenadasDescendente() throws ParseException {
        List<Date> fechas = obtenerFechas(); 
        List<Date> fechasOrdenadas = new ArrayList<>(fechas);
        fechasOrdenadas.sort(Collections.reverseOrder()); // Ordena las fechas descendentemente
        fechas = obtenerFechas(); 
        return fechas.equals(fechasOrdenadas);
    }
    
}
