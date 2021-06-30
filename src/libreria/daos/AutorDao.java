
package libreria.daos;

import libreria.entidades.Autor;



/**
 *
 * @author Marcos
 */
public class AutorDao extends Dao {
    
     public Autor crear(Autor autor) throws Exception {
        
        try{
        entityManager.getTransaction().begin();
        entityManager.persist(autor);
        entityManager.getTransaction().commit();

        return autor;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Ocurrió un error al persistir el objeto", e);
        }
    }
     
     public void modificar(Autor autor) throws Exception{
      try{
           entityManager.getTransaction().begin();
           entityManager.merge(autor);
           entityManager.getTransaction().commit();
      }catch(Exception e){
          System.out.println(e.getMessage());
          throw new Exception("Error al modificar el autor");
      }
    }
     
     public void eliminar(Autor autor) throws Exception{
      try{
           entityManager.getTransaction().begin();
           entityManager.merge(autor);
           entityManager.getTransaction().commit();
      }catch(Exception e){
          System.out.println(e.getMessage());
          throw new Exception("Error al modificar el autor");
      }
    }
     
     public Autor buscarPorId(Long id){
         return entityManager.find(Autor.class, id);
     }
}
