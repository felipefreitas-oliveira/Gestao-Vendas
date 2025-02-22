package org.example.persistencias;

import jakarta.persistence.EntityManager;
import org.example.instancias.Cliente;
import org.example.instancias.Produto;

import java.util.List;

public class ProdutoDAO {

    public void salvar (Produto produto){
        EntityManager entityManager =JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Produto> listarProdutos(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Produto> produtos = entityManager.createQuery("Lista Produtos: ", Produto.class).getResultList();
        entityManager.close();
        return  produtos;
    }

    public Produto listarProtudoPorID(Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.close();
        return produto;
    }

    public void atualizar(Long id, Produto produto){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Produto buscarProduto = entityManager.find(Produto.class, id);

        if(buscarProduto != null){
            buscarProduto.setNome(buscarProduto.getNome());
            buscarProduto.setDescricao(buscarProduto.getDescricao());
            buscarProduto.setPreco(buscarProduto.getPreco());
            buscarProduto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
            entityManager.merge(buscarProduto);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
    }


}