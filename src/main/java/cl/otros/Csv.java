/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.otros;

import cl.modelos.Pelicula;
import cl.modelos.Vista;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 * Creado el 08-09-2020 a las 22:31:37
 */
public class Csv {
static String ruta_peliculas="C:\\csvs\\Peliculas.csv";
static String ruta_vistas="C:\\csvs\\Vista.csv";
ArrayList<String[]>csv_peliculas=new ArrayList();
ArrayList<String[]>csv_vistas=new ArrayList();

public void Guardar() throws IOException {
CSVWriter writer_peliculas = new CSVWriter(new FileWriter(ruta_peliculas));
CSVWriter writer_vistas = new CSVWriter(new FileWriter(ruta_vistas));
writer_peliculas.writeAll(csv_peliculas);
writer_vistas.writeAll(csv_vistas);
writer_peliculas.close();
writer_vistas.close();
}

public void ImprimirListaPeliculas(){
    for (int i = 0; i < csv_peliculas.size(); i++) {
String[] pelicula=csv_peliculas.get(i);
String lista="";
        for (int j = 0; j < pelicula.length; j++) {
            lista=lista+pelicula[j]+",";
        }
        System.out.println(lista);
    }



}
public void Iniciar() throws IOException, FileNotFoundException, CsvException{

String []parametros_peliculas={"id_pelicula","titulo","fecha_lanzamiento"};
String []parametros_vista={"id_pelicula, fecha_vista,valorizacion"};
csv_peliculas.add(parametros_peliculas);
csv_vistas.add(parametros_vista);
Guardar();


}
public void AñadirPelicula(Pelicula pelicula) throws IOException, FileNotFoundException, CsvException{

String []parametros_peliculas={String.valueOf(pelicula.getId_Pelicula()),pelicula.getTitulo(),pelicula.getFecha_Lanzamiento().toString()};
csv_peliculas.add(parametros_peliculas);
Guardar();


}
public void AñadirVista(Vista vista) throws IOException, FileNotFoundException, CsvException{

String []parametros_vista={String.valueOf(vista.getPelicula().getId_Pelicula()),vista.getFecha_Vista().toString(),String.valueOf(vista.getValorizacion())};
csv_vistas.add(parametros_vista);
Guardar();


}


}
