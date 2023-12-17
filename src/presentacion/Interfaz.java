// Importamos las clases y paquetes necesarios
package presentacion;

import dominio.Carrito;
import dominio.Zapatillas;

import java.io.*;
import java.util.Scanner;

//La clase Interfaz es la interfaz de usuario que maneja la interacción con el programa.
public class Interfaz {
    //ATRIBUTOS
    private Scanner sc = new Scanner(System.in);
    private Carrito carrito;

    //Constructor de la clase Interfaz.
    //Lee el estado anterior del carrito desde un archivo.
    public Interfaz() {
        leer();
    }

    //Lee el estado anterior del almacén desde un archivo.
    private void leer() {
        File file = new File("carrito.dat");

        if (file.exists()) {
            try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
                carrito = (Carrito) obj.readObject();
                System.out.println("Leído");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo del carrito: " + e.getMessage());
            }
        } else {
            carrito = new Carrito();
            System.out.println("No hay archivo del carrito existente. Se ha creado un carrito nuevo.");
        }
    }

    // Unico menu del programa
    // Método principal para iniciar la interfaz.
    public void iniciar() {
        int opcion;
        do {
            System.out.println("===== Tienda de Zapatillas =====");
            System.out.println("1. Agregar Zapatilla");
            System.out.println("2. Borrar Zapatilla");
            System.out.println("3. Mostrar Carrito");
            System.out.println("4. Calcular Total del Carrito");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregarZapatilla();
                    break;
                case 2:
                    borrarZapatilla();
                    break;
                case 3:
                    mostrarCarrito();
                    break;
                case 4:
                    calcularTotalCarrito();
                    break;
                case 5:
                    grabar();
                    System.out.println("Saliendo del menú como cliente.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 5);
    }

    // Agrega una zapatiila al carrito con nombre 
    private void agregarZapatilla() {
        System.out.print("Nombre de la zapatilla: ");
        String nombre = sc.next();
        System.out.print("Modelo de la zapatilla: ");
        String modelo = sc.next();
        System.out.print("Color de la zapatilla: ");
        String color = sc.next();
        System.out.print("Talla de la zapatilla: ");
        String talla = sc.next();
        System.out.print("Precio de la zapatilla: ");
        double precio = sc.nextDouble();

        Zapatillas zapatilla = new Zapatillas(nombre, precio, modelo, talla, color);
        carrito.agregarZapatilla(zapatilla);

        System.out.println("Zapatilla añadida al carrito.");
    }

    //Boora una zapatilla del carrito
    private void borrarZapatilla() {
        System.out.print("Nombre de la zapatilla que quiere borrar: ");
        String nombre = sc.next();
        carrito.borrarZapatilla(nombre);
        System.out.println("Zapatilla retirada del carrito.");
    }

    //Muestre el carrito
    private void mostrarCarrito() {
        carrito.mostrarCarrito();
    }

    //Calcular el valor totar de las zapatillas que estan en el carrito
    private void calcularTotalCarrito() {
        carrito.calcularTotalPrecio();
    }

    //Guarda el estado actual del carrito en un archivo.
    private void grabar() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("carrito.dat"))) {
            obj.writeObject(carrito);
            System.out.println("El estado del carrito se ha grabado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al grabar el estado del carrito: " + e.getMessage());
        }
    }
}
