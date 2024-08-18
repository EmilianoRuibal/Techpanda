package pruebas;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaAdminPanel;
import pagina.PaginaEditReview;
import pagina.PaginaLoginAdminPanel;
import pagina.PaginaMobile;
import pagina.PaginaPendingReviews;
import pagina.PaginaPrincipal;
import pagina.PaginaSonyXperia;
import pagina.PaginaSonyXperiaReview;

public class CP012_VerificarMecanismoResenaProducto extends BaseTest {
	String usuario = "user01";
	String password = "guru99com";
	String comentario = "Este producto es bueno, se puede utilizar durante mucho tiempo.";
	String resumenResena = "Bueno";
	String nickname = "Tester01";
		
	
	@Test(priority=1)
	public void resenarProducto() {
		setUrlKey("url2");
        setup();
        
        PaginaSonyXperiaReview sonyXperiaReviewPage = new PaginaSonyXperiaReview(driver);
		sonyXperiaReviewPage.calificarProducto(5)
							.dejarComentario(comentario)
							.resumenResena(resumenResena)
							.nickname(nickname)
							.enviarResena();
		driver.quit();
	}
	
	@Test(priority=2)
	public void iniciarSesion() {
		setUrlKey("url3");
        setup();

		PaginaLoginAdminPanel loginPage = new PaginaLoginAdminPanel(driver);
		loginPage.ingresarUsuario(usuario)
				.ingresarPassword(password)
				.clickLogin();	
	}
	
	@Test(priority=3)
	public void AprobarResena() {
		PaginaAdminPanel adminPanelPage = new PaginaAdminPanel(driver);
		adminPanelPage.cerrarMensaje()
					.seleccionarOpcionMenu("Catalog")
					.seleccionarOpcionMenu("Reviews and Ratings")
					.seleccionarOpcionMenu("Customer Reviews")
					.seleccionarOpcionMenu("Pending Reviews");
		
		PaginaPendingReviews pendingReviewsPage = new PaginaPendingReviews(driver);
		pendingReviewsPage.ordenarPorID()
						.editarUltimoComentario();
		
		PaginaEditReview editReviewPage = new PaginaEditReview(driver);
		editReviewPage.seleccionarEstadoResena("Approved")
					.guardarResena();
	}
	
	@Test(priority=4)
	public void verificarResena() {
		setUrlKey("url1");
        setup();
        
        PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenu("Mobile");
		
		PaginaMobile mobilePage = new PaginaMobile(driver);
		mobilePage.seleccionarProducto("Sony Xperia");
		
		PaginaSonyXperia sonyXperiaPage = new PaginaSonyXperia(driver);
		sonyXperiaPage.irAReviews();
		
		Assert.assertTrue(sonyXperiaPage.primerComentarioResena());
	}

}
