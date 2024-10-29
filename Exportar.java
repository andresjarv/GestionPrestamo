import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Exportar {

    public void exportarArchivo(LinkedList<Estudiante> eIngenierias,LinkedList<Estudiante>eDiseños, LinkedList<Dispositivo> laptops, LinkedList<Dispositivo> tab ){
        
        if(eDiseños.isEmpty()||eIngenierias.isEmpty()||laptops.isEmpty()||tab.isEmpty()){
            JOptionPane.showMessageDialog(null, "Una de las listas esta vacia, no se puede exportar los archivos");
            return;
        }else{
            try(FileWriter i = new FileWriter("EstIngenieria.txt")){
                for (Estudiante eIngenieria : eIngenierias) {
                    EstIngenieria eIng = (EstIngenieria) eIngenieria;
                    i.write("Cedula: "+ eIng.getCedula()+"\n");
                    i.write("Nombre: "+eIng.getNombre()+"\n");
                    i.write("Apellido: "+eIng.getApellido()+"\n");
                    i.write("Telefono: "+eIng.getTelefono()+"\n");
                    i.write("Serial: "+eIng.getSerial()+"\n");
                    i.write("Semestre cursado: "+eIng.getNumSemestreActual()+"\n");
                    i.write("Promedio Acumulado: "+eIng.getPromedioAcum()+"\n");
                    i.write("----------------------------------------------------------------------");                                        
                }
                
            } catch (IOException i) {
                i.printStackTrace();
            }
            try(FileWriter d = new FileWriter("EstDiseno.txt")){
                for (Estudiante eDiseno: eDiseños) {
                    EstDiseño eDis = (EstDiseño) eDiseno;
                    d.write("Cedula: "+ eDis.getCedula()+"\n");
                    d.write("Nombre: "+eDis.getNombre()+"\n");
                    d.write("Apellido: "+eDis.getApellido()+"\n");
                    d.write("Telefono: "+eDis.getTelefono()+"\n");
                    d.write("Serial: "+eDis.getSerial()+"\n");
                    d.write("Cantidad Asignaturas: "+eDis.getCantAsignaturas()+"\n");
                    d.write("Modalidad de Estudio: "+eDis.getModEstudio()+"\n");
                    d.write("----------------------------------------------------------------------");
                                     
                }
                
            } catch (IOException d) {
                d.printStackTrace();
            }
            try(FileWriter l = new FileWriter("Laptop.txt")){
                for (Dispositivo laptop: laptops) {
                    Laptop lap = (Laptop) laptop;
                    l.write("Serial: "+ lap.getSerial()+"\n");
                    l.write("Nombre: "+lap.getMarca()+"\n");
                    l.write("Apellido: "+lap.getTamaño()+"\n");
                    l.write("Telefono: "+lap.getPrecio()+"\n");
                    l.write("Serial: "+lap.getSistemaOperativo()+"\n");
                    l.write("Cantidad Asignaturas: "+lap.getProcesador()+"\n");  
                    l.write("----------------------------------------------------------------------");            
                }   
                
            } catch (IOException l) {
                l.printStackTrace();
            }
            try(FileWriter t = new FileWriter("Tablet.txt")){
                for (Dispositivo tablet: tab) {
                    Tablet ta = (Tablet) tablet;
                    t.write("Serial: "+ ta.getSerial()+"\n");
                    t.write("Nombre: "+ta.getMarca()+"\n");
                    t.write("Apellido: "+ta.getTamaño()+"\n");
                    t.write("Telefono: "+ta.getPrecio()+"\n");
                    t.write("Serial: "+ta.getPeso()+"\n");
                    t.write("Cantidad Asignaturas: "+ta.getAlmacenamiento()+"\n");                    
                    t.write("----------------------------------------------------------------------");                    
                }
                
            } catch (IOException t) {
                t.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Archivos exportados correctamente.");
        }

    }
    
}
