package classes;

import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JDialog;

/**
 *
 * @author Paulo
 */
public class BancoDados extends TelaInicial {
    LinkedList<javax.swing.JTextField> listaUser = null;
    LinkedList<javax.swing.JPasswordField> listaSenha = null;
    
    /**
     * Criando construtor default
     */
    BancoDados() {
        this.listaUser = new LinkedList();
        this.listaSenha = new LinkedList();
        System.out.println("Banco criado com sucesso!");
    }
        
    /**
    *@param jTextField1 - Recebe o nome do usuário e busca na lista de Dados
    * @return bloolean - True se jTextField1 existente e False caso não 
    */
    boolean buscaUser(javax.swing.JTextField jTextField1) {
        ListIterator<javax.swing.JTextField> iteradorUser = this.listaUser.listIterator(0);
        boolean checkId = false;
        while(iteradorUser.hasNext()){  
            javax.swing.JTextField userList = iteradorUser.next();
            if(jTextField1 == userList) {
                System.out.println("Usuário válido!");
                checkId = true;
            }
        }
        if(checkId == false)
            System.out.println("Usuário inválido!");
        return checkId;
    }
    
    /**
    *@param jPasswordField1 - Recebe a senha do usuário e busca na lista de Dados
    * @return bloolean - True se senha existente e False caso não 
    */   
    boolean buscaSenha(javax.swing.JPasswordField jPasswordField1) {
        ListIterator<javax.swing.JPasswordField> iteradorSenha = this.listaSenha.listIterator(0);
        boolean checkSenha = false;
        while(iteradorSenha.hasNext()){  
            javax.swing.JPasswordField senhaList = iteradorSenha.next();
            if(jPasswordField1 == senhaList) {
                System.out.println("Senha válida!");
                checkSenha = true;
            }
        }
        if(checkSenha == false){
            System.out.println("Senha inválida!");
        }
        return checkSenha;
    }    
}
