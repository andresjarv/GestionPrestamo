import java.util.LinkedList;
import javax.swing.*;

public class MetodosPrestamo {

    private static void validarTexto(String texto, String tipo) {
        if (tipo.equals("cedula") || tipo.equals("telefono")) {
            if (!texto.matches("\\d+") || texto.length() > 20) {
                throw new IllegalArgumentException(tipo + " debe contener solo números y no más de 20 dígitos.");
            }
        } else {
            if (!texto.matches("[A-Za-z\\s]+")) {
                throw new IllegalArgumentException("El " + tipo + " no debe contener números ni caracteres especiales.");
            }
        }
    }
    
    private static void validarTelefono(String telefono) {
        if (!telefono.matches("\\d+") || telefono.length() > 20) {
            throw new IllegalArgumentException("El teléfono debe contener solo números y no más de 20 dígitos.");
        }
    }

    public String registrarEstudiante(LinkedList<EstudianteIngenieria> estudiantesIngenieria, LinkedList<EstudianteDiseno> estudiantesDiseno) {
        String registrar = "";
        
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de estudiante (1. Ingeniería/ 2. Diseño):");
        
        if (tipo.equals("1")) {
            String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
            validarTexto(cedula, "cedula");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            validarTexto(nombre, "nombre");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
            validarTexto(apellido, "apellido");
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
            validarTelefono(telefono);
            int semestre = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de semestre actualmente cursado:"));
            float promedio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el promedio acumulado:"));
            String serial = JOptionPane.showInputDialog("Ingrese el serial del estudiante:");

            estudiantesIngenieria.add(new EstudianteIngenieria(cedula, nombre, apellido, telefono, semestre, promedio, serial));
            registrar = ("Estudiante de ingeniería registrado exitosamente.");
        } else if (tipo.equals("2")) {
            String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
            validarTexto(cedula, "cedula");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            validarTexto(nombre, "nombre");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
            validarTexto(apellido, "apellido");
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
            validarTelefono(telefono);
            String modalidad = JOptionPane.showInputDialog("Ingrese la modalidad de estudio (virtual/presencial):");
            int cantidadAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asignaturas que está viendo:"));
            String serial = JOptionPane.showInputDialog("Ingrese el serial del estudiante:");

            estudiantesDiseno.add(new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidad, cantidadAsignaturas, serial));
            registrar = ("Estudiante de diseño registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de estudiante no válido.");
        }
        return registrar;
    }

    public void modificarEstudiante(LinkedList<EstudianteIngenieria> estudiantesIngenieria, LinkedList<EstudianteDiseno> estudiantesDiseno) {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante a modificar:");
        boolean encontrado = false;

        for (EstudianteIngenieria estudiante : estudiantesIngenieria) {
            if (estudiante.getCedula().equals(cedula)) {
                estudiante.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre del estudiante:"));
                estudiante.setApellido(JOptionPane.showInputDialog("Ingrese el nuevo apellido del estudiante:"));
                estudiante.setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo teléfono del estudiante:"));
                estudiante.setNumeroSemestre(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de semestre:")));
                estudiante.setPromedioAcumulado(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo promedio acumulado:")));
                encontrado = true;
                JOptionPane.showMessageDialog(null, "Estudiante de ingeniería modificado exitosamente.");
                break;
            }
        }

        if (!encontrado) {
            for (EstudianteDiseno estudiante : estudiantesDiseno) {
                if (estudiante.getCedula().equals(cedula)) {
                    estudiante.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre del estudiante:"));
                    estudiante.setApellido(JOptionPane.showInputDialog("Ingrese el nuevo apellido del estudiante:"));
                    estudiante.setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo teléfono del estudiante:"));
                    estudiante.setModalidadEstudio(JOptionPane.showInputDialog("Ingrese la nueva modalidad de estudio:"));
                    estudiante.setCantidadAsignaturas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de asignaturas:")));
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "Estudiante de diseño modificado exitosamente.");
                    break;
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void buscarEstudiante(LinkedList<EstudianteIngenieria> estudiantesIngenieria, LinkedList<EstudianteDiseno> estudiantesDiseno) {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante a buscar:");
        for (EstudianteIngenieria estudiante : estudiantesIngenieria) {
            if (estudiante.getCedula().equals(cedula)) {
                JOptionPane.showMessageDialog(null, estudiante.toString());
                return;
            }
        }
        for (EstudianteDiseno estudiante : estudiantesDiseno) {
            if (estudiante.getCedula().equals(cedula)) {
                JOptionPane.showMessageDialog(null, estudiante.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }

    public void eliminarEstudiante(LinkedList<EstudianteIngenieria> estudiantesIngenieria, LinkedList<EstudianteDiseno> estudiantesDiseno) {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante a eliminar:");
        boolean eliminado = estudiantesIngenieria.removeIf(estudiante -> estudiante.getCedula().equals(cedula)) ||
                estudiantesDiseno.removeIf(estudiante -> estudiante.getCedula().equals(cedula));

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void registrarEquipo(LinkedList<Laptop> listaLaptops, LinkedList<Tableta> listaTabletas) {
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de equipo (1. Laptop/ 2. Tableta):").toLowerCase();
        if (tipo.equals("1")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la laptop:");
            //validarTexto(serial, "serial");
            String marca = JOptionPane.showInputDialog("Ingrese la marca de la laptop:");
            //validarTexto(marca, "marca");
            float tamano = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño de la laptop (pulgadas):"));
            float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio de la laptop:"));
            String sistemaOperativo = JOptionPane.showInputDialog("Seleccione el sistema operativo (Windows 7, Windows 10, Windows 11):");
            String procesador = JOptionPane.showInputDialog("Seleccione el procesador (AMD Ryzen, Intel® Core™ i5):");

            listaLaptops.add(new Laptop(serial, marca, tamano, precio, sistemaOperativo, procesador));
            JOptionPane.showMessageDialog(null, "Laptop registrada exitosamente.");
        } else if (tipo.equals("2")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta:");
            //validarTexto(serial, "serial");
            String marca = JOptionPane.showInputDialog("Ingrese la marca de la tableta:");
            //validarTexto(marca, "marca");
            float tamano = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño de la tableta (pulgadas):"));
            float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio de la tableta:"));
            String almacenamiento = JOptionPane.showInputDialog("Seleccione el almacenamiento (256 GB, 512 GB, 1 TB):");
            float peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso de la tableta (kg):"));

            listaTabletas.add(new Tableta(serial, marca, tamano, precio, almacenamiento, peso));
            JOptionPane.showMessageDialog(null, "Tableta registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de equipo no válido.");
        }
    }

    public void modificarEquipo(LinkedList<Laptop> listaLaptops, LinkedList<Tableta> listaTabletas) {
        String serial = JOptionPane.showInputDialog("Ingrese el serial del equipo a modificar:");
        boolean encontrado = false;

        for (Laptop laptop : listaLaptops) {
            if (laptop.getSerial().equals(serial)) {
                laptop.setMarca(JOptionPane.showInputDialog("Ingrese la nueva marca de la laptop:"));
                laptop.setTamano(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo tamaño de la laptop:")));
                laptop.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo precio de la laptop:")));
                laptop.setSistemaOperativo(JOptionPane.showInputDialog("Ingrese el nuevo sistema operativo de la laptop:"));
                laptop.setProcesador(JOptionPane.showInputDialog("Ingrese el nuevo procesador de la laptop:"));
                encontrado = true;
                JOptionPane.showMessageDialog(null, "Laptop modificada exitosamente.");
                break;
            }
        }

        if (!encontrado) {
            for (Tableta tableta : listaTabletas) {
                if (tableta.getSerial().equals(serial)) {
                    tableta.setMarca(JOptionPane.showInputDialog("Ingrese la nueva marca de la tableta:"));
                    tableta.setTamano(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo tamaño de la tableta:")));
                    tableta.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo precio de la tableta:")));
                    tableta.setAlmacenamiento(JOptionPane.showInputDialog("Ingrese el nuevo almacenamiento de la tableta:"));
                    tableta.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo peso de la tableta:")));
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "Tableta modificada exitosamente.");
                    break;
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
        }
    }

    public void buscarEquipo(LinkedList<Laptop> listaLaptops, LinkedList<Tableta> listaTabletas) {
        String serial = JOptionPane.showInputDialog("Ingrese el serial del equipo a buscar:");
        for (Laptop laptop : listaLaptops) {
            if (laptop.getSerial().equals(serial)) {
                JOptionPane.showMessageDialog(null, laptop.toString());
                return;
            }
        }
        for (Tableta tableta : listaTabletas) {
            if (tableta.getSerial().equals(serial)) {
                JOptionPane.showMessageDialog(null, tableta.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
    }

    public void eliminarEquipo(LinkedList<Laptop> listaLaptops, LinkedList<Tableta> listaTabletas) {
        String serial = JOptionPane.showInputDialog("Ingrese el serial del equipo a eliminar:");
        boolean eliminado = listaLaptops.removeIf(laptop -> laptop.getSerial().equals(serial)) ||
                listaTabletas.removeIf(tableta -> tableta.getSerial().equals(serial));

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Equipo eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
        }
    }

    public void imprimirInventario(LinkedList<Laptop> listaLaptops, LinkedList<Tableta> listaTabletas) {
        StringBuilder inventario = new StringBuilder("Inventario de equipos:\n\nLaptops:\n");
        for (Laptop laptop : listaLaptops) {
            inventario.append(laptop.toString()).append("\n");
        }
        inventario.append("\nTabletas:\n");
        for (Tableta tableta : listaTabletas) {
            inventario.append(tableta.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, inventario.toString());
    }

    public void imprimirEstudiantes(LinkedList<EstudianteDiseno> listaDiseno, LinkedList<EstudianteIngenieria> listaIngenieria) {
        StringBuilder inventario = new StringBuilder("Estudiantes Registrados:\n\nEstudiantes de diseño:\n");
        for (EstudianteDiseno estudianteDiseno : listaDiseno) {
            inventario.append(estudianteDiseno.toString()).append("\n");
        }
        inventario.append("\nEstudiantes de Ingeniería:\n");
        for (EstudianteIngenieria estudianteIngenieria:listaIngenieria ) {
            inventario.append(estudianteIngenieria.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, inventario.toString());
    }

    public void registrarPrestamoIngenieria(LinkedList<EstudianteIngenieria> estudiantes, LinkedList<Laptop> laptopsPrestadas) {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
        boolean estudianteEncontrado = false;
        for (EstudianteIngenieria estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                estudianteEncontrado = true;
                String serialLaptop = JOptionPane.showInputDialog("Ingrese el serial de la laptop:");
                boolean laptopEncontrada = false;
                for (Laptop laptop : laptopsPrestadas) {
                    if (laptop.getSerial().equals(serialLaptop)) {
                        laptopEncontrada = true;
                        if (laptopsPrestadas.stream().anyMatch(l -> l.getSerial().equals(serialLaptop))) {
                            JOptionPane.showMessageDialog(null, "Este estudiante ya tiene una laptop prestada.");
                        } else {
                            laptopsPrestadas.add(laptop);
                            JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
                        }
                        break;
                    }
                }
                if (!laptopEncontrada) {
                    JOptionPane.showMessageDialog(null, "Laptop no encontrada.");
                }
                break;
            }
        }
        if (!estudianteEncontrado) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void registrarPrestamoDiseno(LinkedList<EstudianteDiseno> estudiantes, LinkedList<Tableta> tabletasPrestadas) {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
        boolean estudianteEncontrado = false;
        for (EstudianteDiseno estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                estudianteEncontrado = true;
                String serialTableta = JOptionPane.showInputDialog("Ingrese el serial de la tableta:");
                boolean tabletaEncontrada = false;
                for (Tableta tableta : tabletasPrestadas) {
                    if (tableta.getSerial().equals(serialTableta)) {
                        tabletaEncontrada = true;
                        if (tabletasPrestadas.stream().anyMatch(t -> t.getSerial().equals(serialTableta))) {
                            JOptionPane.showMessageDialog(null, "Este estudiante ya tiene una tableta prestada.");
                        } else {
                            tabletasPrestadas.add(tableta);
                            JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
                        }
                        break;
                    }
                }
                if (!tabletaEncontrada) {
                    JOptionPane.showMessageDialog(null, "Tableta no encontrada.");
                }
                break;
            }
        }
        if (!estudianteEncontrado) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void devolverPrestamo(LinkedList<Laptop> laptopsPrestadas, LinkedList<Tableta> tabletasPrestadas) {
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de equipo (Laptop/ Tableta):").toLowerCase();
        if (tipo.equals("laptop")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la laptop a devolver:");
            boolean eliminado = laptopsPrestadas.removeIf(laptop -> laptop.getSerial().equals(serial));
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Laptop devuelta exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Laptop no encontrada en préstamos.");
            }
        } else if (tipo.equals("tableta")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta a devolver:");
            boolean eliminado = tabletasPrestadas.removeIf(tableta -> tableta.getSerial().equals(serial));
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Tableta devuelta exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Tableta no encontrada en préstamos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de equipo no válido.");
        }
    }

    public void modificarPrestamo(LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria, LinkedList<Laptop> listaLaptops, LinkedList<Tableta> listaTabletas) {
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de equipo (Laptop/ Tableta) para modificar el préstamo:").toLowerCase();
        if (tipo.equals("laptop")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la laptop a modificar:");
            for (EstudianteIngenieria laptop : listaEstudiantesIngenieria) {
                if (laptop.getSerial().equals(serial)) {
                    String nuevoSerial = JOptionPane.showInputDialog("Ingrese el nuevo serial de la laptop:");
                    laptop.setSerial(nuevoSerial);
                    JOptionPane.showMessageDialog(null, "Préstamo de laptop modificado exitosamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Laptop no encontrada en préstamos.");
        } else if (tipo.equals("tableta")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta a modificar:");
            for (Tableta tableta : listaTabletas) {
                if (tableta.getSerial().equals(serial)) {
                    String nuevoSerial = JOptionPane.showInputDialog("Ingrese el nuevo serial de la tableta:");
                    tableta.setSerial(nuevoSerial);
                    JOptionPane.showMessageDialog(null, "Préstamo de tableta modificado exitosamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Tableta no encontrada en préstamos.");
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de equipo no válido.");
        }
    }

    public void buscarPrestamo(LinkedList<Laptop> laptopsPrestadas, LinkedList<Tableta> tabletasPrestadas) {
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de equipo (Laptop/ Tableta) para buscar el préstamo:").toLowerCase();
        if (tipo.equals("laptop")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la laptop a buscar:");
            for (Laptop laptop : laptopsPrestadas) {
                if (laptop.getSerial().equals(serial)) {
                    JOptionPane.showMessageDialog(null, "Laptop en préstamo: " + laptop.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Laptop no encontrada en préstamos.");
        } else if (tipo.equals("tableta")) {
            String serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta a buscar:");
            for (Tableta tableta : tabletasPrestadas) {
                if (tableta.getSerial().equals(serial)) {
                    JOptionPane.showMessageDialog(null, "Tableta en préstamo: " + tableta.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Tableta no encontrada en préstamos.");
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de equipo no válido.");
        }
    }

    public void devolucionPrestamoIngenieria(LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria,
            LinkedList<Laptop> listaLaptops) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolucionPrestamoIngenieria'");
    }

    public void buscarPrestamoPorCedulaIngenieria(LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria,
            LinkedList<Laptop> listaLaptops) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPrestamoPorCedulaIngenieria'");
    }

    public void modificarPrestamoDiseno(LinkedList<EstudianteDiseno> listaEstudiantesDiseno,
            LinkedList<Tableta> listaTabletas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarPrestamoDiseno'");
    }

    public void devolucionPrestamoDiseno(LinkedList<EstudianteDiseno> listaEstudiantesDiseno,
            LinkedList<Tableta> listaTabletas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolucionPrestamoDiseno'");
    }

    public void buscarPrestamoPorCedulaDiseno(LinkedList<EstudianteDiseno> listaEstudiantesDiseno,
            LinkedList<Tableta> listaTabletas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPrestamoPorCedulaDiseno'");
    }
}
