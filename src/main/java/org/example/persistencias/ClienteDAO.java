package org.example.persistencias;

import jakarta.persistence.EntityManager;
import org.example.instancias.Cliente;
import org.example.instancias.Produto;

import java.util.List;

public class ClienteDAO {

    public void salvar (Cliente cliente){
        EntityManager entityManager =JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Cliente> listarClientes(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Cliente> clientes = entityManager.createQuery("Lista Clientes: ", Cliente.class).getResultList();
        entityManager.close();
        return clientes;
    }

    public Cliente listarClientePorID(Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.close();
        return cliente;
    }

    public void atualizar(Long id, Cliente cliente){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Cliente buscarCliente = entityManager.find(Cliente.class, id);

        if(buscarCliente != null){
            buscarCliente.setNome(cliente.getNome());
            buscarCliente.setEmail(cliente.getEmail());
            buscarCliente.setEndereco(cliente.getEndereco());
            entityManager.merge(buscarCliente);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
    }

}
