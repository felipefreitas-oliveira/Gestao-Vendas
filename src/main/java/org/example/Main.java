package org.example;

import org.example.instancias.Cliente;
import org.example.instancias.Produto;
import org.example.instancias.Venda;
import org.example.persistencias.ClienteDAO;
import org.example.persistencias.ProdutoDAO;
import org.example.persistencias.VendaDAO;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setNome("Manga");
        produto.setDescricao("Bem docinha");
        produto.setPreco(5.50);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto);

        Cliente cliente = new Cliente();
        cliente.setNome("Felipe");
        cliente.setEndereco("Rua A");
        cliente.setEmail("teste@teste.com");

        ClienteDAO clienteDAO = new ClienteDAO();

        clienteDAO.salvar(cliente);


        //Venda venda = new Venda();

//        VendaDAO vendaDAO = new VendaDAO();
//        Venda vendaExistente = vendaDAO.listarVendaPorID(1L);
//        System.out.println("Venda: Cliente ", + vendaExistente.getCliente());
//        System.out.println("Venda: Valor ", + vendaExistente.getTotal());
    }
}