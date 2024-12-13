/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Interface;

import javax.swing.*;

/**
 *
 * @author Oscar Mercado
 */
public class SistemaHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        mostrarMenuPrincipal();
        
    }
    
    /**
     * Muestra el menú principal del sistema, permitiendo al usuario acceder
     * a las opciones de gestión de hospitales, doctores y pacientes.
     */
    
    public static void mostrarMenuPrincipal() {
        String[] opciones = {"Gestión de Hospitales", "Gestión de Doctores", "Gestión de Pacientes", "Salir"};
        int eleccion;

        do {
            // Presenta un cuadro de diálogo con las opciones principales
            eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Sistema Hospitalario",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0 -> {
                    HospitalUI hospitalUI = new HospitalUI();
                    hospitalUI.mostrarMenu();
                }
                case 1 -> {
                    DoctorUI doctorUI = new DoctorUI();
                    doctorUI.mostrarMenu();
                }
                case 2 -> {
                    PacienteUI pacienteUI = new PacienteUI();
                    pacienteUI.mostrarMenu();
                }
            }
        } while (eleccion != 3); // Repite hasta que el usuario elija salir

        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
    }
    
}
