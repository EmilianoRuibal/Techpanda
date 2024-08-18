package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaManageCustomers {
	private WebDriverWait wait;
	//Elementos Web
	private By customerButtonBy = By.xpath("//tbody/tr[1]/td[5]");
	
	//Constructor
  	public PaginaManageCustomers(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
	public PaginaManageCustomers abrirDetallesCliente() {
		WebElement customerButton = wait.until(ExpectedConditions.elementToBeClickable(customerButtonBy));
		customerButton.click();
		return this;
	}

}
