package Utilidades;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ControlVentanas {

    // Método para cambiar a la nueva pestaña o ventana
    public static void cambiarANuevaVentana(WebDriver driver) {
        // Obtener el identificador de la ventana actual
        String ventanaOriginal = driver.getWindowHandle();
        Set<String> todasLasVentanas = driver.getWindowHandles();

        // Buscar la nueva ventana y cambiar a ella
        for (String ventana : todasLasVentanas) {
            if (!ventana.equals(ventanaOriginal)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }

    // Método para cerrar la pestaña o ventana actual y volver a la original
    public static void cerrarVentanaActual(WebDriver driver) {
        // Obtener el identificador de la ventana original
        String ventanaOriginal = driver.getWindowHandle();
        driver.close(); // Cierra la ventana o pestaña actual

        // Cambiar de nuevo a la ventana original
        for (String ventana : driver.getWindowHandles()) {
            if (ventana.equals(ventanaOriginal)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }

    // Método para cambiar a la pestaña o ventana original
    public static void cambiarAVentanaOriginal(WebDriver driver) {
        // Obtener el identificador de la ventana original (la primera)
        String ventanaOriginal = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(ventanaOriginal);
    }
}

