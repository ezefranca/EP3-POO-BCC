/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author ezefranca
 */
public class TelaDentista extends javax.swing.JFrame {
    private final String typerUser;
    private final String localNome;
    private ArrayList<String> listadePacientes;
    private DefaultListModel<Object> modelLista1;

    /**
     * Creates new form TelaDentista
     * @param nome
     * @param pacientes
     * @param type
     */
    public TelaDentista(String nome, ArrayList<String> pacientes, String type) {
        typerUser = type;
        localNome = nome;
        listadePacientes = pacientes;
        initComponents();
        labelSaudacao.setText("Bem vindo Dr." + " " + nome);
        modelLista1 = new DefaultListModel<>();
        for (String paciente : pacientes) {
            modelLista1.addElement(paciente);
        }
        listaPacientes.setModel(modelLista1);
        listaPacientes.setSelectedIndex(0);
    }

    private TelaDentista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSaudacao = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        cboxObturacao = new javax.swing.JCheckBox();
        cboxLimpeza = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPacientes = new javax.swing.JList();
        labelPacientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 200));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        labelSaudacao.setText("Bem vindo Dentista, Dr. *****");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cboxObturacao.setText("Obturação");
        cboxObturacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxObturacaoActionPerformed(evt);
            }
        });

        cboxLimpeza.setText("Limpeza");
        cboxLimpeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxLimpezaActionPerformed(evt);
            }
        });

        listaPacientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaPacientes);

        labelPacientes.setText("Lista de Pacientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboxObturacao)
                                    .addComponent(cboxLimpeza, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalvar)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(labelSaudacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(labelPacientes)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelSaudacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(labelPacientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cboxObturacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboxLimpeza)
                .addGap(30, 30, 30)
                .addComponent(btnSalvar)
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Boolean ocupado = false;
        Historico salvar = new Historico();
        String peso = "-";
        String pressao = "-";
        String informacoes = "";
        
        if(cboxLimpeza.isSelected())
            informacoes = informacoes + cboxLimpeza.getText();
        if(cboxObturacao.isSelected())
            informacoes = informacoes + cboxObturacao.getText();
        
        //String paciente = listaPacientes.getSelectedValue().toString();
        
//        CSVAcesso ler = new CSVAcesso("agenda.csv", "true");
//        ler.parse();
        
        salvar.gravar(listaPacientes.getSelectedValue().toString(), pressao, peso, informacoes);
        System.out.println("Informacoes Salvas");
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cboxObturacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxObturacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxObturacaoActionPerformed

    private void cboxLimpezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxLimpezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxLimpezaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaDentista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cboxLimpeza;
    private javax.swing.JCheckBox cboxObturacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPacientes;
    private javax.swing.JLabel labelSaudacao;
    private javax.swing.JList listaPacientes;
    // End of variables declaration//GEN-END:variables
}
