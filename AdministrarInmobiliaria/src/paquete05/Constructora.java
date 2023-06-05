package paquete05;
import java.io.*;

public class Constructora {
    private String nombre;
    private String idEmpresa;

    public Constructora(String nombre, String idEmpresa) {
        this.nombre = nombre;
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void guardarConstructora() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("constructoras.dat", true))) {
            dos.writeUTF(nombre);
            dos.writeUTF(idEmpresa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public static Constructora obtenerConstructora(String idEmpresa) {
    Constructora constructora = null;
    try (BufferedReader br = new BufferedReader(new FileReader("constructoras.dat"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 2) {
                String nombreC = data[0];
                String idc = data[1];
                if (idc.equals(idEmpresa)) {
                    constructora = new Constructora(nombreC, idc);
                    break;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return constructora;
}

    
    @Override
    public String toString() {
        return "Constructora{" +
                "nombre='" + nombre + '\'' +
                ", idEmpresa='" + idEmpresa + '\'' +
                '}';
    }
}
