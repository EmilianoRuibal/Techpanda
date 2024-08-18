package pruebas;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaAdminPanel;
import pagina.PaginaLoginAdminPanel;
import pagina.PaginaSalesOrders;

public class CP011_VerificarImpresionFactura extends BaseTest {
	String usuario = "user01";
	String password = "guru99com";
	
	@Test(priority=1)
	public void iniciarSesion() {
		setUrlKey("url3");
        setup();

		PaginaLoginAdminPanel loginPage = new PaginaLoginAdminPanel(driver);
		loginPage.ingresarUsuario(usuario)
				.ingresarPassword(password)
				.clickLogin();
	}
	
	@Test(priority=2)
	public void imprimirListaPedidos() {
		PaginaAdminPanel adminPanelPage = new PaginaAdminPanel(driver);
		adminPanelPage.cerrarMensaje()
						.seleccionarOpcionMenu("Sales")
						.seleccionarOpcionMenu("Orders");
		
		PaginaSalesOrders salesOrdersPage = new PaginaSalesOrders(driver);
		salesOrdersPage.seleccionarEstatus("Canceled")
						.buscarPedidos()
						.seleccionarPrimerPedido()
						.seleccionarAccion("Print Invoices")
						.realizarAccionSeleccionada()
						.seleccionarEstatus("Complete")
						.buscarPedidos()
						.seleccionarPrimerPedido()
						.seleccionarAccion("Print Invoices")
						.realizarAccionSeleccionada();
		
		Assert.assertTrue(salesOrdersPage.verificarMensajeError());
	}

}
