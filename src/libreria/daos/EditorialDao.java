
package libreria.daos;

import libreria.entidades.Editorial;



/**
 *
 * @author Marcos
 */
public class EditorialDao extends Dao {
    
     public Editorial crear(Editorial editorial) throws Exception {
        
        try{
        entityManager.getTransaction().begin();
        entityManager.persist(editorial);
        entityManager.getTransaction().commit();

        return editorial;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Ocurrió un error al persistir el objeto", e);
        }
    }
     
     public void modificar(Editorial editorial) throws Exception{
      try{
           entityManager.getTransaction().begin();
           entityManager.merge(editorial);
           entityManager.getTransaction().commit();
      }catch(Exception e){
          System.out.println(e.getMessage());
          throw new Exception("Error al modificar la editorial");
      }
    }
     
     public void eliminar(Editorial editorial) throws Exception{
      try{
           entityManager.getTransaction().begin();
           entityManager.merge(editorial);
           entityManager.getTransaction().commit();
      }catch(Exception e){
          System.out.println(e.getMessage());
          throw new Exception("Error al eliminar la editorial");
      }
    }
     
       public Editorial buscarPorId(Long id){
         return entityManager.find(Editorial.class, id);
     }
    
}
