// Archivo: Bloque.java
package simulador.modelo;

/**
 * Representa un solo bloque en el DiscoSD.
 * Sabe si está ocupado y cuál es el siguiente bloque en la cadena.
 */
public class Bloque {
    private int id;
    private boolean ocupado;
    private int siguienteBloque; // ID del siguiente bloque en la cadena
    private String propietario;  // Nombre del archivo al que pertenece

    public Bloque(int id) {
        this.id = id;
        this.ocupado = false;
        this.siguienteBloque = -1; // -1 indica fin de cadena (o bloque libre)
        this.propietario = "LIBRE";
    }

    /**
     * Asigna el bloque a un propietario y define el siguiente.
     */
    public void asignar(String propietario, int siguiente) {
        this.ocupado = true;
        this.propietario = propietario;
        this.siguienteBloque = siguiente;
    }
    
    /**
     * Libera el bloque, reseteando sus valores.
     */
    public void liberar() {
        this.ocupado = false;
        this.propietario = "LIBRE";
        this.siguienteBloque = -1;
    }
    
    // --- Getters y Setters ---

    public int getId() { return id; }
    public boolean isOcupado() { return ocupado; }
    public int getSiguienteBloque() { return siguienteBloque; }
    public String getPropietario() { return propietario; }

    public void setOcupado(boolean ocupado) { this.ocupado = ocupado; }
    public void setSiguienteBloque(int siguienteBloque) { this.siguienteBloque = siguienteBloque; }
    public void setPropietario(String propietario) { this.propietario = propietario; }
}