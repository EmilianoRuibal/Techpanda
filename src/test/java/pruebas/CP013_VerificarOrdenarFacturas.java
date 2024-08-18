package pruebas;

import java.text.ParseException;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaAdminPanel;
import pagina.PaginaLoginAdminPanel;
import pagina.PaginaSalesInvoices;

public class CP013_VerificarOrdenarFacturas extends BaseTest {
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
	public void ordenarPedidosPorFecha() throws ParseException {
		PaginaAdminPanel adminPanelPage = new PaginaAdminPanel(driver);
		adminPanelPage.cerrarMensaje()
					.seleccionarOpcionMenu("Sales")
					.seleccionarOpcionMenu("Invoices");
		
		PaginaSalesInvoices salesInvoicesPage = new PaginaSalesInvoices(driver);

		salesInvoicesPage.ordenarFacturasPorFecha();
		Assert.assertTrue(salesInvoicesPage.fechasOrdenadasAscendente());
		
		salesInvoicesPage.ordenarFacturasPorFecha();		
		Assert.assertTrue(salesInvoicesPage.fechasOrdenadasDescendente());
		
	}

}
