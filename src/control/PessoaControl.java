/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PessoaDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author g3ra1d0
 */
public class PessoaControl {

    public void insert(String[] dados) {

        Pessoa p = new Pessoa();

        p.setNome(dados[0]);
        p.setSexo(dados[1]);
        p.setIdade(Integer.parseInt(dados[2]));
        p.setTipo(dados[3]);
        p.setCpf(dados[4]);

        PessoaDAO DAO = new PessoaDAO();

        DAO.inserir(p);

    }

    public void atualizar(String[] dados) {

        Pessoa p = new Pessoa();

        p.setNome(dados[0]);
        p.setSexo(dados[1]);
        p.setIdade(Integer.parseInt(dados[2]));
        p.setTipo(dados[3]);
        p.setCpf(dados[4]);

        PessoaDAO DAO = new PessoaDAO();

        DAO.update(p);

    }

    public String[] recuperar(String cpf) {

        PessoaDAO DAO = new PessoaDAO();

        Pessoa p = DAO.select(cpf);

        String[] vetor = new String[5];

        vetor[0] = p.getNome();
        vetor[1] = p.getSexo();
        vetor[2] = String.valueOf(p.getIdade());
        vetor[3] = p.getTipo();
        vetor[4] = p.getCpf();

        return vetor;

    }

    public String[][] recuperarTodos() {
        PessoaDAO DAO = new PessoaDAO();

        ArrayList<Pessoa> lista = new ArrayList<>();
        lista = DAO.selectAll();

        String[][] matriz = new String[lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = String.valueOf(lista.get(i).getNome());
            matriz[i][1] = lista.get(i).getSexo();
            matriz[i][2] = String.valueOf(lista.get(i).getIdade());
            matriz[i][3] = lista.get(i).getTipo();
            matriz[i][4] = lista.get(i).getCpf();
        }

        return matriz;
    }

    public String excluir(String cpf) {
        PessoaDAO DAO = new PessoaDAO();

        boolean rs = DAO.delete(cpf);

        if (rs) {
            return "Deletado com Sucesso!";
        } else {
            return "Erro ão deletar!";
        }
    }

}
