package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaPrincipal extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By pageTitleMessageBy = By.cssSelector("[class='page-title']");
    private By menuListBy = By.id("nav");
	private By accountButtonBy = By.cssSelector("[class='skip-link skip-account']");
	private By accountListBy = By.cssSelector("[class='skip-content skip-active']");
	private By quickLinsListBy = By.cssSelector("[class='footer-container']");
	
	//Constructor
	public PaginaPrincipal(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public boolean verificarTituloPagina(String tituloEsperado) {
		WebElement pageTitleMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleMessageBy));
		return pageTitleMessage.getText().contains(tituloEsperado);
	}
	
	public PaginaPrincipal irMenu(String menuItem) {
		wait.until(ExpectedConditions.elementToBeClickable(menuListBy));
		By menuList = By.xpath("//a[text()='" + menuItem + "']");
		WebElement mobileButton = wait.until(ExpectedConditions.elementToBeClickable(menuList));
		mobileButton.click();
		return this;
	}
		
	public PaginaPrincipal irMenuAccount() {
		WebElement accountButton = wait.until(ExpectedConditions.elementToBeClickable(accountButtonBy)); 
		accountButton.click();
		return this;
	}
	
	public PaginaPrincipal listaMenuAccount(String menuItem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountListBy)); 
        By menuItemBy = By.cssSelector("[title='" + menuItem + "']");
        WebElement menuItemElement = wait.until(ExpectedConditions.elementToBeClickable(menuItemBy));
        menuItemElement.click();
        return this;
	}
	
	public PaginaPrincipal listaQuickLinks(String menuItem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(quickLinsListBy)); 
        By quickLinsList = By.cssSelector("[title='" + menuItem + "']");
        WebElement menuItemElement = wait.until(ExpectedConditions.elementToBeClickable(quickLinsList));
        menuItemElement.click();
        return this;
	}
		
}
