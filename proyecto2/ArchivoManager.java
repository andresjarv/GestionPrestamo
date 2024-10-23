import javax.swing.*;
import java.io.*;
import java.util.LinkedList;

public class ArchivoManager {
    private static final String ESTUDIANTES_INGENIERIA_FILE = "estudiantesIngenieria.dat";
    private static final String ESTUDIANTES_DISENO_FILE = "estudiantesDiseno.dat";
    private static final String LAPTOPS_FILE = "laptops.dat";
    private static final String TABLETAS_FILE = "tabletas.dat";

    public LinkedList<EstudianteIngenieria> cargarEstudiantesIngenieria() {
        return cargarDatos(ESTUDIANTES_INGENIERIA_FILE);
    }

    public LinkedList<EstudianteDiseno> cargarEstudiantesDiseno() {
        return cargarDatos(ESTUDIANTES_DISENO_FILE);
    }

    public LinkedList<Laptop> cargarLaptops() {
        return cargarDatos(LAPTOPS_FILE);
    }

    public LinkedList<Tableta> cargarTabletas() {
        return cargarDatos(TABLETAS_FILE);
    }

    @SuppressWarnings("unchecked")
    private <T> LinkedList<T> cargarDatos(String archivo) {
        LinkedList<T> lista = new LinkedList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (LinkedList<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo " + archivo + " no existe. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void guardarEstudiantesIngenieria(LinkedList<EstudianteIngenieria> lista) {
        guardarDatos(ESTUDIANTES_INGENIERIA_FILE, lista);
    }

    public void guardarEstudiantesDiseno(LinkedList<EstudianteDiseno> lista) {
        guardarDatos(ESTUDIANTES_DISENO_FILE, lista);
    }

    public void guardarLaptops(LinkedList<Laptop> lista) {
        guardarDatos(LAPTOPS_FILE, lista);
    }

    public void guardarTabletas(LinkedList<Tableta> lista) {
        guardarDatos(TABLETAS_FILE, lista);
    }

    private <T> void guardarDatos(String archivo, LinkedList<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
