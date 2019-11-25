/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PedidoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pedido;
import model.Produto;

/**
 *
 * @author g3ra1d0
 */
public class PedidoControle {

    public int insert(String[] vetor) {
        PedidoDAO DAO = new PedidoDAO();
        Pedido ped = new Pedido();
        ped.setCliente_id(Integer.parseInt(vetor[0]));
        ped.setVendedor_id(Integer.parseInt(vetor[1]));
        return DAO.inserir(ped);
    }

    public void insertProduto(String[] pedidos) {
        PedidoDAO DAO = new PedidoDAO();
        DAO.inserirProduto(pedidos);
    }

    public String[] selectPedido(String text) {
        Pedido ped = new Pedido();
        PedidoDAO DAO = new PedidoDAO();
        ped = DAO.selectPedido(text);
        String[] vetor = new String[4];
        vetor[0] = String.valueOf(ped.getId());
        vetor[1] = String.valueOf(ped.getCliente_id());
        vetor[2] = String.valueOf(ped.getVendedor_id());
        vetor[3] = ped.getData();
        return vetor;
    }

    public ArrayList<String[]> selectProduto(String text) {
        PedidoDAO DAO = new PedidoDAO();
        ArrayList<String[]> array = new ArrayList<String[]>();
        array = DAO.selectProdutos(text);
        return array;
    }

    public boolean deleteProdutoPedido(int pedido, int produto) {
        PedidoDAO DAO = new PedidoDAO();
        return DAO.deleteProdutoPedido(pedido, produto);
    }

    public boolean deletePedido(int pedido) {
        PedidoDAO DAO = new PedidoDAO();
        return DAO.deleteProdutoPedido(pedido);
    }

    public void updateProdutoPedido(String[] vetor) {
        PedidoDAO DAO = new PedidoDAO();
        DAO.updateProdutoPedido(vetor);
    }
}
