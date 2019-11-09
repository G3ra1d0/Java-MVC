/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ProdutoDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author g3ra1d0
 */
public class ProdutoControl {

    public void salvar(String[] dados) {

        Produto p = new Produto();

        p.setId(Integer.parseInt(dados[0]));
        p.setNome(dados[1]);
        p.setPreco(Double.parseDouble(dados[2]));
        p.setUnidade(dados[3]);

        ProdutoDAO DAO = new ProdutoDAO();

        if (p.getId() == 0) {
            DAO.inserir(p);
        } else {
            DAO.update(p);
        }

    }

    public String[] recuperar(int id) {
        String[] vetor = new String[4];
        vetor[0] = "0";

        ProdutoDAO DAO = new ProdutoDAO();

        Produto p = DAO.select(id);

        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getPreco());
        vetor[3] = p.getUnidade();

        return vetor;

    }

    public String[] recuperaUltimor() {
        String[] vetor = new String[4];
        vetor[0] = "0";

        ProdutoDAO DAO = new ProdutoDAO();

        Produto p = DAO.selectUltimo();

        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getPreco());
        vetor[3] = p.getUnidade();

        return vetor;

    }

    public ArrayList<String[]> recuperaWhere(String[] valores) {
        String[] vetor = new String[4];

        ProdutoDAO DAO = new ProdutoDAO();
        ArrayList<Produto> lista = new ArrayList<>();
        lista = DAO.selectWhere(valores);

        ArrayList<String[]> matriz = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            String[] temp = new String[4];
            
            temp[0] = String.valueOf(lista.get(i).getId());
            temp[1] = lista.get(i).getNome();
            temp[2] = String.valueOf(lista.get(i).getPreco());
            temp[3] = lista.get(i).getUnidade();
            
            matriz.add(i,temp);
        }

        return matriz;
    }

    public String[][] recuperarTodos() {
        ProdutoDAO DAO = new ProdutoDAO();

        ArrayList<Produto> lista = new ArrayList<>();
        lista = DAO.selectAll();

        String[][] matriz = new String[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = String.valueOf(lista.get(i).getId());
            matriz[i][1] = lista.get(i).getNome();
            matriz[i][2] = String.valueOf(lista.get(i).getPreco());
            matriz[i][3] = lista.get(i).getUnidade();
        }

        return matriz;
    }

    public String excluir(int id) {
        ProdutoDAO DAO = new ProdutoDAO();

        boolean rs = DAO.delete(id);

        if (rs) {
            return "Erro ão deletar!";

        } else {
            return "Deletado com Sucesso!";

        }
    }

}
