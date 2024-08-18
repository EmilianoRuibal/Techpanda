package Utilidades;

public class Esperar {

    // Método que acepta una duración en milisegundos y realiza la espera
    public static void esperar(int duracionEnMilisegundos) {
        try {
            Thread.sleep(duracionEnMilisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
