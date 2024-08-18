package pruebas;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilidades.GeneradorDatos;
import base.BaseTest;
import pagina.PaginaCreateAccount;
import pagina.PaginaLogin;
import pagina.PaginaMyAccount;
import pagina.PaginaMyWishlist;
import pagina.PaginaPrincipal;
import pagina.PaginaShareYourWishlist;
import pagina.PaginaTV;

public class CP005_CrearCuentaYCompartirWishlist extends BaseTest {
	private Map<String, String> datos;
	// Generar un comentario aleatorio
    String message = GeneradorDatos.generarComentario();
    String email = GeneradorDatos.generarEmail();
    
    @BeforeClass
    public void generarDatosAntesDeLasPruebas() {
        // Generar los datos aleatorios y guardarlos en un archivo
    	GeneradorDatos.generarDatosAleatorios();
        // Leer los datos guardados en el archivo
        datos = GeneradorDatos.leerDatosGuardados();
    }

	
	@Test(priority=1)
	public void crearCuenta() {
		setUrlKey("url1");
        setup();
        
		PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenuAccount()
				.listaMenuAccount("My Account");
		
		PaginaLogin loginPage = new PaginaLogin(driver);
		loginPage.irACrearCuenta();
		
		PaginaCreateAccount createAccount = new PaginaCreateAccount(driver);
		createAccount.completarFormularioNombre(datos.get("Nombre"))
					.completarFormularioApellido(datos.get("Apellido"))
					.completarFormularioEmail(datos.get("Email"))
					.completarFormularioPassword(datos.get("Password"))
					.completarFormularioConfirmarPassword(datos.get("Password"))
					.completarFormularioChekbox()
					.completarRegistro();
		
		PaginaMyAccount myAccount = new PaginaMyAccount(driver);
		Assert.assertTrue(myAccount.verificarMensajeConfirmacionRegistro());
				
	}
	
	@Test(priority=2)
	public void compartirWishlist() {
		
		PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenu("TV");
		
		PaginaTV tvPage = new PaginaTV(driver);
		// 4. LG LCD / 5. SAMSUNG LCD
		tvPage.agregarProductoWishlist("4");
		
		PaginaMyWishlist wishlistPage = new PaginaMyWishlist(driver);
		wishlistPage.compartirWishlist();
		
		PaginaShareYourWishlist shareYourWishlistPage = new PaginaShareYourWishlist(driver);
		shareYourWishlistPage.emailCompartirWishlist(email)
							.mensajeCompartirWishlist(message)
							.compartirWishlist();
		
		Assert.assertTrue(wishlistPage.verificarMensajeWishlistCompartida());
		
	}
}
