/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import libreria.daos.AutorDao;
import libreria.daos.EditorialDao;
import libreria.daos.LibroDao;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author Marcos
 */
public class LibroServicio {
    
    LibroDao ld = new LibroDao();
    AutorDao ad = new AutorDao();
    EditorialDao ed = new EditorialDao();
    
    public void crear(Libro libro) throws Exception  {
        try {
            
            if (libro.getAutor() != null) {
                
                if(libro.getAutor().getId() != null){
                    Autor autorbd = ad.buscarPorId(libro.getAutor().getId());
                    if( autorbd != null){
                        libro.setAutor(autorbd);
                    }else{
                        libro.setAutor(ad.crear(libro.getAutor()));
                    }
                }else{
                        libro.setAutor(ad.crear(libro.getAutor()));
                }
            }
            
            if (libro.getEditorial() != null) {
                
                if(libro.getEditorial().getId() != null){
                    Editorial editorialbd = ed.buscarPorId(libro.getEditorial().getId());
                    if( editorialbd != null){
                        libro.setEditorial(editorialbd);
                    }else{
                        libro.setEditorial(ed.crear(libro.getEditorial()));
                    }
                }else{
                     libro.setEditorial(ed.crear(libro.getEditorial()));
                }
            }
            
            ld.crear(libro);
            
        } catch (Exception e) {
            throw e;
        }

    }
    
    
    
}
