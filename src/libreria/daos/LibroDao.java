
package libreria.daos;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author Marcos
 */
public class LibroDao extends Dao {

    public Libro crear(Libro libro) throws Exception {

        try { // Inicia la transacción con mysql
            entityManager.getTransaction().begin(); // begin es el conectarse
            // Persistir el objeto
            entityManager.persist(libro); // va a persistir mi objeto, el libro en este caso
            // Ejecutar la transaccion
            entityManager.getTransaction().commit();
            return libro;
        } catch (Exception e) {
            if(entityManager.isOpen()){
                entityManager.getTransaction().rollback();
            }
            
            throw new Exception("Ocurrió un error al persistir el objeto", e);
        }

    }

    public void modificar(Libro libro) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(libro); // merge() es el metodo del entityManager para modificar un objeto
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar el libro");
        }
    }

    public void eliminar(Libro libro) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(libro); // merge() es el metodo del entityManager para modificar un objeto
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar el libro");
        }
    }

    public void eliminarPorId(Long id) throws Exception { // los metodos de eliminar siempre son void, porque si voy a eliminar un objeto no me va a devolver nada
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(id); // merge() es el metodo del entityManager para modificar un objeto
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar el libro");
        }
    }
    
     public Libro buscarPorIsbn(Long isbn){
         return entityManager.find(Libro.class, isbn);
     }

  

    public List<Libro> traerLibros() {
        // JPQL --> Java Persistance Query Languaje(Lenguaje con el que trabaja JPA para realizar las querys)
        return entityManager.createQuery("SELECT l FROM Libro l").getResultList();
    }

    public Libro traerLibroPorTitulo(String titulo) {
        return (Libro) entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo")
                .setParameter("titulo", titulo)
                .getSingleResult();
    }

}
