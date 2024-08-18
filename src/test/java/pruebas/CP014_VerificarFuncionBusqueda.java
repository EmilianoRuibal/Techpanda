package pruebas;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import pagina.PaginaAdvancedSearch;
import pagina.PaginaAdvancedSearchResults;
import pagina.PaginaPrincipal;

public class CP014_VerificarFuncionBusqueda extends BaseTest {
		
	@Test(priority=1)
	public void buscarProducto0a150() {
		setUrlKey("url1");
        setup();

        PaginaPrincipal homePage = new PaginaPrincipal(driver);
        homePage.listaQuickLinks("Advanced Search");
        
        PaginaAdvancedSearch advancedSearchPage = new PaginaAdvancedSearch(driver);
        advancedSearchPage.precioDesde("0")
        				.precioHasta("150")
        				.clickBuscar();
        
        PaginaAdvancedSearchResults resultado = new PaginaAdvancedSearchResults(driver);
        List<String> nombresYPrecios = resultado.obtenerNombresYPrecios();
        for (String producto : nombresYPrecios) {
            System.out.println(producto);
        }
	}
	
	@Test(priority=1)
	public void buscarProducto151a1000() {
		setUrlKey("url1");

        PaginaPrincipal homePage = new PaginaPrincipal(driver);
        homePage.listaQuickLinks("Advanced Search");
        
        PaginaAdvancedSearch advancedSearchPage = new PaginaAdvancedSearch(driver);
        advancedSearchPage.precioDesde("151")
        				.precioHasta("1000")
        				.clickBuscar();
        
        PaginaAdvancedSearchResults resultado = new PaginaAdvancedSearchResults(driver);
        List<String> nombresYPrecios = resultado.obtenerNombresYPrecios();
        for (String producto : nombresYPrecios) {
            System.out.println(producto);
        }
	}

}
