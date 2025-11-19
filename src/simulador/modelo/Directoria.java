// Archivo: Directorio.java
package simulador.modelo;

// ¡Importante! Aquí usamos la estructura que creaste en el Paso 1
import simulador.estructuras.MiListaEnlazada;

/**
 * Representa un Directorio (una carpeta).
 * Contiene una lista enlazada de hijos (Archivos o Directorios).
 */
public class Directoria extends NodoSistema implements java.io.Serializable {
    
    // Aquí usamos tu lista enlazada personalizada
    private MiListaEnlazada<NodoSistema> hijos;

    public Directoria(String nombre) {
        super(nombre);
        this.hijos = new MiListaEnlazada<>();
    }

    public void agregarHijo(NodoSistema hijo) {
        hijo.setPadre(this); // Importante: establecemos el padre
        this.hijos.agregar(hijo);
    }
    
    public boolean eliminarHijo(NodoSistema hijo) {
        return this.hijos.eliminar(hijo);
    }
    
    public NodoSistema getHijo(int i) {
        return this.hijos.get(i);
    }
    
    public int getCantidadHijos() {
        return this.hijos.getTamano();
    }

    // --- Getters ---
    
    /**
     * Devuelve la lista de hijos.
     * (Necesario para el TreeModel que haremos luego)
     */
    public MiListaEnlazada<NodoSistema> getHijos() {
        return hijos;
    }
public Archivo buscarArchivo(String nombreBuscado) {
    for (int i = 0; i < this.hijos.getTamano(); i++) {
        NodoSistema hijo = this.hijos.get(i);
        if (hijo instanceof Archivo && hijo.getNombre().equalsIgnoreCase(nombreBuscado)) {
            return (Archivo) hijo;
        } else if (hijo instanceof Directoria) {
            Archivo encontrado = ((Directoria) hijo).buscarArchivo(nombreBuscado);
            if (encontrado != null) return encontrado;
        }
    }
    return null;
}
}