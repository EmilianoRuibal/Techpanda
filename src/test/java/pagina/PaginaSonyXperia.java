package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaSonyXperia extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
	private By advancedSearchLinkBy = By.cssSelector("[title='Advanced Search']");
	private By sonyXperiaPriceMessageBy = By.cssSelector("[class='price']");
	private By reviewsButtonBy = By.cssSelector("[class='toggle-tabs']>li+li");
	private By firstComentMessageBy = By.cssSelector("[class='tab-content']>div>div+dl>dt+dd");
	
	//Constructor
	public PaginaSonyXperia(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaSonyXperia irAdvancedSearch() {
		WebElement advancedSearchLink = wait.until(ExpectedConditions.elementToBeClickable(advancedSearchLinkBy)); 
		advancedSearchLink.click();
		return this;
	}
	
	public String precioSonyXperia() {
		WebElement sonyXperiaPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(sonyXperiaPriceMessageBy));
		String price = sonyXperiaPrice.getText();
		return price;
	}
	
	public PaginaSonyXperia irAReviews() {
		WebElement reviewsButton = wait.until(ExpectedConditions.elementToBeClickable(reviewsButtonBy));
		reviewsButton.click();
		return this;
	}
	
	public boolean primerComentarioResena() {
		String comentEsperado = "Este producto es bueno, se puede utilizar durante mucho tiempo.";
		WebElement firstComentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(firstComentMessageBy));
		return firstComentMessage.getText().contains(comentEsperado);
	}
  
	
}
