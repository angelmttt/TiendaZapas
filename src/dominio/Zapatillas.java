package dominio;

import java.io.Serializable;

/**
 * La clase Zapatilla representa un objeto de tipo zapato en una tienda.
 * Esta clase implementa la interfaz Serializable para que las instancias puedan ser convertidas a bytes y viceversa.
 */

public class Zapatillas implements Serializable {
    //Atributos
    private String nombre;
    private double precio;
    private String modelo;
    private String talla;
    private String color;

    // Constructor con parámetros que inicializa una Zapatilla con un nombre precio modelo talla y color 
    public Zapatillas(String nombre, double precio, String modelo, String talla, String color) {
        this.nombre = nombre;
        this.precio = precio;
        this.modelo = modelo;
        this.talla = talla;
        this.color = color;
    }

    // Getters y setters

    /**
     * Actualiza el modelo, color, talla y precio de la Zapatilla.
     *
     * @param modelo  Nuevo modelo de la zapatilla.
     * @param color Nuevo color de la zapatilla.
     * @param talla  Nuevo talla de la zapatilla.
     * @param precio Nuevo precio de la zapatilla.
     */
    
    public void actualizar(String modelo, String color, String talla, double precio) {
        setModelo(modelo);
        setColor(color);
        setTalla(talla);
        setPrecio(precio);
    }

    // Métodos generados automáticamente por el IDE

     /**
     * Obtiene el nombre de la zapatilla.
     *
     * @return El nombre de la zapatilla.
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * Obtiene el precio de la zapatilla.
     *
     * @return El precio de la zapatilla.
     */

    public double getPrecio() {
        return precio;
    }
    
    /**
     * Establece el modelo de la zapatilla.
     *
     * @param modelo Nuevo modelo de la zapatilla.
     */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Establece el color de la zapatilla.
     *
     * @param color Nuevo color de la zapatilla.
     */

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Establece talla talla de la zapatilla.
     *
     * @param talla Nuevo talla de la zapatilla.
     */

    public void setTalla(String talla) {
        this.talla = talla;
    }
    /**
     * Establece el precio de la zapatilla.
     *
     * @param precio Nuevo precio de la zapatilla.
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Compara si dos Zapatillas son iguales.
     *
     * @param obj Objeto a comparar.
     * @return true si las Zapatillas son iguales, false en caso contrario.
     */

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Zapatillas zapatilla = (Zapatillas) obj;
        return nombre.equals(zapatilla.nombre);
    }

    /**
     * Representa la información de la Zapatilla en forma de cadena.
     *
     * @return Cadena que representa la información de la Zapatilla.
     */
    
    public String toString() {
        return "Marca: " + nombre + " Modelo: " + modelo + " Color: " + color + " Talla: " + talla + " Precio: " + precio;
    }
}
