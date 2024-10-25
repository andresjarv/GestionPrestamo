public class Prestamo {
    private Equipo equipo;
    private String fechaPrestamo;
    private String fechaDevolucion;
    

    public Prestamo(Equipo equipo, String fechaPrestamo, String fechaDevolucion) {
        this.equipo = equipo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "equipo=" + equipo +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                '}';
    }
}
