/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author g3ra1d0
 */
public class ClienteControl {

    public void salvar(String[] dados) {

        Cliente p = new Cliente();

        p.setId(Integer.parseInt(dados[0]));
        p.setNome(dados[1]);
        p.setIdade(Integer.parseInt(dados[2]));
        p.setSexo(dados[3]);

        ClienteDAO DAO = new ClienteDAO();

        if (p.getId() == 0) {
            DAO.inserir(p);
        } else {
            DAO.update(p);
        }

    }

    public String[] recuperar(int id) {
        String[] vetor = new String[4];
        vetor[0] = "0";

        ClienteDAO DAO = new ClienteDAO();

        Cliente p = DAO.select(id);

        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getIdade());
        vetor[3] = p.getSexo();

        return vetor;

    }

    public String[] recuperaUltimor() {
        String[] vetor = new String[4];
        vetor[0] = "0";

        ClienteDAO DAO = new ClienteDAO();

        Cliente p = DAO.selectUltimo();

        vetor[0] = String.valueOf(p.getId());
        vetor[1] = p.getNome();
        vetor[2] = String.valueOf(p.getIdade());
        vetor[3] = p.getSexo();

        return vetor;

    }

    public ArrayList<String[]> recuperaWhere(String[] valores) {
        String[] vetor = new String[4];

        ClienteDAO DAO = new ClienteDAO();
        ArrayList<Cliente> lista = new ArrayList<>();
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
        ClienteDAO DAO = new ClienteDAO();

        ArrayList<Cliente> lista = new ArrayList<>();
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
        ClienteDAO DAO = new ClienteDAO();

        boolean rs = DAO.delete(id);

        if (rs) {
            return "Erro ão deletar!";

        } else {
            return "Deletado com Sucesso!";

        }
    }

}
