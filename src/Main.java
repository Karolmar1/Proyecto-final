import java.util.ArrayList;
import java.util.List;

class Persona {
    private int id;
    private final String nombre;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

class Doctor extends Persona {
    private String especialidad;

    public Doctor(int id, String nombre, String especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

class Paciente extends Persona {
    private String sintomas;

    public Paciente(int id, String nombre, String sintomas) {
        super(id, nombre);
        this.sintomas = sintomas;
    }

    public String getSintomas() {
        return sintomas;
    }
}

class SistemaCitasMedicas {
    private List<Doctor> doctores = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();

    public void insertarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void insertarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Persona buscarPorID(int id) {
        for (Doctor doctor : doctores) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }

        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }

        return null; // Devuelve null si no se encuentra ninguna persona con el ID dado
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaCitasMedicas sistema = new SistemaCitasMedicas();

        Doctor doctor1 = new Doctor(1, "Dr. Smith", "Cardiología");
        Doctor doctor2 = new Doctor(2, "Dr. Johnson", "Dermatología");

        Paciente paciente1 = new Paciente(101, "John Doe", "Dolor de cabeza");
        Paciente paciente2 = new Paciente(102, "Jane Doe", "Fiebre");

        sistema.insertarDoctor(doctor1);
        sistema.insertarDoctor(doctor2);

        sistema.insertarPaciente(paciente1);
        sistema.insertarPaciente(paciente2);

        int idBuscado = 1;
        Persona personaEncontrada = sistema.buscarPorID(idBuscado);

        if (personaEncontrada != null) {
            System.out.println("Persona encontrada: " + personaEncontrada.getNombre());
        } else {
            System.out.println("No se encontró ninguna persona con el ID " + idBuscado);
        }
    }
}