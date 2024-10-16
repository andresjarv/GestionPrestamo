public class EstIngenieria extends Estudiante{
    private int semestre;
    private float promAcum;       

    public EstIngenieria(String cedula,String nombre,String apellido,String telefono,String serial,int semestre, float promAcum) {
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

    public float getPromAcum() {
        return promAcum;
    }

    public void setPromAcum(float promAcum) {
        this.promAcum = promAcum;
    }

   
}