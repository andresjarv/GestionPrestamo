
public class EstudianteIngenieria {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private int numeroSemestre;
    private float promedioAcumulado;
    private String serial;

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono, int numeroSemestre, float promedioAcumulado, String serial) {
        setCedula(cedula);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setNumeroSemestre(numeroSemestre);
        setPromedioAcumulado(promedioAcumulado);
        setSerial(serial);
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

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public float getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        if (validarTextoSinCaracteresEspeciales(serial)) {
            this.serial = serial;
        } else {
            throw new IllegalArgumentException("Serial no válido.");
        }
    }

    private boolean validarTextoSinCaracteresEspeciales(String texto) {
        return texto.matches("[a-zA-Z0-9]+");
    }

    private boolean validarTextoSinNumerosNiCaracteresEspeciales(String texto) {
        return texto.matches("[a-zA-Z]+");
    }
     @Override
    public String toString() {
        return  "Cedula: '" + cedula + '\'' +
                ", Nombre: '" + nombre + '\'' +
                ", Apellido:" + apellido +
                ", Telefono: " + telefono +
                ", Semestre: '" + numeroSemestre + '\'' +
                ", Promedio Acumulado: '" + promedioAcumulado + '\'' +
                '}';
    }
}


