/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Datos.Hospital;
import Logica.ControladorHospital;
import Logica.ControladorHospital;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class HospitalUI {
    
    private final ControladorHospital hospitalServicio = new ControladorHospital();

    public void mostrarMenu() {
        String[] opciones = {"Crear Hospital", "Ver Hospitales", "Actualizar Hospital", "Eliminar Hospital", "Salir"};
        int eleccion;

        do {
            eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Hospitales",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0 -> crearHospital();
                case 1 -> verHospitales();
                case 2 -> actualizarHospital();
                case 3 -> eliminarHospital();
            }
        } while (eleccion != 4);
    }

    private void crearHospital() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del hospital:");
        String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del hospital:");
        int camas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de camas:"));

        hospitalServicio.agregarHospital(new Hospital(nombre, ubicacion, camas));
        JOptionPane.showMessageDialog(null, "Hospital creado con éxito.");
    }

    private void verHospitales() {
        List<Hospital> hospitales = hospitalServicio.obtenerHospitales();
        StringBuilder mensaje = new StringBuilder("Hospitales:\n");

        for (Hospital h : hospitales) {
            mensaje.append("Nombre: ").append(h.getNombreHospital())
                    .append(", Ubicación: ").append(h.getUbicacionHospital())
                    .append(", Camas: ").append(h.getNumeroCamas()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void actualizarHospital() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del hospital a actualizar:");
        String nuevaUbicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación:");
        int nuevasCamas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de camas:"));

        hospitalServicio.actualizarHospital(nombre, new Hospital(nombre, nuevaUbicacion, nuevasCamas));
        JOptionPane.showMessageDialog(null, "Hospital actualizado con éxito.");
    }

    private void eliminarHospital() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del hospital a eliminar:");
        hospitalServicio.eliminarHospital(nombre);
        JOptionPane.showMessageDialog(null, "Hospital eliminado con éxito.");
    }
    
}
