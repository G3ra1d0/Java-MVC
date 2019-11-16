/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PedidoDAO;
import model.Pedido;

/**
 *
 * @author g3ra1d0
 */
public class PedidoControle {
    public Boolean insert(String[] vetor){
        PedidoDAO DAO = new PedidoDAO();
        Pedido ped = new Pedido();
        ped.setCliente_id(Integer.parseInt(vetor[0]));
        ped.setVendedor_id(Integer.parseInt(vetor[1]));
        ped.setProduto_id(Integer.parseInt(vetor[2]));
        return DAO.inserir(ped);
    }
}
