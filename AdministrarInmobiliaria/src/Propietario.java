/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

public class Propietario implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;

    public Propietario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Propietario(int id, String nombre, String apellido, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getId() {
        return id;
    }
}

