/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pedido;

/**
 *
 * @author g3ra1d0
 */
public class PedidoDAO {

    public int inserir(Pedido ped) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "insert into pedido( cliente_id, vendedor_id, data) values (?, ?, ?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            Date data = new Date(System.currentTimeMillis());
            pst.setInt(1, ped.getCliente_id());
            pst.setInt(2, ped.getVendedor_id());
            pst.setString(3, String.valueOf(data));
            pst.execute();

            sql = "select  MAX(id) as id  from pedido";
            PreparedStatement pstId = conexao.prepareStatement(sql);
            ResultSet Resultado = pstId.executeQuery();
            Resultado.next();
            return Resultado.getInt("id");

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
        return 0;
    }

    public boolean inserirProduto(String[] vetor) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "insert into pedido_produtos ( pedido_id, produto_id, valorUnitario, quantidade) values (?, ?, ?, ?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(vetor[0]));
            pst.setInt(2, Integer.parseInt(vetor[1]));
            pst.setDouble(3, Double.parseDouble(vetor[2]));
            pst.setInt(4, Integer.parseInt(vetor[3]));
            return pst.execute();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
        return false;
    }

    public Pedido selectPedido(String text) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "select cliente_id, vendedor_id, data from pedido where id = ?";
        Pedido ped = new Pedido();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(text));

            ResultSet Resultado = pst.executeQuery();
            if (Resultado.next()) {
                ped.setId(Integer.parseInt(text));
                ped.setCliente_id(Resultado.getInt("cliente_id"));
                ped.setVendedor_id(Resultado.getInt("vendedor_id"));
                ped.setData(Resultado.getString("data"));
                return ped;
            } else {
                ped.setId(0);
                return ped;
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
            ped.setId(0);
            return ped;
        }
    }

    public ArrayList<String[]> selectProdutos(String text) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "select p.id , p.nome,  p.unidade , pd.valorUnitario, pd.quantidade from pedido_produtos pd inner join produto p on p.id = pd.produto_id where pd.pedido_id = ?";
        ArrayList<String[]> array = new ArrayList<String[]>();
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(text));

            ResultSet Resultado = pst.executeQuery();
            while (Resultado.next()) {
                String[] vetor = new String[5];
                vetor[0] = Resultado.getString("p.id");
                vetor[1] = Resultado.getString("p.nome");
                vetor[2] = Resultado.getString("p.unidade");
                vetor[3] = String.valueOf(Resultado.getDouble("pd.valorUnitario"));
                vetor[4] = String.valueOf(Resultado.getInt("pd.quantidade"));
                array.add(vetor);

            }
            return array;

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
            return array;
        }
    }

    public boolean deleteProdutoPedido(int pedido, int produto) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "delete from pedido_produtos where pedido_id = ? and produto_id = ?";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pedido);
            pst.setInt(2, produto);

            return pst.execute();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteProdutoPedido(int pedido) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "delete from pedido where id = ?";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pedido);
            return pst.execute();

        } catch (SQLException ex) {
            return false;
        }
    }

    public void updateProdutoPedido(String[] vetor) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "update pedido_produtos set quantidade = ? where pedido_id = ? and produto_id = ?";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(vetor[0]));
            pst.setInt(2, Integer.parseInt(vetor[1]));
            pst.setInt(3, Integer.parseInt(vetor[2]));
            pst.execute();

        } catch (SQLException ex) {
        }
    }
}
