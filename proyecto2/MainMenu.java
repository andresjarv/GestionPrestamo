import javax.swing.*;
import java.util.LinkedList;

public class MainMenu {

    private static LinkedList<Laptop> listaLaptops = new LinkedList<>();
    private static LinkedList<Tableta> listaTabletas = new LinkedList<>();
    private static LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria = new LinkedList<>();
    private static LinkedList<EstudianteDiseno> listaEstudiantesDiseno = new LinkedList<>();

    public static void main(String[] args) {
        MetodosPrestamo metodos = new MetodosPrestamo();
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
                    + "1.1 Registrar préstamo de equipo\n"
                    + "1.2 Modificar préstamo de equipo (Por serial o cédula)\n"
                    + "1.3 Devolución de equipo (Por serial o cédula)\n"
                    + "1.4 Buscar equipo (Por serial o cédula)\n"
                    + "1.5 Volver al menú principal";
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
                    + "2.1 Registrar préstamo de equipo\n"
                    + "2.2 Modificar préstamo de equipo (Por serial o cédula)\n"
                    + "2.3 Devolución de equipo (Por serial o cédula)\n"
                    + "2.4 Buscar equipo (Por serial o cédula)\n"
                    + "2.5 Volver al menú principal";
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
                    + "4.1 Registrar Estudiante\n"
                    + "4.2 Modificar Estudiante\n"
                    + "4.3 Buscar Estudiante\n"
                    + "4.4 Eliminar Estudiante\n"
                    + "4.5 Volver al menú principal";
            opcionGestionEstudiantes = Integer.parseInt(JOptionPane.showInputDialog(menuEstudiantes));

            switch (opcionGestionEstudiantes) {
                case 1:
                JOptionPane.showMessageDialog(null, metodos.registrarEstudiante(listaEstudiantesIngenieria, listaEstudiantesDiseno));
                    break;
                case 2:
                    metodos.modificarEstudiante(listaEstudiantesIngenieria, listaEstudiantesDiseno);
                    break;
                case 3:
                    metodos.buscarEstudiante(listaEstudiantesIngenieria, listaEstudiantesDiseno);
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
                    + "5.1 Registrar Equipo\n"
                    + "5.2 Modificar Equipo\n"
                    + "5.3 Buscar Equipo\n"
                    + "5.4 Eliminar Equipo\n"
                    + "5.5 Volver al menú principal";
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
}
