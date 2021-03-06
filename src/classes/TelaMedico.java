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
public class TelaMedico extends javax.swing.JFrame {

    DefaultListModel<String> model;
    String typerUser;
    String localNome;
    Boolean temConsulta;
    ArrayList<ArrayList<String>> agendaTotal;
    DefaultListModel<String> modelLista1;
    private DefaultListModel<Object> modeloQuestionario;
    private ArrayList<ArrayList<String>> questionarioTotal;
    private final DefaultListModel<Object> Questionario;

    /**
     * Creates new form TelaMedico
     *
     * @param nome
     * @param pacientes
     * @param type
     */
    public TelaMedico(String nome, ArrayList<String> pacientes, String type) {
        typerUser = type;
        localNome = nome;
        temConsulta = false;
        initComponents();
        
        labelSaudacao.setText("Bem vindo Dr." + " " + nome);
        modelLista1 = new DefaultListModel<>();
        for (String paciente : pacientes) {
            modelLista1.addElement(paciente);
        }
        listaPacientes.setModel(modelLista1);
        listaPacientes.setSelectedIndex(0);

        /////
        model = new DefaultListModel<>();
        Agenda agenda = new Agenda();     
        agendaTotal = agenda.ler(listaPacientes.getSelectedValue().toString());
        model.addElement("Consultas Médicas marcadas");
        
        for (ArrayList<String> agendaPaciente1 : agendaTotal) {
            for (int j = 0; j < agendaPaciente1.size(); j++) {
                System.out.println(agendaPaciente1.get(3));
                if (agendaPaciente1.get(3).equals(listaPacientes.getSelectedValue().toString())) {
                    if (agendaPaciente1.get(0).equals(nome)) {
                        if (temConsulta == false) {
                        
                            model.addElement("Este Paciente tem consultas marcadas com você");
                            temConsulta = true;
                            break;
                        }
                    }
                }
            }
        }
        if (temConsulta == false) {
            model.addElement("Paciente não tem consultas marcadas com você");
        }
          listaConsultas.setModel(model);
          btnQuestionario.setVisible(temConsulta);
    
    /////
    /////
        modeloQuestionario = new DefaultListModel<>();
        Questionario quest = new Questionario();     
        questionarioTotal = quest.ler(listaPacientes.getSelectedValue().toString());
        modeloQuestionario.addElement("Paciente" + " |" + "Questão 1" + " |" + "Questão 4" + " |" + "Questão 3" + " |" + "Questão 4");
        
        for (ArrayList<String> questoes : questionarioTotal) {
            for (int j = 0; j < questoes.size(); j++) {
                System.out.println(questoes.get(0));
                if (questoes.get(0).equals(listaPacientes.getSelectedValue().toString())) {
                    System.out.println("OK VIU O NOME CERTO");
                    modeloQuestionario.addElement(questoes.get(0) + "   |   " + questoes.get(1) + "   |   " + questoes.get(2) + "   |   " + questoes.get(3) + "   |   " + questoes.get(4)  );
                }
            }
        }
       
          listaQuestionario.setModel(modeloQuestionario);
          
          
          
          
        Questionario = new DefaultListModel<>();    
        Questionario.addElement("Tem histórico familiar?");
        Questionario.addElement("Toma algum medicamento?");
        Questionario.addElement("Já fez cirurgia?");
        Questionario.addElement("Já sofreu acidente?");
       
      
        mostrarQuestoes.setModel(Questionario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        labelPacientes = new javax.swing.JLabel();
        labelSaudacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPacientes = new javax.swing.JList();
        btnProtuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaConsultas = new javax.swing.JList();
        btnQuestionario = new javax.swing.JButton();
        labelAgenda = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaQuestionario = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        mostrarQuestoes = new javax.swing.JList();
        labelQuestoes2 = new javax.swing.JLabel();
        labelQuestoes1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Painel Medico");
        setLocation(new java.awt.Point(200, 200));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        labelPacientes.setText("Escolha um Paciente");

        labelSaudacao.setText("Seja bem vindo Dr");

        listaPacientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaPacientes.setName("jListaPacientes"); // NOI18N
        listaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaPacientes);

        btnProtuario.setText("Mostrar Protuário");
        btnProtuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProtuarioActionPerformed(evt);
            }
        });

        listaConsultas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaConsultas);

        btnQuestionario.setText("Fazer questionário");
        btnQuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestionarioActionPerformed(evt);
            }
        });

        labelAgenda.setText("Status da Agenda do Paciente");

        listaQuestionario.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaQuestionario);

        mostrarQuestoes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(mostrarQuestoes);

        labelQuestoes2.setText("Lista de Questões");

        labelQuestoes1.setText("Respostas Questões");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSaudacao)
                    .addComponent(labelPacientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProtuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAgenda)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnQuestionario)
                                .addGap(277, 277, 277))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQuestoes1))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelQuestoes2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 140, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelSaudacao)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPacientes)
                    .addComponent(labelAgenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProtuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuestionario)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelQuestoes2)
                    .addComponent(labelQuestoes1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProtuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProtuarioActionPerformed
        TelaProtuario prot = new TelaProtuario(localNome, listaPacientes.getSelectedValue().toString(), typerUser);
        prot.setVisible(true);
    }//GEN-LAST:event_btnProtuarioActionPerformed

    private void listaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPacientesMouseClicked
        DefaultListModel listModel = (DefaultListModel) listaConsultas.getModel();
        listModel.removeAllElements();
        temConsulta = false;

        model.addElement("Consultas Médicas marcadas");
        for (ArrayList<String> agendaPaciente1 : agendaTotal) {
            for (int j = 0; j < agendaPaciente1.size(); j++) {
                if (agendaPaciente1.get(3).equals(listaPacientes.getSelectedValue().toString())) {
                    if (agendaPaciente1.get(0).equals(localNome)) {
                        if (j == 0 && temConsulta == false) {
                        //model.addElement(" ");
                            //model.addElement("Consulta:");
                            model.addElement("Tem consultas marcadas com você");
                            temConsulta = true;
                            break;
                        }
                    }
                    //model.addElement(agendaPaciente1.get(j));
                }
            }
        }
        if (temConsulta == false) {
            //model.addElement(" ");
            //model.addElement("Consulta:");
            model.addElement("Paciente não tem consultas marcadas com você");
        }
        listaConsultas.setModel(model);
        //jListaConsultas.setSelectedIndex(0);
        btnQuestionario.setVisible(temConsulta);
        
        modeloQuestionario = new DefaultListModel<>();
        Questionario quest = new Questionario();     
        questionarioTotal = quest.ler(listaPacientes.getSelectedValue().toString());
        modeloQuestionario.addElement("Paciente" + " |" + "Questão 1" + " |" + "Questão 4" + " |" + "Questão 3" + " |" + "Questão 4");
        
        for (ArrayList<String> questoes : questionarioTotal) {
            for (int j = 0; j < questoes.size(); j++) {
                System.out.println(questoes.get(0));
                if (questoes.get(0).equals(listaPacientes.getSelectedValue().toString())) {
                    System.out.println("OK VIU O NOME CERTO");
                    modeloQuestionario.addElement(questoes.get(0) + " |" + questoes.get(1) + " |" + questoes.get(2) + " |" + questoes.get(3) );
                }
            }
        }
       
          listaQuestionario.setModel(modeloQuestionario);
        
    }//GEN-LAST:event_listaPacientesMouseClicked

    private void btnQuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestionarioActionPerformed
        TelaQuestionario quest = new TelaQuestionario(listaPacientes.getSelectedValue().toString(), localNome);
        quest.setVisible(true);
    }//GEN-LAST:event_btnQuestionarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new TelaMedico("pop", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProtuario;
    private javax.swing.JButton btnQuestionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelAgenda;
    private javax.swing.JLabel labelPacientes;
    private javax.swing.JLabel labelQuestoes1;
    private javax.swing.JLabel labelQuestoes2;
    private javax.swing.JLabel labelSaudacao;
    private javax.swing.JList listaConsultas;
    private javax.swing.JList listaPacientes;
    private javax.swing.JList listaQuestionario;
    private javax.swing.JList mostrarQuestoes;
    // End of variables declaration//GEN-END:variables
}
