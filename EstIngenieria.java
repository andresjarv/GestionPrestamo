public class EstIngenieria extends Estudiante{
    private int semestre;
    private Double promAcum;       

    public EstIngenieria(String cedula,String nombre,String apellido,String telefono,String serial,int semestre, Double promAcum) {
        super(cedula, nombre, apellido, telefono, serial);
        this.semestre = semestre;
        this.promAcum = promAcum;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getPromAcum() {
        return promAcum;
    }

    public void setPromAcum(Double promAcum) {
        this.promAcum = promAcum;
    }

   
}