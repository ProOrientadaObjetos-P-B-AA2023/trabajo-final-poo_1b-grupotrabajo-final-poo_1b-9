package paquete06;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Departamento {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double valorAlicuotaMensual;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionDepartamento;
    private Constructora constructora;

    public Departamento(Propietario propietario, double precioMetroCuadrado, double numeroMetrosCuadrados, double valorAlicuotaMensual, Barrio barrio, Ciudad ciuda, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
        this.valorAlicuotaMensual = valorAlicuotaMensual;
        this.costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * 12);
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionDepartamento = ubicacionDepartamento;
        this.constructora = constructora;
    }

    public void guardarDepartamento() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("departamentos.dat", true))) {
            writer.write(propietario.getIdentificacion() + "," +
                    precioMetroCuadrado + "," +
                    numeroMetrosCuadrados + "," +
                    valorAlicuotaMensual + "," +
                    costoFinal + "," +
                    barrio.getNombre() + "," +
                    barrio.getReferencia() + "," +
                    ciudad.getNombre() + "," +
                    ciudad.getProvincia() + "," +
                    ubicacionDepartamento + "," +
                    constructora.getNombre() + "," +
                    constructora.getIdEmpresa());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
      public static List<Departamento> obtenerDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("departamentos.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                String identificacionPropietario = datos[0];
                double precioMetroCuadrado = Double.parseDouble(datos[1]);
                double metrosCuadrados = Double.parseDouble(datos[2]);
                double valorAlicuotaMensual = Double.parseDouble(datos[3]);
                String nombreBarrio = datos[4];
                String nombreCiudad = datos[5];
                String nombreConstructora = datos[6];
                String idEmpresaConstructora = datos[7];

                Propietario propietario = Propietario.obtenerPropietario(identificacionPropietario);
                Barrio barrio = Barrio.obtenerBarrio(nombreBarrio);
                Ciudad ciudad = Ciudad.obtenerCiudad(nombreCiudad);
                Constructora constructora = Constructora.obtenerConstructora(idEmpresaConstructora);

                Departamento departamento = new Departamento(propietario, precioMetroCuadrado, metrosCuadrados, valorAlicuotaMensual, barrio, ciudad, constructora);
                departamentos.add(departamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return departamentos;
}
}
