/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Mercado
 */
public class Json<T> {
    
    private final String archivoNombre;
    private final Type tipo;

    public Json(String archivoNombre, Type tipo) {
        this.archivoNombre = archivoNombre;
        this.tipo = tipo;
    }

    public List<T> readData() {
        try (Reader lector = new FileReader(archivoNombre)) {
            return new Gson().fromJson(lector, tipo);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Si no existe el archivo, retornar lista vacía.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeData(List<T> datos) {
        try (Writer escritor = new FileWriter(archivoNombre)) {
            new Gson().toJson(datos, escritor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
