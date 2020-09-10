/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.otros;

import cl.modelos.Pelicula;
import cl.themoviedb.Themoviedb;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Principal {
static Scanner teclado=new Scanner(System.in);
static Csv csv=new Csv();
static Themoviedb peliculas=new Themoviedb();

/**
     * @param args the command line arguments
     */
    public  static void main(String[] args) throws IOException, ParseException, FileNotFoundException, CsvException {
Iniciar();
    }

    private static void Iniciar() throws IOException, ParseException, FileNotFoundException, CsvException {
csv.Iniciar();
        boolean adentro=true;
        while(adentro==true){
        System.out.println("Bienvenido al gestor de peliculas y vistas");
        System.out.println("Pulse 1 para agregar una pelicula");
        System.out.println("Pulse 2 para ver una pelicula");
        System.out.println("Pulse 0 para salir");
    int opcion=teclado.nextInt();
    switch(opcion){
        case 0:
            adentro=false;
            break;
        case 1:
            GestorPeliculas();
            break;
        case 2:
            GestorVistas();
            break;
    
    }
        
        
        }
    
    
    }

    private static void GestorPeliculas() throws IOException, ParseException, FileNotFoundException, CsvException {
               boolean adentro=true;
        while(adentro==true){
        System.out.println("Bienvenido a el gestor de peliculas");
        System.out.println("Ingrese 0 para salir");
        System.out.println("Ingrese 1 para buscar una pelicula por nombre");
            System.out.println("Ingrese 2 para imprimir la lista de peliculas");
    int opcion=teclado.nextInt();
    switch(opcion){
        case 0:
            adentro=false;
            break;
        case 1:
          BuscarPeliculasNombre();
            break;
        case 2:
            csv.ImprimirListaPeliculas();
            System.out.println("Liste de peliculas impresa");
            break;
    
    }

        


        }}

    private static void GestorVistas() {


    }

    private static void BuscarPeliculasNombre() throws IOException, ParseException, FileNotFoundException, CsvException {
       
        System.out.println("Bienvenido al buscador de peliculas por nombre");
        System.out.println("Ingrese el nombre");
String nombre=teclado.next();
boolean adentro=true;
int paginas_totales=peliculas.PaginasTotales(peliculas.ConseguirNombre(nombre, 1));

int numero_pagina=0;
do{
numero_pagina+=1;
ArrayList<Pelicula>lista=peliculas.Conseguir(peliculas.ConseguirNombre(nombre, numero_pagina));
    for (int i = 1; i <= lista.size(); i++) {
        Pelicula peli=lista.get(i-1);
        System.out.println(i+":"+peli.getTitulo());
        
        
    }
    System.out.println("Ingrese el index de un numero,0 o un numero positivo fuera del index para avanzar pagina o un numero negativo para salir");
    int opcion=teclado.nextInt();
   if(opcion<0){
   adentro=false;
   }else if(opcion>lista.size()||opcion==0){
       System.out.println("Pase de pagina");
   }else{
       Pelicula peli=lista.get(opcion-1);
       System.out.println("Pelicula "+peli.getTitulo()+" seleccionada");
       csv.AñadirPelicula(peli);
   adentro=false;
   }    
  
}while(adentro==true&& numero_pagina<=paginas_totales);


    }
    
}
