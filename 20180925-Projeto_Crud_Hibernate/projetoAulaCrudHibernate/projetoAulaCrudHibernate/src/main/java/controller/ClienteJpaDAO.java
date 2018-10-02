package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class ClienteJpaDAO {
	private static ClienteJpaDAO instance;
    protected EntityManager entityManager;
    
    public static ClienteJpaDAO getInstance(){
              if (instance == null){
                       instance = new ClienteJpaDAO();
              }
              
              return instance;
    }

    private ClienteJpaDAO() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Cliente getByIdCliente(final int idCliente) {
              return entityManager.find(Cliente.class, idCliente);
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
              return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
    }

    public void persist(Cliente cliente) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(cliente);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Cliente cliente) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(cliente);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Cliente cliente) {
              try {
                       entityManager.getTransaction().begin();
                       cliente = entityManager.find(Cliente.class, cliente.getIdCliente());
                       entityManager.remove(cliente);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeByIdCliente(final int idCliente) {
              try {
                       Cliente cliente = getByIdCliente(idCliente);
                       remove(cliente);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
