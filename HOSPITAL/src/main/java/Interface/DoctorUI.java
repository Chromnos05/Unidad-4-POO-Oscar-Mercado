/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Datos.Doctor;
import Logica.ControladorDoctor;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class DoctorUI {
    
    private final ControladorDoctor doctorServicio = new ControladorDoctor();

    public void mostrarMenu() {
        String[] opciones = {"Crear Doctor", "Ver Doctores", "Actualizar Doctor", "Eliminar Doctor", "Salir"};
        int eleccion;

        do {
            eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Doctores",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0 -> crearDoctor();
                case 1 -> verDoctores();
                case 2 -> actualizarDoctor();
                case 3 -> eliminarDoctor();
            }
        } while (eleccion != 4);
    }

    private void crearDoctor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del doctor:");
        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del doctor:");
        int experiencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los años de experiencia:"));

        doctorServicio.agregarDoctor(new Doctor(nombre, especialidad, experiencia));
        JOptionPane.showMessageDialog(null, "Doctor creado con éxito.");
    }

    private void verDoctores() {
        List<Doctor> doctores = doctorServicio.obtenerDoctores();
        StringBuilder mensaje = new StringBuilder("Doctores:\n");

        for (Doctor d : doctores) {
            mensaje.append("Nombre: ").append(d.getNombreDoctor())
                    .append(", Especialidad: ").append(d.getEspecialidad())
                    .append(", Años de Experiencia: ").append(d.getAniosExperiencia()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void actualizarDoctor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del doctor a actualizar:");
        String nuevaEspecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad:");
        int nuevaExperiencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los nuevos años de experiencia:"));

        doctorServicio.actualizarDoctor(nombre, new Doctor(nombre, nuevaEspecialidad, nuevaExperiencia));
        JOptionPane.showMessageDialog(null, "Doctor actualizado con éxito.");
    }

    private void eliminarDoctor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del doctor a eliminar:");
        doctorServicio.eliminarDoctor(nombre);
        JOptionPane.showMessageDialog(null, "Doctor eliminado con éxito.");
    }
    
}
