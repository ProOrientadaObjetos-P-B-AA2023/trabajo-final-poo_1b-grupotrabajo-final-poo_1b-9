package paquete01;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;
import java.util.List;
import java.util.Scanner;

public class EjecutorInmobiliaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 14) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarPropietario();
                    break;
                case 2:
                    ingresarBarrio();
                    break;
                case 3:
                    ingresarCiudad();
                    break;
                case 4:
                    ingresarConstructora();
                    break;
                case 5:
                    ingresarCasa();
                    break;
                case 6:
                    ingresarDepartamento();
                    break;
                case 8:
                    listarPropietarios();
                    break;
                case 9:
                    listarBarrios();
                    break;
                case 10:
                    listarCiudades();
                    break;
                case 11:
                    listarConstructoras();
                    break;
                case 12:
                    listarCasas();
                    break;
                case 13:
                    listarDepartamentos();
                    break;
                case 14:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("----- Menú de opciones -----");
        System.out.println("1. Ingresar propietario");
        System.out.println("2. Ingresar barrio");
        System.out.println("3. Ingresar ciudad");
        System.out.println("4. Ingresar constructora");
        System.out.println("5. Ingresar casa");
        System.out.println("6. Ingresar departamento");
        System.out.println("8. Listar propietarios");
        System.out.println("9. Listar barrios");
        System.out.println("10. Listar ciudades");
        System.out.println("11. Listar constructoras");
        System.out.println("12. Listar casas");
        System.out.println("13. Listar departamentos");
        System.out.println("14. Salir");
        System.out.println("Seleccione una opción: ");
    }

    public static void ingresarPropietario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los nombres del propietario: ");
        String nombres = scanner.nextLine();
        System.out.println("Ingrese los apellidos del propietario: ");
        String apellidos = scanner.nextLine();
        System.out.println("Ingrese la identificación del propietario: ");
        String identificacion = scanner.nextLine();

        Propietario propietario = new Propietario(nombres, apellidos, identificacion);
        propietario.guardarPropietario();
        System.out.println("Propietario ingresado exitosamente.");
    }

    public static void ingresarBarrio() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del barrio: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la referencia del barrio: ");
        String referencia = scanner.nextLine();

        Barrio barrio = new Barrio(nombre, referencia);
        barrio.guardarBarrio();
        System.out.println("Barrio ingresado exitosamente.");
    }

    public static void ingresarCiudad() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el nombre de la provincia: ");
        String provincia = scanner.nextLine();

        Ciudad ciudad = new Ciudad(nombre, provincia);
        ciudad.guardarCiudad();
        System.out.println("Ciudad ingresada exitosamente.");
    }

    public static void ingresarConstructora() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la constructora: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID de la empresa: ");
        int idEmpresa = scanner.nextInt();

        Constructora constructora = new Constructora(nombre, idEmpresa);
        constructora.guardarConstructora();
        System.out.println("Constructora ingresada exitosamente.");
    }

    public static void ingresarCasa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la identificación del propietario: ");
        String identificacion = scanner.nextLine();
        Propietario propietario = Propietario.obtenerPropietario(identificacion);
        if (propietario == null) {
            System.out.println("Propietario no encontrado.");
            return;
        }

        System.out.println("Ingrese el precio por metro cuadrado: ");
        double precioMetroCuadrado = scanner.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        double metrosCuadrados = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el nombre del barrio: ");
        String nombreBarrio = scanner.nextLine();
        Barrio barrio = Barrio.obtenerBarrio(nombreBarrio);
        if (barrio == null) {
            System.out.println("Barrio no encontrado.");
            return;
        }

        System.out.println("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();
        Ciudad ciudad = Ciudad.obtenerCiudad(nombreCiudad);
        if (ciudad == null) {
            System.out.println("Ciudad no encontrada.");
            return;
        }

        System.out.println("Ingrese el número de cuartos: ");
        int numeroCuartos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el nombre de la constructora: ");
        String nombreConstructora = scanner.nextLine();
        System.out.println("Ingrese el ID de la empresa: ");
        int idEmpresa = scanner.nextInt();
        Constructora constructora = Constructora.obtenerConstructora(idEmpresa);
        if (constructora == null) {
            System.out.println("Constructora no encontrada.");
            return;
        }

        Casa casa = new Casa(propietario, precioMetroCuadrado, metrosCuadrados, barrio, ciudad, numeroCuartos, constructora);
        casa.guardarCasa();
        System.out.println("Casa ingresada exitosamente.");
    }

    public static void ingresarDepartamento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la identificación del propietario: ");
        String identificacion = scanner.nextLine();
        Propietario propietario = Propietario.obtenerPropietario(identificacion);
        if (propietario == null) {
            System.out.println("Propietario no encontrado.");
            return;
        }

        System.out.println("Ingrese el precio por metro cuadrado: ");
        double precioMetroCuadrado = scanner.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        double metrosCuadrados = scanner.nextDouble();
        System.out.println("Ingrese el valor de la alicuota mensual: ");
        double valorAlicuotaMensual = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el nombre del barrio: ");
        String nombreBarrio = scanner.nextLine();
        Barrio barrio = Barrio.obtenerBarrio(nombreBarrio);
        if (barrio == null) {
            System.out.println("Barrio no encontrado.");
            return;
        }

        System.out.println("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();
        Ciudad ciudad = Ciudad.obtenerCiudad(nombreCiudad);
        if (ciudad == null) {
            System.out.println("Ciudad no encontrada.");
            return;
        }

        System.out.println("Ingrese el nombre de la constructora: ");
        String nombreConstructora = scanner.nextLine();
        System.out.println("Ingrese el ID de la empresa: ");
        int idEmpresa = scanner.nextInt();
        Constructora constructora = Constructora.obtenerConstructora(idEmpresa);
        if (constructora == null) {
            System.out.println("Constructora no encontrada.");
            return;
        }

        Departamento departamento = new Departamento(propietario, precioMetroCuadrado, metrosCuadrados, valorAlicuotaMensual, barrio, ciudad, constructora);
        departamento.guardarDepartamento();
        System.out.println("Departamento ingresado exitosamente.");
    }

public static void listarPropietarios() {
    List<Propietario> propietarios = Propietario.obtenerPropietario();
    if (propietarios.isEmpty()) {
        System.out.println("No se han ingresado propietarios.");
    } else {
        System.out.println("Lista de Propietarios:");
        for (Propietario propietario : propietarios) {
            System.out.println(propietario);
        }
    }
}

public static void listarBarrios() {
    List<Barrio> barrios = Barrio.obtenerBarrio();
    if (barrios.isEmpty()) {
        System.out.println("No se han ingresado barrios.");
    } else {
        System.out.println("Lista de Barrios:");
        for (Barrio barrio : barrios) {
            System.out.println(barrio);
        }
    }
}

public static void listarCiudades() {
    List<Ciudad> ciudades = Ciudad.obtenerCiudad();
    if (ciudades.isEmpty()) {
        System.out.println("No se han ingresado ciudades.");
    } else {
        System.out.println("Lista de Ciudades:");
        for (Ciudad ciudad : ciudades) {
            System.out.println(ciudad);
        }
    }
}

public static void listarConstructoras() {
    List<Constructora> constructoras = Constructora.obtenerConstructora();
    if (constructoras.isEmpty()) {
        System.out.println("No se han ingresado constructoras.");
    } else {
        System.out.println("Lista de Constructoras:");
        for (Constructora constructora : constructoras) {
            System.out.println(constructora);
        }
    }
}

public static void listarCasas() {
    List<Casa> casas = Casa.obtenerCasas();
    if (casas.isEmpty()) {
        System.out.println("No se han ingresado casas.");
    } else {
        System.out.println("Lista de Casas:");
        for (Casa casa : casas) {
            System.out.println(casa);
        }
    }
}

public static void listarDepartamentos() {
    List<Departamento> departamentos = Departamento.obtenerDepartamentos();
    if (departamentos.isEmpty()) {
        System.out.println("No se han ingresado departamentos.");
    } else {
        System.out.println("Lista de Departamentos:");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }
}

}
