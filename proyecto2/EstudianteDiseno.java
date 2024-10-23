import java.util.regex.Pattern;

public class EstudianteDiseno {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modalidadEstudio; // "virtual" o "presencial"
    private int cantidadAsignaturas;
    private String serial;

    public EstudianteDiseno(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio, int cantidadAsignaturas, String serial2) {
        setCedula(cedula);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setModalidadEstudio(modalidadEstudio);
        setCantidadAsignaturas(cantidadAsignaturas);
        setSerial(serial2);
    }

    // Métodos getters y setters con validaciones
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (validarTextoSinCaracteresEspeciales(cedula)) {
            this.cedula = cedula;
        } else {
            throw new IllegalArgumentException("Cédula no válida.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (validarTextoSinNumerosNiCaracteresEspeciales(nombre)) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("Nombre no válido.");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (validarTextoSinNumerosNiCaracteresEspeciales(apellido)) {
            this.apellido = apellido;
        } else {
            throw new IllegalArgumentException("Apellido no válido.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (validarTextoSinCaracteresEspeciales(telefono)) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("Teléfono no válido.");
        }
    }

    public String getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio; // Aquí podrías validar si es "virtual" o "presencial"
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial2) {
        this.serial = serial2;
    }

    private boolean validarTextoSinCaracteresEspeciales(String texto) {
        return texto.matches("[a-zA-Z0-9]+");
    }

    private boolean validarTextoSinNumerosNiCaracteresEspeciales(String texto) {
        return texto.matches("[a-zA-Z]+");
    }
}
