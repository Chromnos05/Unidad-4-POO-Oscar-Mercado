/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author Oscar Mercado
 */
public class Hospital {
    
    private String nombreHospital;
    private String ubicacionHospital;
    private int numeroCamas;

    public Hospital(String nombreHospital, String ubicacionHospital, int numeroCamas) {
        this.nombreHospital = nombreHospital;
        this.ubicacionHospital = ubicacionHospital;
        this.numeroCamas = numeroCamas;
    }

    // Getters y Setters
    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getUbicacionHospital() {
        return ubicacionHospital;
    }

    public void setUbicacionHospital(String ubicacionHospital) {
        this.ubicacionHospital = ubicacionHospital;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }
    
}
