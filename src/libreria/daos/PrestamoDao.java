/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.daos;

import libreria.entidades.Prestamo;

/**
 *
 * @author Marcos
 */
public class PrestamoDao extends Dao{
    
        public Prestamo crear(Prestamo prestamo) throws Exception {

        try { // Inicia la transacción con mysql
            entityManager.getTransaction().begin(); // begin es el conectarse
            // Persistir el objeto
            entityManager.persist(prestamo); // va a persistir mi objeto, el libro en este caso
            // Ejecutar la transaccion
            entityManager.getTransaction().commit();
            return prestamo;
        } catch (Exception e) {
            if(entityManager.isOpen()){
                entityManager.getTransaction().rollback();
            }
            
            throw new Exception("Ocurrió un error al persistir el objeto", e);
        }

    }

    public void modificar(Prestamo prestamo) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(prestamo); // merge() es el metodo del entityManager para modificar un objeto
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar el prestamo");
        }
    }

    public void eliminar(Prestamo prestamo) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(prestamo); // merge() es el metodo del entityManager para modificar un objeto
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar el prestamo");
        }
    }

    
}
