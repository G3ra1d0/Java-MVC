/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ProdutoDAO;
import model.Produto;

/**
 *
 * @author g3ra1d0
 */

public class ProdutoControl {
    
    public void salvar( String[] dados ){
        
        Produto p = new Produto();
        p.VetorTo(dados);
        
        ProdutoDAO DAO = new ProdutoDAO();
        if ( p.getId() == 0 ){
            DAO.inserir(p);
        }else {
            DAO.update(p);
        }
        
        
    }
    
    public String[] recuperar(int id){
        
        ProdutoDAO DAO = new ProdutoDAO();
        
        Produto p = DAO.select(id);
        
        return p.toVetor();
        
    }
    
}
