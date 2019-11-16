package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author g3ra1d0
 */
public class ClienteDAO {

    public void inserir(Cliente prod) {
        Connection conexao = FabricaConexao.GeraConexao();

//        Statement st;
//        st.execute("SQL ");
        String sql = "insert into cliente( nome, idade, sexo) values (?, ?, ?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, prod.getNome());
            pst.setInt(2, prod.getIdade());
            pst.setString(3, prod.getSexo());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }

    }

    public void update(Cliente prod) {
        Connection conexao = FabricaConexao.GeraConexao();

        String sql = "update cliente set nome = ? , idade = ?, sexo = ? where  id = ? ";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, prod.getNome());
            pst.setInt(2, prod.getIdade());
            pst.setString(3, prod.getSexo());
            pst.setInt(4, prod.getId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }

    }

    public boolean delete(int id) {
        String sql = "delete from cliente where id = ?";

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            boolean rs = pst.execute();

            return rs;

        } catch (SQLException ex) {

            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());

        }
        return false;

    }

    public Cliente select(int id) {
        String sql = "select * from cliente where id = ?";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet Resultado = pst.executeQuery();
            Cliente prod = new Cliente();

            if (Resultado.next()) {

                prod.setId(Resultado.getInt("id"));
                prod.setNome(Resultado.getString("nome"));
                prod.setIdade(Resultado.getInt("idade"));
                prod.setSexo(Resultado.getString("sexo"));

                return prod;
            } else {
                prod.setId(0);
                prod.setNome("");
                prod.setIdade(0);
                prod.setSexo("");
                return prod;
            }
        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public ArrayList<Cliente> selectWhere(String[] valores) {

        String sql = "select * from cliente where ID = ?";
        if (valores[0] == "Preco") {
            sql = "select * from cliente where idade = ?";
        } else if (valores[0] == "Nome") {
            sql = "select * from Cliente where nome = ? ";
        } else if (valores[0] == "Unidade") {
            sql = "select * from Cliente where sexo = ? ";

        }

        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, valores[1]);

            ResultSet Resultado = pst.executeQuery();
            ArrayList<Cliente> lista = new ArrayList<>();

            if (Resultado.next()) {
                do {
                    Cliente prod = new Cliente();
                    prod.setId(Resultado.getInt("id"));
                    prod.setNome(Resultado.getString("nome"));
                    prod.setIdade(Resultado.getInt("idade"));
                    prod.setSexo(Resultado.getString("sexo"));

                    lista.add(prod);
                } while (Resultado.next());

                return lista;

            } else {
                return lista;
            }
        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public Cliente selectUltimo() {
        String sql = "select * from cliente where id = (select  MAX(id) from cliente) ";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();
            Cliente prod = new Cliente();

            if (Resultado.next()) {

                prod.setId(Resultado.getInt("id"));
                prod.setNome(Resultado.getString("nome"));
                prod.setIdade(Resultado.getInt("idade"));
                prod.setSexo(Resultado.getString("sexo"));

                return prod;
            } else {
                prod.setId(0);
                prod.setNome("");
                prod.setIdade(0);
                prod.setSexo("");

                return prod;
            }
        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public ArrayList<Cliente> selectAll() {
        String sql = "select * from cliente";

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            PreparedStatement pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();

            ArrayList<Cliente> lista = new ArrayList<>();

            while (Resultado.next()) {
                Cliente prod = new Cliente();

                prod.setId(Resultado.getInt("id"));
                prod.setNome(Resultado.getString("nome"));
                prod.setIdade(Resultado.getInt("idade"));
                prod.setSexo(Resultado.getString("sexo"));

                lista.add(prod);
            }

            return lista;

        } catch (SQLException ex) {

            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());

        }
        return null;
    }

}
