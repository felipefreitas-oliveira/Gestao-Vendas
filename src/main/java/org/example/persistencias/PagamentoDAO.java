package org.example.persistencias;

import jakarta.persistence.EntityManager;
import org.example.instancias.Cliente;
import org.example.instancias.Pagamento;

import java.util.List;

public class PagamentoDAO {

    public void salvar (Pagamento pagamento){
        EntityManager entityManager =JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pagamento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Pagamento> listarPagamentos(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Pagamento> pagamentos = entityManager.createQuery("Lista Pagamentos: ", Pagamento.class).getResultList();
        entityManager.close();
        return pagamentos;
    }
}
