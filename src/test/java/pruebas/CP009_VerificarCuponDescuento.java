package pruebas;

import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilidades.GeneradorDatos;
import base.BaseTest;
import pagina.PaginaCart;
import pagina.PaginaLogin;
import pagina.PaginaMobile;
import pagina.PaginaPrincipal;

public class CP009_VerificarCuponDescuento extends BaseTest {
	private Map<String, String> datos;
	String cupon = "GURU50";
		
	@BeforeClass
    public void leerDatosAntesDeLasPruebas() {
        // Leer los datos guardados en el archivo datos_login
        datos = GeneradorDatos.leerDatosGuardados();
    }
	
	@Test(priority=1)
	public void iniciarSesion() {
		setUrlKey("url1");
        setup();
		
		PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenuAccount()
				.listaMenuAccount("My Account");
		
		PaginaLogin loginPage = new PaginaLogin(driver);
		loginPage.ingresarEmailLogin(datos.get("Email"))
				.ingresarPasswordLogin(datos.get("Password"))
				.clickLoginButton();	
	}
	
	@Test(priority=2)
	public void aplicarCuponDescuento() {
		PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenu("Mobile");
		
		// 1.Sony Xperia 2.Iphone 3.Samsung Galaxy
		PaginaMobile mobilePage = new PaginaMobile(driver);
		mobilePage.addToCart(2);
		
		PaginaCart cartPage = new PaginaCart(driver);
		cartPage.ingresarCodigoDescuento(cupon)
				.aplicarCodigoDescuento();
		
		Assert.assertTrue(cartPage.confirmarPrecioDescuento());
	}

}
