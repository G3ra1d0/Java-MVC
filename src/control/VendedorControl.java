/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.VendedorDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Vendedor;

/**
 *
 * @author g3ra1d0
 */
public class VendedorControl {

    public void salvar(String[] dados) {

        Vendedor p = new Vendedor();

        p.setId(Integer.parseInt(dados[0]));
        p.setNome(dados[1]);
        p.setIdade(Integer.parseInt(dados[2]));
        p.setSexo(dados[3]);

        VendedorDAO DAO = new VendedorDAO();

        if (p.getId() == 0) {
            DAO.inserir(p);
        } else {
            DAO.update(p);
        }

    }

    public String[] recuperar(int id) {
        String[] vetor = new String[4];
        vetor[0] = "0";

        VendedorDAO DAO = new VendedorDAO();

        Vendedor p = DAO.select(id);

        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getIdade());
        vetor[3] = p.getSexo();

        return vetor;

    }

    public String[] recuperaUltimor() {
        String[] vetor = new String[4];
        vetor[0] = "0";

        VendedorDAO DAO = new VendedorDAO();

        Vendedor p = DAO.selectUltimo();

        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getIdade());
        vetor[3] = p.getSexo();

        return vetor;

    }

    public ArrayList<String[]> recuperaWhere(String[] valores) {
        String[] vetor = new String[4];

        VendedorDAO DAO = new VendedorDAO();
        ArrayList<Vendedor> lista = new ArrayList<>();
        lista = DAO.selectWhere(valores);

        ArrayList<String[]> matriz = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            String[] temp = new String[4];
            
            temp[0] = String.valueOf(lista.get(i).getId());
            temp[1] = lista.get(i).getNome();
            temp[2] = String.valueOf(lista.get(i).getIdade());
            temp[3] = lista.get(i).getSexo();
            
            matriz.add(i,temp);
        }

        return matriz;
    }

    public String[][] recuperarTodos() {
        VendedorDAO DAO = new VendedorDAO();

        ArrayList<Vendedor> lista = new ArrayList<>();
        lista = DAO.selectAll();

        String[][] matriz = new String[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = String.valueOf(lista.get(i).getId());
            matriz[i][1] = lista.get(i).getNome();
            matriz[i][2] = String.valueOf(lista.get(i).getIdade());
            matriz[i][3] = lista.get(i).getSexo();
        }

        return matriz;
    }

    public String excluir(int id) {
        VendedorDAO DAO = new VendedorDAO();

        boolean rs = DAO.delete(id);

        if (rs) {
            return "Erro ão deletar!";

        } else {
            return "Deletado com Sucesso!";

        }
    }

}
