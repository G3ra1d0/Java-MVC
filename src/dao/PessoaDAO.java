/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author g3ra1d0
 */
public class PessoaDAO {

    public void inserir(Pessoa pess) {
        Connection conexao = FabricaConexao.GeraConexao();

//        Statement st;
//        st.execute("SQL ");
        String sql = "insert into pessoa ( nome, sexo, idade, tipo, cpf ) values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, pess.getNome());
            pst.setString(2, pess.getSexo());
            pst.setInt(3, pess.getIdade());
            pst.setString(4, pess.getTipo());
            pst.setString(5, pess.getCpf());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }

    }

    public void update(Pessoa pess) {
        Connection conexao = FabricaConexao.GeraConexao();

        String sql = "update pessoa set nome = ? , sexo = ?, idade = ?, tipo = ? where  cpf = ? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, pess.getNome());
            pst.setString(2, pess.getSexo());
            pst.setInt(3, pess.getIdade());
            pst.setString(4, pess.getTipo());
            pst.setString(5, pess.getCpf());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }

    }

    public boolean delete(String cpf) {
        String sql = "delete from pessoa where cpf = ? ";

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            boolean rs = pst.execute();

            return rs;

        } catch (SQLException ex) {

            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());

        }
        return false;

    }

    public Pessoa select(String cpf) {
        String sql = "select * from pessoa where cpf = ?";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);

            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Pessoa pess = new Pessoa();

            pess.setCpf(Resultado.getString("cpf"));
            pess.setNome(Resultado.getString("nome"));
            pess.setSexo(Resultado.getString("sexo"));
            pess.setIdade(Resultado.getInt("idade"));
            pess.setTipo(Resultado.getString("tipo"));

            return pess;

        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public ArrayList<Pessoa> selectAll() {
        String sql = "select * from pessoa";

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            PreparedStatement pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();

            ArrayList<Pessoa> lista = new ArrayList<>();

            while (Resultado.next()) {
                Pessoa pess = new Pessoa();

                pess.setCpf(Resultado.getString("cpf"));
                pess.setNome(Resultado.getString("nome"));
                pess.setSexo(Resultado.getString("sexo"));
                pess.setIdade(Resultado.getInt("idade"));
                pess.setTipo(Resultado.getString("tipo"));

                lista.add(pess);
            }

            return lista;

        } catch (SQLException ex) {

            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());

        }
        return null;
    }

}
