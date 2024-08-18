package pruebas;

import java.text.ParseException;

import org.testng.annotations.Test;
import base.BaseTest;
import pagina.PaginaAdminPanel;
import pagina.PaginaLoginAdminPanel;
import pagina.PaginaManageCustomers;

public class CP015_VerificarCamposDeshabilitados extends BaseTest {
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
					.seleccionarOpcionMenu("Customers")
					.seleccionarOpcionMenu("Manage Customers");
		
		PaginaManageCustomers manageCustomersPage = new PaginaManageCustomers(driver);
		manageCustomersPage.abrirDetallesCliente();				
	}

}
