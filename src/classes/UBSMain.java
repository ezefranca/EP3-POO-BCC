package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ezefranca
 */
public class UBSMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaInicial tela = new TelaInicial();
                
        tela.setDefaultCloseOperation(TelaInicial.EXIT_ON_CLOSE);  
        tela.setSize(800,600);
        tela.setVisible(true);
        
    }
    
}
