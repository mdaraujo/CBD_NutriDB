/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbd_nutribd;

import DB.DocDB;
import DB.GraphDB;
import DB.ImgDB;
import DB.RelationalDB;
import Data.Prato;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class PratoSearch extends javax.swing.JFrame {
    private int id = -1;
    /**
     * Creates new form PratoSearch
     */
    public PratoSearch() {
        initComponents();
        
        list.setFont( new Font("monospaced", Font.PLAIN, 12) );
        
        searchBtn.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBtn = new javax.swing.JButton();
        listPanel = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        nomeInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dosesInput = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        difInput = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cozinhaInput = new javax.swing.JComboBox<>();
        tempoInput = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        eliminarPrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchBtn.setText("Search");
        searchBtn.setToolTipText("");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        listPanel.setViewportView(list);

        jLabel1.setText("Nome:");

        dosesInput.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 2));

        jLabel2.setText("Doses");

        difInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Fácil", "Médio", "Difícil" }));

        jLabel3.setText("Dificuldade");

        jLabel4.setText("Tipo de Cozinha");

        cozinhaInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Contemporânea", "Internacional", "Contemporânea Fusão", "Vegetariana", "Internacional Contemporânea", "Portuguesa Tradicional", "Brasileira Vegetariana", "Japonesa", "Suíça", "Contemporânea Saudável", "Italiana", "Mediterrânea", "Britânica", "Francesa Contemporânea" }));

        tempoInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Lento", "Médio", "Rápido" }));

        jLabel5.setText("Tempo");

        eliminarPrato.setText("Eliminar Prato");
        eliminarPrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(listPanel)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dosesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(difInput, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cozinhaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarPrato)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(jLabel4)
                    .addComponent(cozinhaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dosesInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(difInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(tempoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(eliminarPrato, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        
        DefaultListModel listModel = new DefaultListModel();
        String header = String.format("%-3s %-70s %-11s %-8s %-5s %-20s", "ID", "NOME", "DIFICULDADE", "TEMPO", "DOSES", "COZINHA");
        listModel.addElement(header);
        
        List<Prato> pratosInDocs = getListInDocs();
        List<Prato> pratosInRel = getListInRelational();
        
        for (int i = 0; i < pratosInDocs.size(); i++) {
            for (int j = 0; j < pratosInRel.size(); j++) {
                if (pratosInDocs.get(i).getID() == pratosInRel.get(j).getID()) {
                    Prato prato = new Prato(pratosInRel.get(j).getID(), pratosInRel.get(j).getNome(), 
                            pratosInRel.get(j).getDescricao(), pratosInDocs.get(i).getCozinha(), 
                            pratosInDocs.get(i).getDificuldade(), pratosInDocs.get(i).getTempo(), 
                            pratosInDocs.get(i).getDoses());
                    
                    listModel.addElement(prato.toString());
                }
            }
        }
        
        list.setModel(listModel);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        
        if (evt.getClickCount() == 2) {
            int i = -1;
            String p = list.getSelectedValue();
            
            Matcher matcher = Pattern.compile("\\d+").matcher(p);
            if (matcher.find())
                i = Integer.valueOf(matcher.group());
            
            System.out.println(i);
            id = i;
        }
    }//GEN-LAST:event_listMouseClicked

    private void eliminarPratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPratoActionPerformed
        if (id != -1) {
            DocDB docDB = new DocDB();
            GraphDB graphDB = new GraphDB();
            ImgDB imgDB = new ImgDB();
            RelationalDB relationalDB = new RelationalDB();
            try {
                docDB.deletePratoDoc(id);
                graphDB.deletePratoGraph(id);
                imgDB.deletePratoImage(id);
                relationalDB.deletePratoRelational(id);
            } catch (SQLException ex) {
                Logger.getLogger(PratoSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
            searchBtn.doClick();
            JOptionPane.showMessageDialog(this, "Plate successfully deleted!");
        }
       
    }//GEN-LAST:event_eliminarPratoActionPerformed

    public List<Prato> getListInDocs()
    {
        String query = "SELECT\n" +
                        "Doc.value('(/prato//id/node())[1]', 'nvarchar(max)') as id,\n" +
                        "Doc.value('(/prato//Cozinha/node())[1]', 'nvarchar(max)') as cozinha,\n" +
                        "Doc.value('(/prato//Dificuldade/node())[1]', 'nvarchar(max)') as dif,\n" +
                        "Doc.value('(/prato//Tempo/node())[1]', 'nvarchar(max)') as tempo,\n" +
                        "Doc.value('(/prato//Doses/node())[1]', 'nvarchar(max)') as doses\n" +
                        "FROM Prato_Doc WHERE 1=1 ";
        
        if (!cozinhaInput.getSelectedItem().toString().equals("*")) {
            query += "AND Doc.value('(/prato//Cozinha/node())[1]', 'nvarchar(max)') = '" + cozinhaInput.getSelectedItem().toString() + "' ";
        }
        if (!difInput.getSelectedItem().toString().equals("*")) {
            query += "AND Doc.value('(/prato//Dificuldade/node())[1]', 'nvarchar(max)') = '" + difInput.getSelectedItem().toString() + "' ";
        }
        if (!tempoInput.getSelectedItem().toString().equals("*")) {
            query += "AND Doc.value('(/prato//Tempo/node())[1]', 'nvarchar(max)') = '" + tempoInput.getSelectedItem().toString() + "' ";
        }
        if (!dosesInput.getValue().toString().equals("0")) {
            query += "AND Doc.value('(/prato//Doses/node())[1]', 'nvarchar(max)') = '" + dosesInput.getValue().toString() + "' ";
        }
        
        DocDB docDB = new DocDB();
        List<Prato> pratos = new ArrayList<>();
        try {
            pratos = docDB.selectPratos(query);
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        
        return pratos;
    }
    
    public List<Prato> getListInRelational()
    {
        String query = "SELECT * FROM Pratos WHERE Nome LIKE '%" + nomeInput.getText() + "%'";
        
        RelationalDB relDB = new RelationalDB();
        List<Prato> pratos = new ArrayList<>();
        try {
            pratos = relDB.selectPratos(query);
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        
        return pratos;
    }
    
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
            java.util.logging.Logger.getLogger(PratoSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PratoSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PratoSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PratoSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PratoSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cozinhaInput;
    private javax.swing.JComboBox<String> difInput;
    private javax.swing.JSpinner dosesInput;
    private javax.swing.JButton eliminarPrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> list;
    private javax.swing.JScrollPane listPanel;
    private javax.swing.JTextField nomeInput;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox<String> tempoInput;
    // End of variables declaration//GEN-END:variables
}
