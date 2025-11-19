// Archivo: DiscoSD.java
package simulador.modelo;

/**
 * Simula el Disco SD (Tarjeta SD) como un conjunto de bloques.
 */
public class DiscoSD implements java.io.Serializable {
    
    private Bloque[] bloques;
    private int numBloques;

    public DiscoSD(int numBloques) {
        this.numBloques = numBloques;
        // Usamos un array simple, NO un ArrayList
        this.bloques = new Bloque[numBloques];
        for (int i = 0; i < numBloques; i++) {
            bloques[i] = new Bloque(i);
        }
    }

    /**
     * Busca el primer bloque libre en el disco.
     * @return el ID del bloque libre, o -1 si el disco está lleno.
     */
    public int encontrarBloqueLibre() {
        for (int i = 0; i < numBloques; i++) {
            if (!bloques[i].isOcupado()) {
                return i;
            }
        }
        return -1; // -1 indica que el disco está lleno
    }
    
    /**
     * Libera una cadena de bloques empezando por el bloque inicial.
     * Sigue la lista enlazada de bloques y los libera uno por uno.
     */
    public void liberarCadena(int bloqueInicial) {
        int actualId = bloqueInicial;
        while (actualId != -1) {
            Bloque b = getBloque(actualId);
            if (b == null) break; // Seguridad
            
            int siguienteId = b.getSiguienteBloque();
            b.liberar();
            actualId = siguienteId;
        }
    }

    // --- Getters ---
    
    public Bloque getBloque(int id) {
        if (id < 0 || id >= numBloques) {
            return null;
        }
        return bloques[id];
    }
    
    public int getNumBloques() {
        return numBloques;
    }
    
    public Bloque[] getBloques() {
        return bloques;
    }
}