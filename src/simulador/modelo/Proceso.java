package simulador.modelo;

public class Proceso {
    private String nombre;
    private Archivo archivoQueUsa;
    private int tiempoRestante;

    public Proceso(String nombre, Archivo archivoQueUsa, int tiempo) {
        this.nombre = nombre;
        this.archivoQueUsa = archivoQueUsa;
        this.tiempoRestante = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public Archivo getArchivoQueUsa() {
        return archivoQueUsa;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    /** Simula un "tick" del CPU */
    public void ejecutarCiclo() {
        if (this.tiempoRestante > 0) {
            this.tiempoRestante--;
        }
    }

    public boolean haTerminado() {
        return this.tiempoRestante == 0;
    }

    @Override
    public String toString() {
        return this.nombre + " (usa " + archivoQueUsa.getNombre() + ", quedan " + tiempoRestante + "s)";
    }
}