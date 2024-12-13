/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author Oscar Mercado
 */
public class Paciente {
    
    private String nombrePaciente;
    private int edadPaciente;
    private String diagnostico;

    public Paciente(String nombrePaciente, int edadPaciente, String diagnostico) {
        this.nombrePaciente = nombrePaciente;
        this.edadPaciente = edadPaciente;
        this.diagnostico = diagnostico;
    }

    // Getters y Setters
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
}
