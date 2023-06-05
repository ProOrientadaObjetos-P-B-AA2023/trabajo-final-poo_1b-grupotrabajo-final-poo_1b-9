package paquete06;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Casa {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;

    public Casa(Propietario propietario, double precioMetroCuadrado, double numeroMetrosCuadrados, Barrio barrio, Ciudad ciudad, int numeroCuartos, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
        this.costoFinal = numeroMetrosCuadrados * precioMetroCuadrado;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.numeroCuartos = numeroCuartos;
        this.constructora = constructora;
    }



    public void guardarCasa() {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("casas.dat", true))) {
            writer.write(propietario.getIdentificacion() + "," +
                    precioMetroCuadrado + "," +
                    numeroMetrosCuadrados + "," +
                    costoFinal + "," +
                    barrio.getNombre() + "," +
                    barrio.getReferencia() + "," +
                    ciudad.getNombre() + "," +
                    ciudad.getProvincia() + "," +
                    numeroCuartos + "," +
                    constructora.getNombre() + "," +
                    constructora.getIdEmpresa());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
    }
}
     public static List<Casa> obtenerCasas() {
        List<Casa> casas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("casas.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                String identificacionPropietario = datos[0];
                double precioMetroCuadrado = Double.parseDouble(datos[1]);
                double metrosCuadrados = Double.parseDouble(datos[2]);
                String nombreBarrio = datos[3];
                String nombreCiudad = datos[4];
                int numeroCuartos = Integer.parseInt(datos[5]);
                String nombreConstructora = datos[6];
                String idEmpresaConstructora = datos[7];

                Propietario propietario = Propietario.obtenerPropietario(identificacionPropietario);
                Barrio barrio = Barrio.obtenerBarrio(nombreBarrio);
                Ciudad ciudad = Ciudad.obtenerCiudad(nombreCiudad);
                Constructora constructora = Constructora.obtenerConstructora(idEmpresaConstructora);

                Casa casa = new Casa(propietario, precioMetroCuadrado, metrosCuadrados, barrio, ciudad, numeroCuartos, constructora);
                casas.add(casa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return casas;
    }

}
