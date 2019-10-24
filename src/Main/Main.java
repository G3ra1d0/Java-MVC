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
//        dados[1] = "Todinho";
//        dados[2] = "1.1";
//        dados[3] = "und";
////        
//        controle.salvar(dados);

//////// Recuperar um elementro especifico
//          dados = controle.recuperar(2);
//          System.out.println("Retorno do recupera: \nId: " + dados[0] +
//                             "\nNome: " + dados[1] + "\nPreco: " + dados[2] + "\nUnidade: " + dados[3]  );

/////// Recuperar Todos
        ArrayList<ArrayList> matriz = controle.recuperarTodos();
        System.out.println("Retorno do recuperado todos: \n");
        for (int i = 0; i < matriz.size(); i++) {
            System.out.println("\n----------------- \n");
            System.out.println("Retorno do recupera: \nId: " + matriz.get(i).get(0)
                    + "\nNome: " + matriz.get(i).get(1) + "\nPreco: " + matriz.get(i).get(2) + "\nUnidade: " + matriz.get(i).get(3));
        }

///// Delete
//        controle.excluir(2);
//        System.out.println("Deletado com sucesso!");
    }

}
