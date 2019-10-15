package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            System.err.println("Erro ão salvar o objeto: " + ex.getMessage());
        }

    }

    public void update(Produto prod) {

    }

    public void delete(int id) {

    }

    public Produto select(int id) {
        String sql = "select * from produto where id = ?";
        PreparedStatement pst;

        try {
            Connection conexao = FabricaConexao.GeraConexao();

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Produto prod = new Produto();

            prod.setId(Resultado.getInt("id"));
            prod.setNome(Resultado.getString("nome"));
            prod.setPreco(Resultado.getDouble("preco"));
            prod.setUnidade(Resultado.getString("unidade"));

            return prod;

        } catch (SQLException ex) {

            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());

        }
        return null;

    }

    public List<Produto> selectAll() {
        return null;
    }

}
