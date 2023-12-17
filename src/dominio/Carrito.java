// Importamos las clases y paquetes necesarios
package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Carrito representa un carrito de zapatillas y donde permite añadir las zapatillas y mas acciones
 * Implementa la interfaz Serializable para que los objetos de esta clase puedan ser grabados y guardados en un archivo.
 */

public class Carrito implements Serializable {

    // ArrayList que almacena objetos de la clase Zapatilla. 
    private ArrayList<Zapatillas> zapatillas;

    // Constructor por defecto
    public Carrito() {
        zapatillas = new ArrayList<>();
    }

    // Métodos de la clase Carrito

    //Agrega una zapatilla al ArrayList del carrito.
    public void agregarZapatilla(Zapatillas zapatilla) {
        zapatillas.add(zapatilla);
    }

    // Muestra todas las zapatillas en el carrito.
    public void mostrarCarrito() {
        for (Zapatillas zapatilla : zapatillas) {
            System.out.println(zapatilla);
        }
    }

    //Borra una zapatilla del carrito por su nombre.
    public void borrarZapatilla(String nombre) {
        zapatillas.removeIf(zapatilla -> zapatilla.getNombre().equals(nombre));
    }

    //Actualiza una zapatilla del carrito por su nombre, modelo, color, talla y precio.
    public void actualizarZapatilla(String nombre, String modelo, String color, String talla, double precio) {
        for (Zapatillas zapatilla : zapatillas) {
            if (zapatilla.getNombre().equals(nombre)) {
                zapatilla.actualizar(modelo, color, talla, precio);
                System.out.println("Zapatilla actualizada en el carrito");
                return;
            }
        }
        System.out.println("No se ha encontrado la zapatilla en el carrito, inténtalo de nuevo");
    }

    //Calcula el precio total del carrito sumando los precios de todas las zapatillas.
    public double calcularTotalPrecio() {
        double totalCarrito = zapatillas.stream().mapToDouble(Zapatillas::getPrecio).sum();
        System.out.println("El precio total del carrito es: " + totalCarrito);
        return totalCarrito;
    }
}
