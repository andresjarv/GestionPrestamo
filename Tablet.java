/**
 * Tablet
 */
public class Tablet extends Dispositivo{
    
    private String SistemaOperativo;
    private String Procesador;  

    public Tablet(String serial, String marca, float tamaño, float precio, String sistemaOperativo, String procesador) {
        super(serial, marca, tamaño, precio);
        SistemaOperativo = sistemaOperativo;
        Procesador = procesador;
    }
    public String getSistemaOperativo() {
        return SistemaOperativo;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        SistemaOperativo = sistemaOperativo;
    }
    public String getProcesador() {
        return Procesador;
    }
    public void setProcesador(String procesador) {
        Procesador = procesador;
    }

    
}