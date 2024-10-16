public class Laptop extends Dispositivo {
    
    private String Almacenamiento;
    private float Peso;
   
    public Laptop(String serial, String marca, float tamaño, float precio, String almacenamiento, float peso) {
        super(serial, marca, tamaño, precio);
        Almacenamiento = almacenamiento;
        Peso = peso;
    }
    public String getAlmacenamiento() {
        return Almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        Almacenamiento = almacenamiento;
    }
    public float getPeso() {
        return Peso;
    }
    public void setPeso(float peso) {
        Peso = peso;
    }

    

    

    
}