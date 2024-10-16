import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Metodos {
     public LinkedList<Estudiante> LlenarListaEstudiante(LinkedList<Estudiante> lista) {
        boolean bandera = true;
        int opt = 0;
        while (bandera) {
            opt = (Integer.parseInt(JOptionPane.showInputDialog("Tipo de estudiante que desea agregar\n  1: Ingenieria 2: Diseño")));
            while (opt < 1 && opt > 3) {
                JOptionPane.showMessageDialog(null, "Ha ingresado una opcion no valida.", "Dato Incorrecto",
                        JOptionPane.ERROR_MESSAGE);
                opt = (Integer.parseInt(JOptionPane.showInputDialog("Tipo de estudiante que desea agregar\\n" + //
                                        "  1: Ingenieria 2: Diseño")));
            }
            if (opt == 3) {
                bandera = false;
                break;

            }

            String cedula = JOptionPane.showInputDialog("Cedula: ");
            String nombre = JOptionPane.showInputDialog("Nombre: ");
            String apellido = JOptionPane.showInputDialog("Apellido: ");
            String telefono = JOptionPane.showInputDialog("Telefono Celular: ");
            String serial = JOptionPane.showInputDialog("Serial: ");             
            
            if (opt == 1) {
                int semestre = Integer.parseInt(JOptionPane.showInputDialog("¿Que semestre esta cursando actualmente?: "));
                double promAcum = Double.parseDouble(JOptionPane.showInputDialog("¿Cual es el promedio acumulado del estudiante?: "));
                EstIngenieria ing = new EstIngenieria(cedula, nombre, apellido, telefono, serial, semestre, promAcum);
                lista.add(ing);

            } else {
                String modEstudio = JOptionPane.showInputDialog("¿Cual es su modalidad de estudio actual?: ");                
                int cantAsignatura = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas asiganturas cursa este semestre?: "));
                EstDiseno dis = new EstDiseno(cedula, nombre, apellido, telefono, serial, modEstudio, cantAsignatura);
                lista.add(dis);
            }
        }
        return lista;
    }

    public void MostrarListaEstudiante(LinkedList<Estudiante> lista) {
        String mensaje = "";
        for (Estudiante e : lista) {
            mensaje = mensaje + e.MostrarEstudiante();
            if (e instanceof EstIngenieria) {
                EstIngenieria ing = (EstIngenieria) e;
                mensaje = mensaje + "Semestre cursando: " + ing.getSemestre()+ "\nPromedio acumulado del estudiante: "+ ing.getPromAcum();

            } else {
                EstDiseno dis = (EstDiseno) e;                
                mensaje = mensaje + "Modalidad de estudio: " + dis.getModEstudio() + "\nAsignaturas que esta cursando en el semestre"+dis.getCantAsignatura();

            }
            mensaje = mensaje + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje, "resultados", 1);
    }

    
}
