package Utilidades;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class WindowHelper {

    private WebDriver driver;
    private String mainWindowHandle;

    // Constructor
    public WindowHelper(WebDriver driver) {
        this.driver = driver;
        this.mainWindowHandle = driver.getWindowHandle(); // Guardar el identificador de la ventana principal
    }

    // Método para cambiar a la ventana emergente
    public void switchToPopupWindow() {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindowHandle)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Método para volver a la ventana principal
    public void switchToMainWindow() {
        driver.switchTo().window(mainWindowHandle);
    }

    // Método para cerrar la ventana actual y volver a la ventana principal
    public void closePopupAndSwitchToMainWindow() {
        driver.close(); // Cierra la ventana actual
        driver.switchTo().window(mainWindowHandle); // Vuelve a la ventana principal
    }

    // Método para obtener el identificador de la ventana principal
    public String getMainWindowHandle() {
        return mainWindowHandle;
    }
}