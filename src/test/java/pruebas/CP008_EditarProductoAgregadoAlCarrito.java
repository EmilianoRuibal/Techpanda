package pruebas;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilidades.GeneradorDatos;
import base.BaseTest;
import pagina.PaginaCart;
import pagina.PaginaCheckout;
import pagina.PaginaCheckoutSuccess;
import pagina.PaginaLogin;
import pagina.PaginaMyAccount;
import pagina.PaginaMyOrders;
import pagina.PaginaPrincipal;

public class CP008_EditarProductoAgregadoAlCarrito extends BaseTest {
	private Map<String, String> datos;
	String Country = "United States";
	String State = "New York";
	String Zip = "542896";
 	String Address = "ABC";
	String City = "New York"; 
	String Telephone = "12345678";
	
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
	public void actualizarPedido() {
		PaginaMyAccount myAccountPage = new PaginaMyAccount(driver);
		myAccountPage.listaMenuMyAccount("history");
		
		PaginaMyOrders myOrdersPage = new PaginaMyOrders(driver);
		myOrdersPage.reordenar();
		
		PaginaCart cartPage = new PaginaCart(driver);
		cartPage.cambiarCantidadProducto("10")
				.actualizarCantidadProducto();
		//Assert.assertTrue(cartPage.confirmarPrecioTotalDiezProductos());
		cartPage.seleccionarPais(Country)
				.seleccionarEstado(State)
				.completarZip(Zip)
				.estimarCostoEnvio()
				.seleccionarCostoEnvio()
				.actualizarPrecioTotal();

		Assert.assertTrue(cartPage.confirmarPrecioTotal());
		
		cartPage.irACheckout();
				
		PaginaCheckout checkoutPage = new PaginaCheckout(driver);
		checkoutPage.confirmarInformacionEnvio()
					.confirmarMetodoEnvio()
					//Credit Card(saved): ccsave / Check/Money order: checkmo
					.elegirMetodoPago("checkmo")
					.confirmarMetodoPago()
					.confirmarCompra();
		
		PaginaCheckoutSuccess checkoutSuccessPage = new PaginaCheckoutSuccess(driver);
		Assert.assertTrue(checkoutSuccessPage.confirmarCompraRealizada());
		
		checkoutSuccessPage.confirmarNumeroCompra();
	}

}
