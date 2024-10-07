public class EstDiseno{
    private String Cedula;
    private String nombre;
    private String Apellido;
    private String telefono;
    private String ModEstudio;
    private int CantAsignatura;//Asignaturas que esta viendo este semestre
    
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getModEstudio() {
        return ModEstudio;
    }
    public void setModEstudio(String modEstudio) {
        ModEstudio = modEstudio;
    }
    public int getCantAsignatura() {
        return CantAsignatura;
    }
    public void setCantAsignatura(int cantAsignatura) {
        CantAsignatura = cantAsignatura;
    }

     

}