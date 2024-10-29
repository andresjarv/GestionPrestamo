import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Importar{
    public LinkedList<Estudiante> importarEstudiantes(){
        LinkedList<Estudiante> eIngenieria = new LinkedList<>();
        String rutaArchivo = "EstIngenieria.txt";
        try(BufferedReader i = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            EstIngenieria eIng = null;
            while ((linea=i.readLine())!=null) {
                if(linea.startsWith("Cedula")){
                    if(eIng != null){
                        eIngenieria.add(eIng);
                    }
                    eIng = new EstIngenieria(null,null,null,null,null,0,0);
                    eIng.setCedula(linea.substring(8));
                }else if(linea.startsWith("Nombre:")){
                    if(eIng != null){
                        eIng.setNombre(linea.substring(8));
                    }
                }else if(linea.startsWith("Apellido:")){
                    if(eIng != null){
                        eIng.setApellido(linea.substring(10));
                    }
                }else if(linea.startsWith("Telefono:")){
                    if(eIng != null){
                        eIng.setTelefono(linea.substring(10));
                    }
                }else if(linea.startsWith("Serial:")){
                    if(eIng != null){
                        eIng.setSerial(linea.substring(8));
                    }
                }else if(linea.startsWith("Semestre cursado:")){
                    if(eIng != null){
                        eIng.setNumSemestreActual(Integer.parseInt(linea.substring(18)));
                    }
                }else if(linea.startsWith("Promedio Acumulado:")){
                    if(eIng != null){
                        eIng.setPromedioAcum(Float.parseFloat(linea.substring(20)));  
                        eIngenieria.add(eIng);
                        eIng = null;                      
                    }
                }
                
            }
            JOptionPane.showMessageDialog(null, "Archivo importado correctamente.");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return eIngenieria;
    }
}