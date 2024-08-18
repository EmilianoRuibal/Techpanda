package pagina;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaAdminPanel extends BaseTest{
	private WebDriverWait wait;
	
	//Elementos Web
	private By closeMessageButtonBy = By.cssSelector("[onclick='closeMessagePopup(); return false;']");
	private By menuOptionsListBy = By.id("nav");
				
	//Constructor
  	public PaginaAdminPanel(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
	public PaginaAdminPanel cerrarMensaje() {
		WebElement closeMessageButton = wait.until(ExpectedConditions.elementToBeClickable(closeMessageButtonBy));
		closeMessageButton.click();
		return this;
	}

  	public PaginaAdminPanel seleccionarOpcionMenu(String menuSalesOption) {
  		wait.until(ExpectedConditions.visibilityOfElementLocated(menuOptionsListBy)); 
        By menuOptionsList = By.xpath("//span[text()='" + menuSalesOption + "']");
        WebElement menuOptionElement = wait.until(ExpectedConditions.elementToBeClickable(menuOptionsList));
        menuOptionElement.click();
  		return this;
  	}

}
