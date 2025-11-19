package simulador.estructuras;

public class MiCola<T> implements java.io.Serializable {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamano;

    public MiCola() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }

    // --- ESTE ES EL MÉTODO QUE TE FALTA O ESTÁ MAL ESCRITO ---
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo); // Asegúrate de que Nodo tenga setSiguiente
            fin = nuevoNodo;
        }
        tamano++;
    }
    // ---------------------------------------------------------

    public T desencolar() {
        if (estaVacia()) return null;
        T dato = inicio.getDato();
        inicio = inicio.getSiguiente();
        if (inicio == null) {
            fin = null;
        }
        tamano--;
        return dato;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }
    
    // Método extra si lo necesitas
    public int getTamano() { return tamano; }
}