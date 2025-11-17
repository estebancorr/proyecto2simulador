// Archivo: Archivo.java
package simulador.modelo;

/**
 * Representa un Archivo.
 * Hereda de NodoSistema y añade propiedades de archivo.
 */
public class Archivo extends NodoSistema {
    
    private int tamanoEnBloques;
    private int bloqueInicial; // Dirección del primer bloque

    public Archivo(String nombre, int tamanoEnBloques) {
        super(nombre);
        this.tamanoEnBloques = tamanoEnBloques;
        this.bloqueInicial = -1; // Aún no asignado en el disco
    }

    // --- Getters y Setters ---
    
    public int getTamanoEnBloques() { return tamanoEnBloques; }
    public void setTamanoEnBloques(int tamanoEnBloques) { this.tamanoEnBloques = tamanoEnBloques; }
    public int getBloqueInicial() { return bloqueInicial; }
    public void setBloqueInicial(int bloqueInicial) { this.bloqueInicial = bloqueInicial; }
}