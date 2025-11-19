package simulador.logica;

import java.io.*;
import javax.swing.JOptionPane;
import simulador.modelo.Directoria;
import simulador.modelo.DiscoSD;

public class GestorDatos {

    public static void guardarSistema(Directoria raiz, DiscoSD disco) {
        try {
            FileOutputStream archivo = new FileOutputStream("datos_sistema.bin");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            
            salida.writeObject(raiz);
            salida.writeObject(disco);
            
            salida.close();
            archivo.close();
            JOptionPane.showMessageDialog(null, "Sistema guardado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    public static Object[] cargarSistema() {
        try {
            FileInputStream archivo = new FileInputStream("datos_sistema.bin");
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            
            Directoria raiz = (Directoria) entrada.readObject();
            DiscoSD disco = (DiscoSD) entrada.readObject();
            
            entrada.close();
            archivo.close();
            JOptionPane.showMessageDialog(null, "Sistema cargado exitosamente.");
            
            return new Object[]{raiz, disco};
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos guardados o hubo un error.");
            return null;
        }
    }
}
