package pagina;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaLoginAdminPanel extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
	private By userNameFieldBy = By.id("username");
	private By passwordFieldBy = By.id("login");
	private By loginButtonBy = By.cssSelector("[class='form-button']");
		
	//Constructor
  	public PaginaLoginAdminPanel(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
	public PaginaLoginAdminPanel ingresarUsuario(String usuario) {
		WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(userNameFieldBy));
		userNameField.sendKeys(usuario);
		return this;
	}
	
	public PaginaLoginAdminPanel ingresarPassword(String password) {
		WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldBy));
		passwordField.sendKeys(password);
		return this;
	}
	
	public PaginaLoginAdminPanel clickLogin() {
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
		loginButton.click();
		return this;
	}

}
