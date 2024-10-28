import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.*;

public class MainMenu {

    private static LinkedList<Laptop> listaLaptops = new LinkedList<>();
    private static LinkedList<Tableta> listaTabletas = new LinkedList<>();
    private static LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria = new LinkedList<>();
    private static LinkedList<EstudianteDiseno> listaEstudiantesDiseno = new LinkedList<>();

    public static void main(String[] args) {
        MetodosPrestamo metodos = new MetodosPrestamo();
        importarDatos(metodos);
        int opcionPrincipal;

        do {
            String menuPrincipal = "MENÚ PRINCIPAL\n\n"
                    + "1. Estudiantes de Ingeniería\n"
                    + "2. Estudiantes de Diseño\n"
                    + "3. Imprimir Inventario Total\n"
                    + "4. Gestión de Estudiantes\n"
                    + "5. Gestión de Equipos\n"
                    + "6. Salir del Programa";
            opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));

            switch (opcionPrincipal) {
                case 1:
                    menuIngenieria(metodos);
                    break;
                case 2:
                    menuDiseno(metodos);
                    break;
                case 3:
                    metodos.imprimirInventario(listaLaptops, listaTabletas);
                    break;
                case 4:
                    menuGestionEstudiantes(metodos);
                    break;
                case 5:
                    menuGestionEquipos(metodos);
                    break;
                case 6:
                    exportarDatos(metodos);
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        } while (opcionPrincipal != 6);
    }

    public static void menuIngenieria(MetodosPrestamo metodos) {
        int opcionIngenieria;

        do {
            String menuIngenieria = "ESTUDIANTES DE INGENIERÍA\n\n"
                    + "1. Registrar préstamo de equipo\n"
                    + "2. Modificar préstamo de equipo (Por serial o cédula)\n"
                    + "3. Devolución de equipo (Por serial o cédula)\n"
                    + "4. Buscar equipo (Por serial o cédula)\n"
                    + "5. Volver al menú principal";
            opcionIngenieria = Integer.parseInt(JOptionPane.showInputDialog(menuIngenieria));

            switch (opcionIngenieria) {
                case 1:
                    metodos.registrarPrestamoIngenieria(listaEstudiantesIngenieria, listaLaptops);
                    break;
                case 2:
                    metodos.modificarPrestamo(listaEstudiantesIngenieria, listaLaptops, listaTabletas);
                    break;
                case 3:
                    metodos.devolucionPrestamoIngenieria(listaEstudiantesIngenieria, listaLaptops);
                    break;
                case 4:
                    metodos.buscarPrestamoPorCedulaIngenieria(listaEstudiantesIngenieria, listaLaptops);
                    break;
                case 5:
                    return; // Volver al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        } while (opcionIngenieria != 5);
    }

    public static void menuDiseno(MetodosPrestamo metodos) {
        int opcionDiseno;

        do {
            String menuDiseno = "ESTUDIANTES DE DISEÑO\n\n"
                    + "1. Registrar préstamo de equipo\n"
                    + "2. Modificar préstamo de equipo (Por serial o cédula)\n"
                    + "3. Devolución de equipo (Por serial o cédula)\n"
                    + "4. Buscar equipo (Por serial o cédula)\n"
                    + "5. Volver al menú principal";
            opcionDiseno = Integer.parseInt(JOptionPane.showInputDialog(menuDiseno));

            switch (opcionDiseno) {
                case 1:
                    metodos.registrarPrestamoDiseno(listaEstudiantesDiseno, listaTabletas);
                    break;
                case 2:
                    metodos.modificarPrestamoDiseno(listaEstudiantesDiseno, listaTabletas);
                    break;
                case 3:
                    metodos.devolucionPrestamoDiseno(listaEstudiantesDiseno, listaTabletas);
                    break;
                case 4:
                    metodos.buscarPrestamoPorCedulaDiseno(listaEstudiantesDiseno, listaTabletas);
                    break;
                case 5:
                    return; // Volver al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        } while (opcionDiseno != 5);
    }

    public static void menuGestionEstudiantes(MetodosPrestamo metodos) {
        int opcionGestionEstudiantes;

        do {
            String menuEstudiantes = "GESTIÓN DE ESTUDIANTES\n\n"
                    + "1. Registrar Estudiante\n"
                    + "2. Modificar Estudiante\n"
                    + "3. Buscar Estudiante\n"
                    + "4. Eliminar Estudiante\n"
                    + "5. Volver al menú principal";
            opcionGestionEstudiantes = Integer.parseInt(JOptionPane.showInputDialog(menuEstudiantes));

            switch (opcionGestionEstudiantes) {
                case 1:
                JOptionPane.showMessageDialog(null, metodos.registrarEstudiante(listaEstudiantesIngenieria, listaEstudiantesDiseno));
                    break;
                case 2:
                    metodos.modificarEstudiante(listaEstudiantesIngenieria, listaEstudiantesDiseno);
                    break;
                case 3:
                    metodos.imprimirEstudiantes(listaEstudiantesDiseno, listaEstudiantesIngenieria);
                    break;
                case 4:
                    metodos.eliminarEstudiante(listaEstudiantesIngenieria, listaEstudiantesDiseno);
                    break;
                case 5:
                    return; // Volver al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        } while (opcionGestionEstudiantes != 5);
    }

    public static void menuGestionEquipos(MetodosPrestamo metodos) {
        int opcionGestionEquipos;

        do {
            String menuEquipos = "GESTIÓN DE EQUIPOS\n\n"
                    + "1. Registrar Equipo\n"
                    + "2. Modificar Equipo\n"
                    + "3. Buscar Equipo\n"
                    + "4. Eliminar Equipo\n"
                    + "5. Volver al menú principal";
            opcionGestionEquipos = Integer.parseInt(JOptionPane.showInputDialog(menuEquipos));

            switch (opcionGestionEquipos) {
                case 1:
                    metodos.registrarEquipo(listaLaptops, listaTabletas);
                    break;
                case 2:
                    metodos.modificarEquipo(listaLaptops, listaTabletas);
                    break;
                case 3:
                    metodos.buscarEquipo(listaLaptops, listaTabletas);
                    break;
                case 4:
                    metodos.eliminarEquipo(listaLaptops, listaTabletas);
                    break;
                case 5:
                    return; // Volver al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        } while (opcionGestionEquipos != 5);
    }

    private static void importarDatos(MetodosPrestamo metodos) {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Lógica para importar datos según el tipo de línea
                if (data[0].equals("Laptop")) {
                    listaLaptops.add(new Laptop(data[1], data[2], Float.parseFloat(data[3]), Float.parseFloat(data[4]), data[5], data[6]));
                } else if (data[0].equals("Tableta")) {
                    listaTabletas.add(new Tableta(data[1], data[2], Float.parseFloat(data[3]), Float.parseFloat(data[4]), data[5], Float.parseFloat(data[6])));
                } else if (data[0].equals("EstudianteIngenieria")) {
                    listaEstudiantesIngenieria.add(new EstudianteIngenieria(data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Float.parseFloat(data[6]), data[7]));
                } else if (data[0].equals("EstudianteDiseno")) {
                    listaEstudiantesDiseno.add(new EstudianteDiseno(data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]), data[7]));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al importar datos: " + e.getMessage());
        }
    }

    private static void exportarDatos(MetodosPrestamo metodos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("datos.txt"))) {
            for (Laptop laptop : listaLaptops) {
                writer.println("Laptop," + laptop.getSerial() + "," + laptop.getMarca() + "," + laptop.getTamano() + "," + laptop.getPrecio() + "," + laptop.getSistemaOperativo() + "," + laptop.getProcesador());
            }
            for (Tableta tableta : listaTabletas) {
                writer.println("Tableta," + tableta.getSerial() + "," + tableta.getMarca() + "," + tableta.getTamano() + "," + tableta.getPrecio() + "," + tableta.getAlmacenamiento() + "," + tableta.getPeso());
            }
            for (EstudianteIngenieria estudiante : listaEstudiantesIngenieria) {
                writer.println("EstudianteIngenieria," + estudiante.getCedula() + "," + estudiante.getNombre() + "," + estudiante.getApellido() + "," + estudiante.getTelefono() + "," + estudiante.getNumeroSemestre() + "," + estudiante.getPromedioAcumulado() + "," + estudiante.getSerial());
            }
            for (EstudianteDiseno estudiante : listaEstudiantesDiseno) {
                writer.println("EstudianteDiseno," + estudiante.getCedula() + "," + estudiante.getNombre() + "," + estudiante.getApellido() + "," + estudiante.getTelefono()  + "," + estudiante.getModalidadEstudio() + "," + estudiante.getCantidadAsignaturas() + ","+estudiante.getSerial());
            }
            writer.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al exportar datos: " + e.getMessage());
        }
    }
}

