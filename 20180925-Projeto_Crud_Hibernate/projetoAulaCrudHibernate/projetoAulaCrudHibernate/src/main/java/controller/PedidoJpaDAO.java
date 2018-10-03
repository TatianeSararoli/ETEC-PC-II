package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pedido;

public class PedidoJpaDAO {
	private static PedidoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static PedidoJpaDAO getInstance(){
              if (instance == null){
                       instance = new PedidoJpaDAO();
              }
              
              return instance;
    }

    private PedidoJpaDAO() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public Pedido getByIdPedido(final int idPedido) {
              return entityManager.find(Pedido.class, idPedido);
    }

    @SuppressWarnings("unchecked")
    public List<Pedido> findAll() {
              return entityManager.createQuery("FROM " + Pedido.class.getName()).getResultList();
    }

    public void persist(Pedido pedido) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(pedido);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(Pedido pedido) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(pedido);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(Pedido pedido) {
              try {
                       entityManager.getTransaction().begin();
                       pedido = entityManager.find(Pedido.class, pedido.getIdPedido());
                       entityManager.remove(pedido);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeByIdPedido(final int idPedido) {
              try {
            	  	   Pedido pedido = getByIdPedido(idPedido);
                       remove(pedido);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
