/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Datos.Paciente;
import Logica.ControladorPaciente;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class PacienteUI {
    
    private final ControladorPaciente pacienteServicio = new ControladorPaciente();

    public void mostrarMenu() {
        String[] opciones = {"Crear Paciente", "Ver Pacientes", "Actualizar Paciente", "Eliminar Paciente", "Salir"};
        int eleccion;

        do {
            eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Pacientes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0 -> crearPaciente();
                case 1 -> verPacientes();
                case 2 -> actualizarPaciente();
                case 3 -> eliminarPaciente();
            }
        } while (eleccion != 4);
    }

    private void crearPaciente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente:"));
        String diagnostico = JOptionPane.showInputDialog("Ingrese el diagnóstico del paciente:");

        pacienteServicio.agregarPaciente(new Paciente(nombre, edad, diagnostico));
        JOptionPane.showMessageDialog(null, "Paciente creado con éxito.");
    }

    private void verPacientes() {
        List<Paciente> pacientes = pacienteServicio.obtenerPacientes();
        StringBuilder mensaje = new StringBuilder("Pacientes:\n");

        for (Paciente p : pacientes) {
            mensaje.append("Nombre: ").append(p.getNombrePaciente())
                    .append(", Edad: ").append(p.getEdadPaciente())
                    .append(", Diagnóstico: ").append(p.getDiagnostico()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void actualizarPaciente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente a actualizar:");
        int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad:"));
        String nuevoDiagnostico = JOptionPane.showInputDialog("Ingrese el nuevo diagnóstico:");

        pacienteServicio.actualizarPaciente(nombre, new Paciente(nombre, nuevaEdad, nuevoDiagnostico));
        JOptionPane.showMessageDialog(null, "Paciente actualizado con éxito.");
    }

    private void eliminarPaciente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente a eliminar:");
        pacienteServicio.eliminarPaciente(nombre);
        JOptionPane.showMessageDialog(null, "Paciente eliminado con éxito.");
    }
    
}
