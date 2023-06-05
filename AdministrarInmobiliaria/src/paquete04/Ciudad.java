package paquete04;
import java.io.*;

public class Ciudad {
    private String nombre;
    private String provincia;

    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void guardarCiudad() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ciudades.dat", true))) {
            writer.write(nombre + "," + provincia);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Ciudad obtenerCiudad(String nombreC) {
        Ciudad ciudad = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("ciudades.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos[0].equals(nombreC)) {
                    ciudad = new Ciudad(nombreC, datos[1]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ciudad;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "nombre=" + nombre + '\'' + 
                ", provincia=" + provincia + '\''+ '}';
    }
    
}
