package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaLogin extends BaseTest {
	private WebDriverWait wait;
	
	//Elementos Web
    private By createAccountButtonBy = By.cssSelector("[title='Create an Account']");
    private By emailFieldBy = By.id("email");
    private By passwordFieldBy = By.id("pass");
    private By loginButtonBy = By.id("send2");
    
    //Constructor
  	public PaginaLogin(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
  	
  	//Acciones sobre los elementos
  	public PaginaLogin irACrearCuenta() {
  		WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(createAccountButtonBy));
  		createAccountButton.click();
  		return this;
  	}
  	
  	public PaginaLogin ingresarEmailLogin(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldBy));
        emailField.sendKeys(email);
		return this;
	}
  	
  	public PaginaLogin ingresarPasswordLogin(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldBy));
        passwordField.sendKeys(password);
		return this;
	}
  	
  	public PaginaLogin clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        loginButton.click();
		return this;
	}

}
