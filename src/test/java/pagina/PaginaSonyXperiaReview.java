package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaSonyXperiaReview extends BaseTest{
	private WebDriverWait wait;
	
	//Elementos Web
	private By qualityRadioBy = By.cssSelector("[class='first last odd']");
	private By comentFieldBy = By.id("review_field");
	private By summaryReviewFieldBy = By.id("summary_field");
	private By nicknameFieldBy = By.id("nickname_field");
	private By submitReviewButtonBy = By.cssSelector("[title='Submit Review']");
		
	//Constructor
  	public PaginaSonyXperiaReview(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
	public PaginaSonyXperiaReview calificarProducto(int puntuacion) {
		wait.until(ExpectedConditions.elementToBeClickable(qualityRadioBy));
		By qualityRadio = By.cssSelector("[for='Quality 1_" + puntuacion + "']");
		WebElement quality = wait.until(ExpectedConditions.elementToBeClickable(qualityRadio));
		quality.click();
		return this;
	}
	
	public PaginaSonyXperiaReview dejarComentario(String comentario) {
		WebElement comentField = wait.until(ExpectedConditions.elementToBeClickable(comentFieldBy));
		comentField.sendKeys(comentario);
		return this;
	}
	
	public PaginaSonyXperiaReview resumenResena(String resumenResena) {
		WebElement summaryReviewField = wait.until(ExpectedConditions.elementToBeClickable(summaryReviewFieldBy));
		summaryReviewField.sendKeys(resumenResena);
		return this;
	}
	
	public PaginaSonyXperiaReview nickname(String nickname) {
		WebElement nicknameField = wait.until(ExpectedConditions.elementToBeClickable(nicknameFieldBy));
		nicknameField.sendKeys(nickname);
		return this;
	}
	
	public PaginaSonyXperiaReview enviarResena() {
		WebElement submitReviewButton = wait.until(ExpectedConditions.elementToBeClickable(submitReviewButtonBy));
		submitReviewButton.click();;
		return this;
	}
	
	
}
