package pruebas;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaCart;
import pagina.PaginaMobile;
import pagina.PaginaPrincipal;

public class CP003_AgregarGranCantidadDeProductosAlCarrito extends BaseTest {
	@Test(priority=1)
	public void verificarCostoDeProducto() {
		setUrlKey("url1");
        setup();
        
        PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenu("Mobile");
		
		PaginaMobile mobilePage = new PaginaMobile(driver);
		// 1.Sony Xperia 2.Iphone 3.Samsung Galaxy
		mobilePage.addToCart(1);
		
		PaginaCart cartPage = new PaginaCart(driver);
		cartPage.cambiarCantidadProducto("1000")
				.actualizarCantidadProducto();
		Assert.assertTrue(cartPage.mensajeError());
		
		cartPage.vaciarCarrito();
		Assert.assertTrue(cartPage.mensajeCarritoVacio());
				
	}
        
}
