package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Vendedor;

/**
 *
 * @author g3ra1d0
 */
public class VendedorDAO {

    public void inserir(Vendedor prod) {
        Connection conexao = FabricaConexao.GeraConexao();

//        Statement st;
//        st.execute("SQL ");
        String sql = "insert into vendedor( nome, idade, sexo) values (?, ?, ?)";

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

    public void update(Vendedor prod) {
        Connection conexao = FabricaConexao.GeraConexao();

        String sql = "update vendedor set nome = ? , idade = ?, sexo = ? where  id = ? ";
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
        String sql = "delete from vendedor where id = ?";

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

    public Vendedor select(int id) {
        String sql = "select * from vendedor where id = ?";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet Resultado = pst.executeQuery();
            Vendedor prod = new Vendedor();

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

    public ArrayList<Vendedor> selectWhere(String[] valores) {

        String sql = "select * from vendedor where ID = ?";
        if (valores[0] == "Preco") {
            sql = "select * from vendedor where idade = ?";
        } else if (valores[0] == "Nome") {
            sql = "select * from vendedor where nome = ? ";
        } else if (valores[0] == "Unidade") {
            sql = "select * from vendedor where sexo = ? ";

        }

        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, valores[1]);

            ResultSet Resultado = pst.executeQuery();
            ArrayList<Vendedor> lista = new ArrayList<>();

            if (Resultado.next()) {
                do {
                    Vendedor prod = new Vendedor();
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

    public Vendedor selectUltimo() {
        String sql = "select * from vendedor where id = (select  MAX(id) from vendedor) ";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();
            Vendedor prod = new Vendedor();

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

    public ArrayList<Vendedor> selectAll() {
        String sql = "select * from vendedor";

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            PreparedStatement pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();

            ArrayList<Vendedor> lista = new ArrayList<>();

            while (Resultado.next()) {
                Vendedor prod = new Vendedor();

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
