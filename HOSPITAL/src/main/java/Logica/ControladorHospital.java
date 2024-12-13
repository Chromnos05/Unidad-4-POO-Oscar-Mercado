/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Hospital;
import Datos.Json;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class ControladorHospital {
    
    private final Json<Hospital> jsonHandler = new Json<>(
            "hospitales.json", new TypeToken<List<Hospital>>() {}.getType());
    private final List<Hospital> hospitales;

    public ControladorHospital() {
        this.hospitales = jsonHandler.readData();
    }

    public void agregarHospital(Hospital hospital) {
        hospitales.add(hospital);
        jsonHandler.writeData(hospitales);
    }

    public List<Hospital> obtenerHospitales() {
        return hospitales;
    }

    public void actualizarHospital(String nombre, Hospital hospitalActualizado) {
        for (Hospital h : hospitales) {
            if (h.getNombreHospital().equals(nombre)) {
                h.setUbicacionHospital(hospitalActualizado.getUbicacionHospital());
                h.setNumeroCamas(hospitalActualizado.getNumeroCamas());
                jsonHandler.writeData(hospitales);
                break;
            }
        }
    }

    public void eliminarHospital(String nombre) {
        hospitales.removeIf(h -> h.getNombreHospital().equals(nombre));
        jsonHandler.writeData(hospitales);
    }
    
}
