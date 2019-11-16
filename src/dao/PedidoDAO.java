/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pedido;

/**
 *
 * @author g3ra1d0
 */
public class PedidoDAO {

    public boolean inserir(Pedido ped) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "insert into pedido( cliente_id, vendedor_id, produto_id) values (?, ?, ?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, ped.getCliente_id());
            pst.setInt(2, ped.getVendedor_id());
            pst.setInt(3, ped.getProduto_id());

            return pst.execute();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
            return false;
        }
    }
}
