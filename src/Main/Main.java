package Main;

import control.ProdutoControl;
import java.sql.Connection;
import dao.FabricaConexao;

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

//        dados[0] = "0";
//        dados[1] = "Pão";
//        dados[2] = "0.40";
//        dados[3] = "und";
//        
//        controle.salvar(dados);

          dados = controle.recuperar(1);
          System.out.println("Retorno do recupera: " + dados );
    }

}
