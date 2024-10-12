public class EstIngenieria{
    private int semestre;
    private float promAcum;    
    


    public EstIngenieria(int semestre, float promAcum) {
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