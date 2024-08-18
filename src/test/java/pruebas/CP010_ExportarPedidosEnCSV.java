package pruebas;

import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaAdminPanel;
import pagina.PaginaLoginAdminPanel;
import pagina.PaginaSalesOrders;

public class CP010_ExportarPedidosEnCSV extends BaseTest {
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
	public void descargarListaPedidosFormatoCSV() {
		PaginaAdminPanel adminPanelPage = new PaginaAdminPanel(driver);
		adminPanelPage.cerrarMensaje();
		adminPanelPage.seleccionarOpcionMenu("Sales");
		adminPanelPage.seleccionarOpcionMenu("Orders");
		
		PaginaSalesOrders salesOrdersPage = new PaginaSalesOrders(driver);
		salesOrdersPage.seleccionarFormatoExportacion("CSV");
		salesOrdersPage.exportarArchivo();
	}

}
