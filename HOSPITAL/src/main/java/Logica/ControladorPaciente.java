/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Paciente;
import Datos.Json;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class ControladorPaciente {
    
    private final Json<Paciente> jsonHandler = new Json<>(
            "pacientes.json", new TypeToken<List<Paciente>>() {}.getType());
    private final List<Paciente> pacientes;

    public ControladorPaciente() {
        this.pacientes = jsonHandler.readData();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        jsonHandler.writeData(pacientes);
    }

    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    public void actualizarPaciente(String nombre, Paciente pacienteActualizado) {
        for (Paciente p : pacientes) {
            if (p.getNombrePaciente().equals(nombre)) {
                p.setEdadPaciente(pacienteActualizado.getEdadPaciente());
                p.setDiagnostico(pacienteActualizado.getDiagnostico());
                jsonHandler.writeData(pacientes);
                break;
            }
        }
    }

    public void eliminarPaciente(String nombre) {
        pacientes.removeIf(p -> p.getNombrePaciente().equals(nombre));
        jsonHandler.writeData(pacientes);
    }
    
}
