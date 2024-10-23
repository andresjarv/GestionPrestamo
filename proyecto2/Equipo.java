public class Equipo {
    private String nombre;
    private String serial;

    public Equipo(String nombre, String serial) {
        this.nombre = nombre;
        this.serial = serial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSerial() {
        return serial;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
