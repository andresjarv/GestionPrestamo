
public class EstDiseno extends Estudiante{
    
    private String modEstudio;
    private int cantAsignatura;//Asignaturas que esta viendo este semestre
    

    public EstDiseno(String cedula,String nombre,String apellido,String telefono,String serial,String modEstudio, int cantAsignatura) {
        super(cedula, nombre, apellido, telefono, serial);
        this.modEstudio = modEstudio;
        this.cantAsignatura = cantAsignatura;
    }
    public String getModEstudio() {
        return modEstudio;
    }
    public void setModEstudio(String modEstudio) {
        this.modEstudio = modEstudio;
    }
    public int getCantAsignatura() {
        return cantAsignatura;
    }
    public void setCantAsignatura(int cantAsignatura) {
        this.cantAsignatura = cantAsignatura;
    }
    
   
}