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
    try (DataInputStream dis = new DataInputStream(new FileInputStream("constructoras.dat"))) {
        while (dis.available() > 0) {
            String nombre = dis.readUTF();
            String id = dis.readUTF();
            if (id.equals(idEmpresa)) {
                constructora = new Constructora(nombre, id);
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return constructora;
}
}