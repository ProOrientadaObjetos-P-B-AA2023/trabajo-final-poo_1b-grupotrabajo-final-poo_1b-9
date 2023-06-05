package paquete05;
import java.io.*;

public class Constructora {
    private String nombre;
    private int idEmpresa;

    public Constructora(String nombre, int idEmpresa) {
        this.nombre = nombre;
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void guardarConstructora() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("constructoras.dat", true))) {
            dos.writeUTF(nombre);
            dos.writeInt(idEmpresa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Constructora obtenerConstructora(int idEmpresa) {
        Constructora constructora = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("constructoras.dat"))) {
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                int id = dis.readInt();
                if (id == idEmpresa) {
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
