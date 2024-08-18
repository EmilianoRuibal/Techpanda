package Utilidades;

import com.github.javafaker.Faker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GeneradorDatos {
	private static Faker faker = new Faker();
		static String nombreCarpeta = "Datos";
		static String nombreArchivo = "datos_login.txt";
	// Método para generar datos aleatorios y guardarlos en un archivo
    public static void generarDatosAleatorios() {  
        // Generar datos aleatorios
        String nombreAl = faker.name().firstName();
        String apellidoAl = faker.name().lastName();
        String emailAl = faker.internet().emailAddress();
        String passwordAl = faker.internet().password();
        
        // Formatear los datos en un string
        String datos = "Lista de Datos Aleatorios: " +
                "\nNombre: " + nombreAl +
                "\nApellido: " + apellidoAl +
                "\nEmail: " + emailAl +
                "\nPassword: " + passwordAl;

        // Especificar el nombre del archivo y la carpeta
        String nombreCarpeta = "Datos";
        String nombreArchivo = "datos_login.txt";

        // Crear la carpeta si no existe
        File carpeta = new File(nombreCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        // Crear la ruta completa del archivo
        File archivo = new File(carpeta, nombreArchivo);

        // Guardar los datos en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, false))) { // `true` para añadir al archivo
            writer.write(datos);
            writer.newLine(); // Añadir una nueva línea después de los datos
            System.out.println("Datos guardados en " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ocurrió un error al guardar los datos: " + e.getMessage());
        }
    }

    // Método para leer los datos guardados y retornarlos en un Map
    public static Map<String, String> leerDatosGuardados() {
        
        File archivo = new File(nombreCarpeta, nombreArchivo);
        Map<String, String> datosMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(": ");
                if (partes.length == 2) {
                    datosMap.put(partes[0].trim(), partes[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer los datos: " + e.getMessage());
        }
        
        return datosMap;
    }
    
    // Método para agregar un dato al archivo existente
    public static void agregarDato(String clave, String valor) {
        File archivo = new File(nombreCarpeta, nombreArchivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) { // `true` para añadir al archivo
            writer.write(clave + ": " + valor);
            writer.newLine(); // Añadir una nueva línea después de los datos
            System.out.println("Dato guardado en " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ocurrió un error al guardar el dato: " + e.getMessage());
        }
    }
    
    //Metodos para generar datos aleatorios individuales
    // Método para generar un nombre aleatorio
    public static String generarNombre() {
        return faker.name().firstName();
    }

    // Método para generar un apellido aleatorio
    public static String generarApellido() {
        return faker.name().lastName();
    }

    // Método para generar un correo electrónico aleatorio
    public static String generarEmail() {
        return faker.internet().emailAddress();
    }

    // Método para generar una contraseña aleatoria
    public static String generarContrasena() {
        return faker.internet().password();
    }
    
    // Método para generar un comentario aleatorio
    public static String generarComentario() {
        return faker.lorem().sentence();  // Genera una oración aleatoria
    } 
}