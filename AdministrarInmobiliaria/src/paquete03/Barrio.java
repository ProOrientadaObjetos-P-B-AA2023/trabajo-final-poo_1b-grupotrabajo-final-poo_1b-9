package paquete03;
import java.io.*;

public class Barrio {
    private String nombre;
    private String referencia;

    public Barrio(String nombre, String referencia) {
        this.nombre = nombre;
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void guardarBarrio() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("barrios.dat", true))) {
            writer.write(nombre + "," + referencia);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Barrio obtenerBarrio(String nombreB) {
        Barrio barrio = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("barrios.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos[0].equals(nombreB)) {
                    barrio = new Barrio(nombreB, datos[1]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return barrio;
    }

    @Override
    public String toString() {
        return "Barrio{" + "nombre=" + nombre+
                '\''+ ", referencia=" + referencia + '\'' + '}';
    }
    
}
