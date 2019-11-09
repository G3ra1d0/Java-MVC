package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author g3ra1d0
 */
public class ProdutoDAO {

    public void inserir(Produto prod) {
        Connection conexao = FabricaConexao.GeraConexao();

//        Statement st;
//        st.execute("SQL ");
        String sql = "insert into produto( nome, preco, unidade) values (?, ?, ?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, prod.getNome());
            pst.setDouble(2, prod.getPreco());
            pst.setString(3, prod.getUnidade());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }

    }

    public void update(Produto prod) {
        Connection conexao = FabricaConexao.GeraConexao();

        String sql = "update produto set nome = ? , preco = ?, unidade = ? where  id = ? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, prod.getNome());
            pst.setDouble(2, prod.getPreco());
            pst.setString(3, prod.getUnidade());
            pst.setInt(4, prod.getId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }

    }

    public boolean delete(int id) {
        String sql = "delete from produto where id = ?";

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

    public Produto select(int id) {
        String sql = "select * from produto where id = ?";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet Resultado = pst.executeQuery();
            Produto prod = new Produto();

            if (Resultado.next()) {

                prod.setId(Resultado.getInt("id"));
                prod.setNome(Resultado.getString("nome"));
                prod.setPreco(Resultado.getDouble("preco"));
                prod.setUnidade(Resultado.getString("unidade"));

                return prod;
            } else {
                prod.setId(0);
                prod.setNome("");
                prod.setPreco(0);
                prod.setUnidade("");
                return prod;
            }
        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public ArrayList<Produto> selectWhere(String[] valores) {

        String sql = "select * from produto where ID = ?";
        if (valores[0] == "Preco") {
            sql = "select * from produto where preco = ?";
        } else if (valores[0] == "Nome") {
            sql = "select * from produto where nome = ? ";
        } else if (valores[0] == "Unidade") {
            sql = "select * from produto where unidade = ? ";

        }

        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setString(1, valores[1]);

            ResultSet Resultado = pst.executeQuery();
            ArrayList<Produto> lista = new ArrayList<>();

            if (Resultado.next()) {
                do {
                    Produto prod = new Produto();
                    prod.setId(Resultado.getInt("id"));
                    prod.setNome(Resultado.getString("nome"));
                    prod.setPreco(Resultado.getDouble("preco"));
                    prod.setUnidade(Resultado.getString("unidade"));

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

    public Produto selectUltimo() {
        String sql = "select * from produto where id = (select  MAX(id) from produto) ";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();
            Produto prod = new Produto();

            if (Resultado.next()) {

                prod.setId(Resultado.getInt("id"));
                prod.setNome(Resultado.getString("nome"));
                prod.setPreco(Resultado.getDouble("preco"));
                prod.setUnidade(Resultado.getString("unidade"));

                return prod;
            } else {
                prod.setId(0);
                prod.setNome("");
                prod.setPreco(0);
                prod.setUnidade("");

                return prod;
            }
        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public ArrayList<Produto> selectAll() {
        String sql = "select * from produto";

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            PreparedStatement pst = conexao.prepareStatement(sql);

            ResultSet Resultado = pst.executeQuery();

            ArrayList<Produto> lista = new ArrayList<>();

            while (Resultado.next()) {
                Produto prod = new Produto();

                prod.setId(Resultado.getInt("id"));
                prod.setNome(Resultado.getString("nome"));
                prod.setPreco(Resultado.getDouble("preco"));
                prod.setUnidade(Resultado.getString("unidade"));

                lista.add(prod);
            }

            return lista;

        } catch (SQLException ex) {

            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());

        }
        return null;
    }

}
