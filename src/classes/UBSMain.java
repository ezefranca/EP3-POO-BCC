package classes;

import javax.swing.JCheckBox;

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
        Tela tela = new Tela();
        
        JCheckBox checkbox_11 = new JCheckBox("Medico");  
  

  tela.add(checkbox_11);
  
if (checkbox_11.isSelected()) {  
    // caso positivo  
    System.out.println("checkbox_11 selecionada");  
} else {  
    // caso negativo  
    System.out.println("checkbox_11 NÃO selecionada");  
} 
        
        
        tela.setDefaultCloseOperation(Tela.EXIT_ON_CLOSE);  
        tela.pack();  
        tela.setVisible(true);
        
    }
    
}
