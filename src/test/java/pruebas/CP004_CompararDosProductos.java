package pruebas;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaMobile;
import pagina.PaginaPopUp;
import pagina.PaginaPrincipal;
import Utilidades.WindowHelper;

public class CP004_CompararDosProductos extends BaseTest {
	@Test(priority=1)
	public void compararDosProductos() {
		setUrlKey("url1");
        setup();
        
        PaginaPrincipal homePage = new PaginaPrincipal(driver);
		homePage.irMenu("Mobile");
		
		PaginaMobile mobilePage = new PaginaMobile(driver);
		// 1.Sony Xperia 2.IPhone 3.Samsung Galaxy
		mobilePage.compararProductos("1")
			.compararProductos("2")
			.clickComparar();
		
        WindowHelper windowHelper = new WindowHelper(driver);
        windowHelper.switchToPopupWindow();
        
        PaginaPopUp popUpPage = new PaginaPopUp(driver);
        popUpPage.verificarTituloPagina();
		Assert.assertTrue(popUpPage.verificarProductosAComparar("Sony Xperia"));
		Assert.assertTrue(popUpPage.verificarProductosAComparar("IPhone"));

		windowHelper.closePopupAndSwitchToMainWindow();
	}

}
