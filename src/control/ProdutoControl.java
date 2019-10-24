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

        ProdutoDAO DAO = new ProdutoDAO();

        Produto p = DAO.select(id);

        String[] vetor = new String[4];
        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getPreco());
        vetor[3] = p.getUnidade();

        return vetor;

    }

    public ArrayList<ArrayList> recuperarTodos() {
        ProdutoDAO DAO = new ProdutoDAO();

        ArrayList<Produto> lista = new ArrayList<Produto>();
        lista = (ArrayList<Produto>) DAO.selectAll();

        ArrayList< ArrayList> matriz = new ArrayList< ArrayList>();
        ArrayList< String> vetor = new ArrayList< String>();

        for (int i = 0; i < lista.size(); i++) {
            vetor.set(i, String.valueOf(lista.get(i).getId()));
            vetor.set(i, lista.get(i).getNome());
            vetor.set(i, String.valueOf(lista.get(i).getPreco()));
            vetor.set(i, lista.get(i).getUnidade());

            matriz.add(vetor);
        }

        return matriz;
    }

    public String excluir(int id) {
        ProdutoDAO DAO = new ProdutoDAO();

        boolean rs = DAO.delete(id);
        
        if(rs){
            return "Deletado com Sucesso!";
        }else{
            return "Erro ão deletar!";
        }
            }

}
