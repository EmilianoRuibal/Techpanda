package pruebas;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilidades.GeneradorDatos;
import base.BaseTest;
import pagina.PaginaLogin;
import pagina.PaginaMyAccount;
import pagina.PaginaMyOrders;
import pagina.PaginaOrderNumber;
import pagina.PaginaPrincipal;

public class CP007_GuardarPDFPedidoRealizado extends BaseTest {
	private Map<String, String> datos;
	
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
	public void descargarComprobanteCompraPDF() {
		PaginaMyAccount myAccountPage = new PaginaMyAccount(driver);
		myAccountPage.listaMenuMyAccount("history");
		
		PaginaMyOrders myOrdersPage = new PaginaMyOrders(driver);
		Assert.assertTrue(myOrdersPage.verificarNumeroPedido(datos.get("Numero de Orden")));
		Assert.assertTrue(myOrdersPage.verificarEstatusPedido());
		myOrdersPage.verPedido();
		
		PaginaOrderNumber orderNumberPage = new PaginaOrderNumber(driver);
		orderNumberPage.clickImprimirPedido();
	}
	

}
