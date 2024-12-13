/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Doctor;
import Datos.Json;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class ControladorDoctor {
    
    private final Json<Doctor> jsonHandler = new Json<>(
            "doctores.json", new TypeToken<List<Doctor>>() {}.getType());
    private final List<Doctor> doctores;

    public ControladorDoctor() {
        this.doctores = jsonHandler.readData();
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
        jsonHandler.writeData(doctores);
    }

    public List<Doctor> obtenerDoctores() {
        return doctores;
    }

    public void actualizarDoctor(String nombre, Doctor doctorActualizado) {
        for (Doctor d : doctores) {
            if (d.getNombreDoctor().equals(nombre)) {
                d.setEspecialidad(doctorActualizado.getEspecialidad());
                d.setAniosExperiencia(doctorActualizado.getAniosExperiencia());
                jsonHandler.writeData(doctores);
                break;
            }
        }
    }

    public void eliminarDoctor(String nombre) {
        doctores.removeIf(d -> d.getNombreDoctor().equals(nombre));
        jsonHandler.writeData(doctores);
    }
    
}
