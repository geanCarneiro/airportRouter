/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.jFrame;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import main.Aeroporto;

/**
 *
 * @author Gean
 */
public class JFrameSelecionarAero extends javax.swing.JFrame {
    
    private JTextField output;
    private List<Aeroporto> possibilidades;
    
    /**
     * Creates new form JFrameSelecionarAero
     * @param possibilidades
     * @param output
     */
    public JFrameSelecionarAero(List<Aeroporto> possibilidades, JTextField output) {
        initComponents();
        this.possibilidades = possibilidades;
        this.output = output;
        this.updatePossibilidades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListPossibilidades = new javax.swing.JList<>();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Aeroporto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jListPossibilidades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListPossibilidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPossibilidades.setSelectedIndex(0);
        jScrollPane1.setViewportView(jListPossibilidades);

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSelecionar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButtonSelecionar)
                .addGap(26, 26, 26)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        sair();
    }//GEN-LAST:event_formWindowClosed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        sair();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        output.setText(jListPossibilidades.getSelectedValue());
        sair();
        this.dispose();
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    public void setOutput(JTextField output) {
        this.output = output;
    }

    public void setPossibilidades(List<Aeroporto> possibilidades) {
        this.possibilidades = possibilidades;
        this.updatePossibilidades();
    }
    
    public void sair(){
        JFramePrincipal.roteiro.selecionar = null;
    }
    
    public void updatePossibilidades(){
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        
        this.possibilidades.forEach(a -> {
            listModel.addElement(a.toString());
        });
        
        this.jListPossibilidades.setModel(listModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JList<String> jListPossibilidades;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
