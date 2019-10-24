package Main;

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
        String dados[] = new String[4];

        ProdutoControl controle = new ProdutoControl();

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
        controle.excluir(4);
        System.out.println("Deletado com sucesso!");

    }

}
