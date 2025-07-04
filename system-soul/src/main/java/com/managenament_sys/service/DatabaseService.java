package com.managenament_sys.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import com.managenament_sys.Usuario;
import com.managenament_sys.Produto;
import com.managenament_sys.Vendas;
import com.managenament_sys.Gastos;

import java.util.List;

public class DatabaseService {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static void initialize() {
        emf = Persistence.createEntityManagerFactory("system-soul");
        em = emf.createEntityManager();
    }
    
    public static void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
    
    // Usuario operations
    public static void saveUsuario(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
    
    public static List<Usuario> getAllUsuarios() {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }
    
    public static Usuario findUsuarioByEmail(String email) {
        TypedQuery<Usuario> query = em.createQuery(
            "SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
    
    // Produto operations
    public static void saveProduto(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }
    
    public static List<Produto> getAllProdutos() {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }
    
    // Vendas operations
    public static void saveVenda(Vendas venda) {
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }
    
    public static List<Vendas> getAllVendas() {
        TypedQuery<Vendas> query = em.createQuery("SELECT v FROM Vendas v", Vendas.class);
        return query.getResultList();
    }
    
    // Gastos operations
    public static void saveGasto(Gastos gasto) {
        em.getTransaction().begin();
        em.persist(gasto);
        em.getTransaction().commit();
    }
    
    public static List<Gastos> getAllGastos() {
        TypedQuery<Gastos> query = em.createQuery("SELECT g FROM Gastos g", Gastos.class);
        return query.getResultList();
    }
} 