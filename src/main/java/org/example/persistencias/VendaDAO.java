package org.example.persistencias;

import jakarta.persistence.EntityManager;
import org.example.instancias.Cliente;
import org.example.instancias.Pagamento;
import org.example.instancias.Produto;
import org.example.instancias.Venda;

import javax.crypto.spec.PSource;

public class VendaDAO {
    public void salvar (Venda venda){
        EntityManager entityManager =JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(venda);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Venda listarVendaPorID(Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        Venda venda = entityManager.find(Venda.class, id);
        entityManager.close();
        return venda;
    }

}
