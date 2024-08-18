package pruebas;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaMobile;
import pagina.PaginaPrincipal;
import pagina.PaginaSonyXperia;

public class CP002_VerificarCostoDeProducto extends BaseTest {
	
	@Test(priority=1)
	public void verificarCostoDeProducto() {
		setUrlKey("url1");
        setup();
        
        PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenu("Mobile");
		
		PaginaMobile mobilePage = new PaginaMobile(driver);
		// 1.Sony Xperia 2.Iphone 3.Samsung Galaxy
		String precioListSonyXperia = mobilePage.precioProductos(1);
		mobilePage.seleccionarProducto("Sony Xperia");
		
		PaginaSonyXperia productSonyXperia = new PaginaSonyXperia(driver);
		String precioProductSonyXperia = productSonyXperia.precioSonyXperia();
		
		Assert.assertEquals(precioListSonyXperia, precioProductSonyXperia);
	}
        
}
