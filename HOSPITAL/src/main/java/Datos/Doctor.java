/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author Oscar Mercado
 */
public class Doctor {
    
    private String nombreDoctor;
    private String especialidad;
    private int aniosExperiencia;

    public Doctor(String nombreDoctor, String especialidad, int aniosExperiencia) {
        this.nombreDoctor = nombreDoctor;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    // Getters y Setters
    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    
}
