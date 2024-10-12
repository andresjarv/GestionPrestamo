import java.util.regex.*;

public class EstDiseno{
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modEstudio;
    private int cantAsignatura;//Asignaturas que esta viendo este semestre
    
    public EstDiseno() {
    }

    public EstDiseno(String cedula, String nombre, String apellido, String telefono, String modEstudio,
            int cantAsignatura) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modEstudio = modEstudio;
        this.cantAsignatura = cantAsignatura;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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