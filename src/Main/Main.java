package Main;

import View.ProdutoTela;
import control.PessoaControl;
import control.ProdutoControl;
import java.util.ArrayList;

/**
 *
 * @author g3ra1d0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProdutoTela tela = new ProdutoTela();
        tela.setVisible(true);
        
//        String dados[] = new String[4];
//        ProdutoControl controle = new ProdutoControl();

// Inserir ou Atualizar        
//        dados[0] = "0";
//        dados[1] = "Pão com Salame";
//        dados[2] = "1.5";
//        dados[3] = "und";
//        
//        controle.salvar(dados);

//////// Recuperar um elementro especifico
//          dados = controle.recuperar(2);
//          System.out.println("Retorno do recupera: \nId: " + dados[0] +
//                             "\nNome: " + dados[1] + "\nPreco: " + dados[2] + "\nUnidade: " + dados[3]  );

/////// Recuperar Todos
//        String[][] matriz = controle.recuperarTodos();
//        System.out.println("Retorno do recuperado todos: \n");
//        for (int i = 0; i < matriz.length ; i++) {
//            System.out.println("\n----------------- \n");
//            System.out.println("Retorno do recupera: \nId: " + matriz[i][0]
//                    + "\nNome: " + matriz[i][1] + "\nPreco: " + matriz[i][2] + "\nUnidade: " + matriz[i][3] );
//        }

///// Delete
//        System.out.println(controle.excluir(4));



/////--------------------------------------------------------------------
//        PessoaControl controle = new PessoaControl();
//         String dados[] = new String[5];
// Inserir       
//        dados[0] = "Igor";
//        dados[1] = "Feminino";
//        dados[2] = "20";
//        dados[3] = "Vendedor";
//        dados[4] = "15498763209";
//        
//        controle.insert(dados);
                
// Update
//        dados[0] = "Igor";
//        dados[1] = "Feminino";
//        dados[2] = "24";
//        dados[3] = "Vendedor";
//        dados[4] = "15498763209";
//        
//        controle.atualizar(dados);

//////// Recuperar um elementro especifico
//          dados = controle.recuperar("15498763209");
//          System.out.println("Retorno do recupera: \nNome: " + dados[0] +
//                             "\nSexo: " + dados[1] + "\nIdade: " + dados[2] + "\nTipo: " + dados[3]  + "\nCPF: " + dados[4] );
//

/////// Recuperar Todos
//        String[][] matriz = controle.recuperarTodos();
//        System.out.println("Retorno do recuperado todos: \n");
//        for (int i = 0; i < matriz.length ; i++) {
//            System.out.println("\n----------------- \n");
//            System.out.println("Retorno do recupera: \nNome: " + matriz[i][0]
//                    + "\nSexo: " + matriz[i][1] + "\nIdade: " + matriz[i][2] + "\nTipo: " + matriz[i][3] + "\nCPF: " + matriz[i][4] );
//        
//        }


    }

}
