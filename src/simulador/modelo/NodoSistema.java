// Archivo: NodoSistema.java
package simulador.modelo;

/**
 * Clase base abstracta para Archivos y Directorios.
 * Esto nos permite tratarlos de forma polimórfica en el JTree.
 */
public abstract class NodoSistema {
    protected String nombre;
    protected Directoria padre;

    public NodoSistema(String nombre) {
        this.nombre = nombre;
        this.padre = null; // El padre se asignará cuando se añada a un directorio
    }
    
    /**
     * Sobrescribimos toString() porque esto es lo que el JTree
     * mostrará por defecto en el árbol.
     */
    @Override
    public String toString() {
        return nombre;
    }

    // --- Getters y Setters ---
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Directoria getPadre() { return padre; }
    public void setPadre(Directoria padre) { this.padre = padre; }
}