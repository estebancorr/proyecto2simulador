// Archivo: MiListaEnlazada.java
package simulador.estructuras;

/**
 * Implementación propia de una Lista Enlazada simple.
 * Prohibido usar ArrayList
 */

public class MiListaEnlazada<T> implements java.io.Serializable {
    private Nodo<T> cabeza;
    private int tamano;

    public MiListaEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     */
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamano++;
    }

    /**
     * Elimina un elemento de la lista (basado en el objeto).
     */
    public boolean eliminar(T dato) {
        if (cabeza == null) {
            return false; // Lista vacía
        }

        // Caso 1: El nodo a eliminar es la cabeza
        if (cabeza.getDato().equals(dato)) {
            cabeza = cabeza.getSiguiente();
            tamano--;
            return true;
        }

        // Caso 2: El nodo está en otra parte
        Nodo<T> previo = cabeza;
        Nodo<T> actual = cabeza.getSiguiente();
        
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                previo.setSiguiente(actual.getSiguiente());
                tamano--;
                return true;
            }
            previo = actual;
            actual = actual.getSiguiente();
        }
        return false; // No se encontró
    }

    /**
     * Obtiene un elemento por su índice.
     * Útil para conectar con el JTree.
     */
    public T get(int indice) {
        if (indice < 0 || indice >= tamano) {
            // Puedes lanzar una excepción si prefieres
            return null;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }
    
    // --- Getters ---
    
    public int getTamano() {
        return tamano;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }
}