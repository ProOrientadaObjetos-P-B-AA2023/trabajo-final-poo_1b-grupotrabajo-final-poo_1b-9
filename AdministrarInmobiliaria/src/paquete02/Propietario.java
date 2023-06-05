package paquete02;
import java.io.*;

public class Propietario {
    private String nombres;
    private String apellidos;
    private String identificacion;

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void guardarPropietario() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("propietarios.dat", true))) {
            dos.writeUTF(nombres);
            dos.writeUTF(apellidos);
            dos.writeUTF(identificacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Propietario obtenerPropietario(String identificacion) {
        Propietario propietario = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("propietarios.dat"))) {
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                String apellido = dis.readUTF();
                String id = dis.readUTF();
                if (id.equals(identificacion)) {
                    propietario = new Propietario(nombre, apellido, id);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propietario;
    }
}
