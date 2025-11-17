// Archivo: MiArbolModelo.java
package simulador.gui;

// Importa las clases de tu modelo
import simulador.modelo.Archivo;
import simulador.modelo.Directoria;

// Importa las clases de Swing para árboles
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Esta es la clase "traductora".
 * Implementa TreeModel para decirle al JTree cómo debe
 * leer nuestra estructura de Directorios y Archivos.
 */
public class MiArbolModelo implements TreeModel {

    private Directoria raiz; // Nuestro Directorio "C:"

    public MiArbolModelo(Directoria raiz) {
        this.raiz = raiz;
    }

    @Override
    public Object getRoot() {
        // El JTree pregunta: ¿Cuál es la raíz del árbol?
        return raiz;
    }

    @Override
    public Object getChild(Object parent, int index) {
        // El JTree pregunta: ¿Cuál es el hijo en la posición 'index' de este 'parent'?
        // Solo los directorios tienen hijos
        if (parent instanceof Directoria) {
            Directoria dir = (Directoria) parent;
            // Usamos el método que creamos en Directorio
            return dir.getHijo(index); 
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        // El JTree pregunta: ¿Cuántos hijos tiene este 'parent'?
        if (parent instanceof Directoria) {
            // Usamos el método que creamos en Directorio
            return ((Directoria) parent).getCantidadHijos();
        }
        return 0; // Los archivos no tienen hijos
    }

    @Override
    public boolean isLeaf(Object node) {
        // El JTree pregunta: ¿Este nodo es una "hoja" (no tiene hijos)?
        // Un nodo es una "hoja" (leaf) si es un Archivo
        return (node instanceof Archivo);
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        // El JTree pregunta: ¿Qué índice tiene este 'child' dentro de este 'parent'?
        if (parent instanceof Directoria) {
            Directoria dir = (Directoria) parent;
            // Buscamos el índice del hijo
            for (int i = 0; i < dir.getCantidadHijos(); i++) {
                if (dir.getHijo(i).equals(child)) {
                    return i;
                }
            }
        }
        return -1; // No se encontró
    }

    // --- Estos métodos no los usaremos mucho, pero deben estar ---
    
    @Override
    public void addTreeModelListener(TreeModelListener l) {
        // No es necesario para este proyecto (actualizaremos manualmente)
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        // No es necesario
    }
    
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // No es necesario (no editamos desde el árbol)
    }
}