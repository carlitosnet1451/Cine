/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.themoviedb;

import cl.modelos.Pelicula;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author carlo
 * Creado el 08-09-2020 a las 11:17:00
 */
public class Themoviedb {
 static String api_key="INGRESE SU API KEY";
 static String idioma="es-MX";
  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
public static void ImprimirJson(JSONObject json){
    System.out.println(json);
}
  public  static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    try (InputStream is = new URL(url).openStream()) {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    }
  }

public static ArrayList<Pelicula> Conseguir(String url) throws IOException, ParseException{
      JSONObject json = readJsonFromUrl(url);
     JSONArray jsonArray = json.getJSONArray("results");
     ArrayList<Pelicula>lista=new ArrayList();
    try{
     for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject pelicula=jsonArray.getJSONObject(i);
       try{
           Pelicula peli=DeJsonAPelicula(pelicula);
           
     
       if(peli!=null){
       lista.add(peli);
       }
       }catch(Exception e){
        System.out.println("Una pelicula no pudo ingresar:"+e);
        
        }
        
          
    }}catch(Exception e){
        System.out.println("Una pelicula no pudo ingresar:"+e);
    
    }
    return lista; 
 }
 static Pelicula  DeJsonAPelicula(JSONObject pelicula) throws ParseException, ParseException{
 try{Pelicula peli=new Pelicula();
        peli.setId_Pelicula(pelicula.getInt("id"));
        peli.setTitulo(pelicula.getString("title"));

        String input = pelicula.getString("release_date");
     
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date date = parser.parse(input);
        peli.setFecha_Lanzamiento(date);

 return peli;
 }catch(Exception e){
        System.out.println("Ha habido un error"+e);
        return null;}
 }
 
     
 

public static Pelicula ConseguirPelicula(int id) throws IOException{
String url=ConseguirId(id);
JSONObject json = readJsonFromUrl(url);    
try{
Pelicula peli=DeJsonAPelicula(json);
return peli;
}   catch(Exception e){
    System.out.println("Ha habido un error");
    return null;
}
    
}

public static int PaginasTotales(String url) throws IOException{
      JSONObject json = readJsonFromUrl(url);
int x=json.getInt("total_pages");
    
return x;
}

public static String DescubrirPeliculas(int pagina){
 String url="https://api.themoviedb.org/3/discover/movie?api_key="+api_key+"&language="+idioma+"&page="+pagina;
    
    
    
    return url;
}
public static String ConseguirNombre(String nombre,int pagina){
String url=" https://api.themoviedb.org/3/search/movie?api_key="+api_key+"&language="+idioma+"&query="+nombre+"&page="+pagina;
    
return url;
}
public static String ConseguirId(int id){
String url=" https://api.themoviedb.org/3/movie/"+id+"?api_key="+api_key+"&language="+idioma;
return url;
}
}
