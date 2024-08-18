package pagina;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaPendingReviews extends BaseTest{
	private WebDriverWait wait;
	//Elementos Web
	private By IDAscButtonBy = By.cssSelector("a[title='asc'][name='review_id']");
	private By IDDescButtonBy = By.cssSelector("a[title='desc'][name='review_id']");
	private By editButtonBy = By.xpath("//tr[1]//td[10]//a[1]");
		
	//Constructor
  	public PaginaPendingReviews(WebDriver driver) {
  		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	}
	
	//Acciones sobre los elementos
	public PaginaPendingReviews ordenarPorID() {
		WebElement IDButton = wait.until(ExpectedConditions.elementToBeClickable(IDAscButtonBy));
		IDButton.click();
		IDButton = wait.until(ExpectedConditions.elementToBeClickable(IDDescButtonBy));
		IDButton.click();
		return this;
	}
	
	public PaginaPendingReviews editarUltimoComentario() {
		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(editButtonBy));
		editButton.click();
		return this;
	}
	
}
