/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.jFrame;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import main.DiasSemana;
import main.FileManager;
import main.Manipulador;
import main.PlanoDeVoo;
import main.ResultSet;
import main.Voo;

/**
 *
 * @author Gean
 */
public class JFramePrincipal extends javax.swing.JFrame {

    public static PlanoDeVoo plano = new PlanoDeVoo();
    public static JFrameRoteiro roteiro;
    public static final int MIN_ESPERA_MIN = 15;
    
    private ResultSet resultSet;
    
    public JFramePrincipal() {
        initComponents();
        customInitComponents();
        refresh();
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLinhas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonRoteiro = new javax.swing.JButton();
        jPanelFiltro = new javax.swing.JPanel();
        jLabelCodVoo = new javax.swing.JLabel();
        jTextFieldCodVoo = new javax.swing.JTextField();
        jLabelCodAviao = new javax.swing.JLabel();
        jTextFieldCodAviao = new javax.swing.JTextField();
        jLabelAeroPartida = new javax.swing.JLabel();
        jTextFieldAeroPartida = new javax.swing.JTextField();
        jLabelAeroChegada = new javax.swing.JLabel();
        jTextFieldAeroChegada = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuItemCarregar = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LINHAS AEREAS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableLinhas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLinhas);

        jButtonRoteiro.setText("Roteiro de Viagem");
        jButtonRoteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoteiroActionPerformed(evt);
            }
        });

        jPanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabelCodVoo.setText("Codigo do Voo: ");

        jLabelCodAviao.setText("Codigo do Avi�o: ");

        jLabelAeroPartida.setText("Aeroporto de Partida: ");

        jLabelAeroChegada.setText("Aeroporto de Chegada: ");

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelCodAviao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodAviao))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelCodVoo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodVoo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelAeroPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAeroPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelAeroChegada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAeroChegada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodVoo)
                    .addComponent(jTextFieldCodVoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAeroPartida)
                    .addComponent(jTextFieldAeroPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodAviao)
                    .addComponent(jTextFieldCodAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAeroChegada)
                    .addComponent(jTextFieldAeroChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenuInicio.setText("Inicio");

        jMenuItemCarregar.setText("Carregar Linha Aerea");
        jMenuItemCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregarActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemCarregar);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemSair);

        jMenuBar1.add(jMenuInicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRoteiro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRoteiro)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void customInitComponents(){
        
        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }
            

        };
        
        espalharDocumentListener(docListener, jPanelFiltro);
        
        resultSet = new ResultSet(plano.getVoos());
        
        jTableLinhas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }
    
    private void espalharDocumentListener(DocumentListener docListener, Component component){
        if(component instanceof JTextField){
            ((JTextField)component).getDocument().addDocumentListener(docListener);
        } else {
            if(component instanceof Container){
                for(Component c: ((Container) component).getComponents())
                    espalharDocumentListener(docListener, c);
            }
        }
    }
    
    private void jButtonRoteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoteiroActionPerformed
        if(roteiro == null)
            roteiro = new JFrameRoteiro();
        
        roteiro.setVisible(true);
    }//GEN-LAST:event_jButtonRoteiroActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        sair();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sair();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregarActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivos *.json", "json"));
        
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = jfc.getSelectedFile();
            
            plano = Manipulador.planoDeVooFromVooInList(FileManager.getVooInFromFile(file));
            
            refresh();
        }
        
    }//GEN-LAST:event_jMenuItemCarregarActionPerformed
    
    public void refresh(){
        
        this.jTextFieldCodVoo.setText("");
        this.jTextFieldCodAviao.setText("");
        this.jTextFieldAeroPartida.setText("");
        this.jTextFieldAeroChegada.setText("");
        
        this.resultSet.setOriginal(this.plano.getVoos());
        
        jTableLinhas.setModel(Manipulador.tableModelFromVoos(resultSet.getList()));
        
        this.resizeColumnWidth(jTableLinhas, 300);
        
    }
    
    public void filtrar(){
        resultSet.limparFiltro();
        
        resultSet.filtraCodVoo(this.jTextFieldCodVoo.getText());
        resultSet.filtraCodAviao(this.jTextFieldCodAviao.getText());
        resultSet.filtraAeroPartida(this.jTextFieldAeroPartida.getText());
        resultSet.filtraAeroChegada(this.jTextFieldAeroChegada.getText());
        
        this.jTableLinhas.setModel(Manipulador.tableModelFromVoos(resultSet.getList()));
        this.resizeColumnWidth(jTableLinhas, 300);

    }
    
    public void resizeColumnWidth(JTable table, int max) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = Voo.INFOSDISPONIVEIS[column].length()*7; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > max)
                width=max;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    private void sair(){
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "ATEN��O", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRoteiro;
    private javax.swing.JLabel jLabelAeroChegada;
    private javax.swing.JLabel jLabelAeroPartida;
    private javax.swing.JLabel jLabelCodAviao;
    private javax.swing.JLabel jLabelCodVoo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenuItem jMenuItemCarregar;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableLinhas;
    private javax.swing.JTextField jTextFieldAeroChegada;
    private javax.swing.JTextField jTextFieldAeroPartida;
    private javax.swing.JTextField jTextFieldCodAviao;
    private javax.swing.JTextField jTextFieldCodVoo;
    // End of variables declaration//GEN-END:variables
}
