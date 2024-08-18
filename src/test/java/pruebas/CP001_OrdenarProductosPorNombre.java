package pruebas;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaMobile;
import pagina.PaginaPrincipal;

public class CP001_OrdenarProductosPorNombre extends BaseTest {
	
	@Test(priority=1)
	public void ordenarProductosPorNombre() {
		setUrlKey("url1");
        setup();

		PaginaPrincipal homePage = new PaginaPrincipal(driver);
		Assert.assertTrue(homePage.verificarTituloPagina("THIS IS DEMO SITE FOR   "));
		homePage.irMenu("Mobile");
		
		PaginaMobile mobilePage = new PaginaMobile(driver);
		Assert.assertTrue(mobilePage.verificarTituloPagina("MOBILE"));
		//Name / Price / Position
		mobilePage.ordenarPor("Name");
		// Verificar que los productos están ordenados por nombre
        Assert.assertTrue(mobilePage.ordenadoPorNombre());
        
	}

}
