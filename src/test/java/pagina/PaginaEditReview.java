package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaEditReview extends BaseTest{
	private WebDriverWait wait;
	
	//Elementos Web
	private By statusListBy = By.id("status_id");
	private By saveReviewButtonBy = By.id("save_button");
	
	//Constructor
  	public PaginaEditReview(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
	public PaginaEditReview seleccionarEstadoResena(String estado) {
		WebElement statusList = wait.until(ExpectedConditions.visibilityOfElementLocated(statusListBy));
		Select select = new Select(statusList);
        select.selectByVisibleText(estado);
        return this;
	}
	
	public PaginaEditReview guardarResena() {
		WebElement saveReviewButton = wait.until(ExpectedConditions.elementToBeClickable(saveReviewButtonBy));
		saveReviewButton.click();
		return this;
	}
	
}
