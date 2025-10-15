package br.edu.ifpb;

import br.edu.ifpb.dao.ClienteDAO;
import br.edu.ifpb.dao.PedidoDAO;
import br.edu.ifpb.entities.Cliente;
import br.edu.ifpb.entities.Pedido;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Cliente cliente = new Cliente();
//        cliente.setEndereco("Rua Natanel Barbosa");
//        cliente.setNome("João Gabriel");
//        cliente.setTelefone(87654599);

//        ClienteDAO dao = new ClienteDAO();
//        dao.save(cliente);
//        System.out.println("id cliente: " + cliente.getId());
//        dao.delete(5);
//        dao.listAll();
//        cliente.setNome("abobora com leite");
//        dao.update(cliente);
//        dao.listAll();
//        Pedido pedido = new Pedido();
//        pedido.setStatus("em preparo");
//        pedido.setFormaDePagamento("cartão de credito");
//        pedido.setValorFinal(30.00);
        PedidoDAO dao1 = new PedidoDAO();
        dao1.listAll();
//        dao1.delete(2);
//        System.out.println("id pedido: " + pedido.getId());
//        pedido.setStatus("para retirada");
//        pedido.setFormaDePagamento("cartão de debito");
//        pedido.setValorFinal(100.50);
//        dao1.update(pedido);
    }
}
