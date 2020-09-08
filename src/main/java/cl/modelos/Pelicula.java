/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.modelos;

import java.util.Date;

/**
 *
 * @author carlo
 * Creado el 08-09-2020 a las 11:20:26
 */
public class Pelicula {
int Id_Pelicula;
String Titulo;

Date Fecha_Lanzamiento;

    public Pelicula(int Id_Pelicula, String Titulo, Date Fecha_Lanzamiento) {
        this.Id_Pelicula = Id_Pelicula;
        this.Titulo = Titulo;
       
        this.Fecha_Lanzamiento = Fecha_Lanzamiento;
    }

    public Pelicula() {

    }

    public int getId_Pelicula() {
        return Id_Pelicula;
    }

    public void setId_Pelicula(int Id_Pelicula) {
        this.Id_Pelicula = Id_Pelicula;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

   
    public Date getFecha_Lanzamiento() {
        return Fecha_Lanzamiento;
    }

    public void setFecha_Lanzamiento(Date Fecha_Lanzamiento) {
        this.Fecha_Lanzamiento = Fecha_Lanzamiento;
    }

}
