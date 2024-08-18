package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaCreateAccount extends BaseTest {
	private WebDriverWait wait;
    
    //Elementos Web
	private By firstNameFieldBy = By.id("firstname");
	private By lastNameFieldBy = By.id("lastname");
	private By emailFieldBy = By.id("email_address");
	private By passwordFieldBy = By.id("password");
	private By confirmPasswordFieldBy = By.id("confirmation");
	private By singUpChekboxBy = By.id("is_subscribed");
	private By registerButtonBy = By.cssSelector("button[title='Register']");
	
	//Constructor
	public PaginaCreateAccount(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaCreateAccount completarFormularioNombre(String nombre) {
        WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(firstNameFieldBy));
        firstNameField.sendKeys(nombre);
		return this;
	}
	
	public PaginaCreateAccount completarFormularioApellido(String apellido) {
        WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(lastNameFieldBy));
        lastNameField.sendKeys(apellido);
		return this;
	}
	
	public PaginaCreateAccount completarFormularioEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldBy));
        emailField.sendKeys(email);
		return this;
	}
	
	public PaginaCreateAccount completarFormularioPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldBy));
        passwordField.sendKeys(password);
		return this;
	}
	
	public PaginaCreateAccount completarFormularioConfirmarPassword(String confirmarPassword) {
        WebElement confirmPasswordField = wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordFieldBy));
        confirmPasswordField.sendKeys(confirmarPassword);
		return this;
	} 
	
	public PaginaCreateAccount completarFormularioChekbox() {
        WebElement singUpChekbox = wait.until(ExpectedConditions.elementToBeClickable(singUpChekboxBy));
        singUpChekbox.click();
		return this;
	}
	
	public PaginaCreateAccount completarRegistro() {
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerButtonBy));
        registerButton.click();
		return this;
	}
}
