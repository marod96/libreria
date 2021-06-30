/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.List;
import libreria.daos.AutorDao;
import libreria.daos.LibroDao;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.LibroServicio;

/**
 *
 * @author Marcos
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
           
           LibroServicio ls = new LibroServicio();
           LibroDao ld = new LibroDao();
           ls.crear(new Libro(1234L,"Harry Potter 1", 2001,23,15,new Autor("JK Rowling"),new Editorial("Planeta")));
            System.out.println(ld.buscarPorIsbn(1234L));
           // System.out.println(ld.traerLibroPorTitulo("Diablo").toString());
           // Libro l1 = ld.crear(new Libro(123L,"Diablo",2018,20,13));
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: "+e.getMessage());
        }
        
    }
    
   
}
