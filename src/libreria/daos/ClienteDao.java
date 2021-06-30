
package libreria.daos;

import libreria.entidades.Cliente;

/**
 *
 * @author Marcos
 */
public class ClienteDao extends Dao {

    public Cliente crear(Cliente cliente) throws Exception {
        
        try{
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        return cliente;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Ocurrió un error al persistir el objeto", e);
        }
    }
    
    public void modificar(Cliente cliente) throws Exception{
      try{
           entityManager.getTransaction().begin();
           entityManager.merge(cliente);
           entityManager.getTransaction().commit();
      }catch(Exception e){
          System.out.println(e.getMessage());
          throw new Exception("Error al modificar el cliente");
      }
    }
    
      public void eliminar(Cliente cliente) throws Exception{
      try{
           entityManager.getTransaction().begin();
           entityManager.remove(cliente);
           entityManager.getTransaction().commit();
      }catch(Exception e){
          System.out.println(e.getMessage());
          throw new Exception("Error al eliminar el cliente");
      }
    }
}
