package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaMyAccount extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By confirmRegisterMessageBy = By.cssSelector("[class='success-msg'] ul li span");
	private By myAccountListBy = By.cssSelector("[class='block block-account']");
	
	
	//Constructor
  	public PaginaMyAccount(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public boolean verificarMensajeConfirmacionRegistro() {
  		String registerMessage = "Thank you for registering with Main Website Store."; 
		WebElement confirmRegisterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmRegisterMessageBy));
        return registerMessage.equals(confirmRegisterMessage.getText());
	}	  	
  	  	
  	public PaginaMyAccount listaMenuMyAccount(String menuItem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountListBy)); 
        By myAccountList = By.cssSelector("[class='block-content'] [href*='" + menuItem + "']");
        WebElement menuItemElement = wait.until(ExpectedConditions.elementToBeClickable(myAccountList));
        menuItemElement.click();
        return this;
	}
}
