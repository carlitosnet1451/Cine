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
 * Creado el 08-09-2020 a las 22:29:40
 */
public class Vista {

Pelicula Pelicula;
Date Fecha_Vista;
int Valorizacion;

    public Vista() {
    }

    public Vista(Pelicula Pelicula, Date Fecha_Vista, int Valorizacion) {
   
        this.Pelicula = Pelicula;
        this.Fecha_Vista = Fecha_Vista;
        this.Valorizacion = Valorizacion;
    }

   

    public Pelicula getPelicula() {
        return Pelicula;
    }

    public void setPelicula(Pelicula Pelicula) {
        this.Pelicula = Pelicula;
    }

    public Date getFecha_Vista() {
        return Fecha_Vista;
    }

    public void setFecha_Vista(Date Fecha_Vista) {
        this.Fecha_Vista = Fecha_Vista;
    }

    public int getValorizacion() {
        return Valorizacion;
    }

    public void setValorizacion(int Valorizacion) {
        this.Valorizacion = Valorizacion;
    }


}
