/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbd_nutribd;

import Data.Prato;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Andreia Machado
 */
public class InsertPlate extends javax.swing.JFrame {
    private List<String> ingredientes = new ArrayList<>();
    private List<String> quantidades = new ArrayList<>();
    private String imagem;
    private DefaultListModel dlm = new DefaultListModel();
    private int index;
    
    /**
     * Creates new form InsertPlate
     */
    public InsertPlate() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Criar prato");
        listaIngredientes.setFont( new Font("monospaced", Font.PLAIN, 12) );
        atualizar.setVisible(false);
        eliminar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tituloTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IngredienteTXT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        QuantidadeTXT = new javax.swing.JTextField();
        AdicionarIngrediente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaIngredientes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoTXT = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ProximoPasso = new javax.swing.JButton();
        ProcurarImagem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        imagemDiretorio = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Titulo");

        tituloTXT.setName("tituloTxt"); // NOI18N
        tituloTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloTXTActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrediente");

        jLabel3.setText("Nome");

        jLabel4.setText("Quantidade");

        AdicionarIngrediente.setText("Adicionar");
        AdicionarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarIngredienteActionPerformed(evt);
            }
        });

        listaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaIngredientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaIngredientes);

        descricaoTXT.setColumns(20);
        descricaoTXT.setRows(5);
        jScrollPane2.setViewportView(descricaoTXT);

        jLabel5.setText("Descrição");

        ProximoPasso.setText("Proximo Passo");
        ProximoPasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProximoPassoActionPerformed(evt);
            }
        });

        ProcurarImagem.setText("Browser");
        ProcurarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcurarImagemActionPerformed(evt);
            }
        });

        jLabel6.setText("Adicionar Imagem");

        imagemDiretorio.setText("Nada alterado");

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(imagemDiretorio)
                                .addGap(51, 51, 51)
                                .addComponent(ProcurarImagem))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel3)
                                .addGap(234, 234, 234)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addGap(38, 38, 38)
                                        .addComponent(tituloTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(44, 44, 44)
                                        .addComponent(IngredienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(QuantidadeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addComponent(AdicionarIngrediente)))
                        .addGap(18, 18, 18)
                        .addComponent(atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(eliminar)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProximoPasso)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tituloTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IngredienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantidadeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarIngrediente)
                    .addComponent(eliminar)
                    .addComponent(atualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagemDiretorio)
                    .addComponent(ProcurarImagem))
                .addGap(18, 18, 18)
                .addComponent(ProximoPasso)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloTXTActionPerformed

    private void ProximoPassoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProximoPassoActionPerformed
        String titulo = tituloTXT.getText();
        String descricao = descricaoTXT.getText();
        Prato plate = new Prato(titulo);
        plate.setDescricao(descricao);
        plate.setImagem(imagem);
        plate.setAlimentos(ingredientes);
        plate.setQuantidades(quantidades);
        InsertDoc ins = new InsertDoc();
        ins.setPlate(plate);
        ins.setVisible(true);
        /*GraphDB graph = new GraphDB();
        ImgDB imgBD = new ImgDB();
        try {
            graph.addPratoGrafosDB(plate);
            imgBD.insertImage(imagem);
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(InsertPlate.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Plate successfully created!");*/
        this.dispose();
    }//GEN-LAST:event_ProximoPassoActionPerformed

    private void AdicionarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarIngredienteActionPerformed
        ingredientes.add(IngredienteTXT.getText());
        quantidades.add(QuantidadeTXT.getText());
        String format = String.format("%-50s %-20s",IngredienteTXT.getText(),QuantidadeTXT.getText());
        dlm.addElement(format);
        listaIngredientes.setModel(dlm);
        IngredienteTXT.setText("");
        QuantidadeTXT.setText("");
    }//GEN-LAST:event_AdicionarIngredienteActionPerformed

    private void ProcurarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcurarImagemActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagem = selectedFile.getAbsolutePath();
            System.out.println("Selected file: " + imagem);
        }
        imagemDiretorio.setText(imagem);
    }//GEN-LAST:event_ProcurarImagemActionPerformed

    private void listaIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaIngredientesMouseClicked
        if (evt.getClickCount() == 1) {
            int i = -1;
            String p = listaIngredientes.getSelectedValue();
            String[] split = p.split("    ");
            index = ingredientes.indexOf(split[0]);
            IngredienteTXT.setText(split[0]);
            QuantidadeTXT.setText(quantidades.get(index));
            atualizar.setVisible(true);
            eliminar.setVisible(true);
            AdicionarIngrediente.setVisible(false);
        }
    }//GEN-LAST:event_listaIngredientesMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int i = ingredientes.indexOf(IngredienteTXT.getText());
        quantidades.remove(i);
        ingredientes.remove(i);
        String format = String.format("%-50s %-20s",IngredienteTXT.getText(),QuantidadeTXT.getText());
        dlm.removeElement(format);
        listaIngredientes.setModel(dlm);
        IngredienteTXT.setText("");
        QuantidadeTXT.setText("");
        atualizar.setVisible(false);
        eliminar.setVisible(false);
        AdicionarIngrediente.setVisible(true);
    }//GEN-LAST:event_eliminarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        ingredientes.set(index,IngredienteTXT.getText());
        quantidades.set(index,QuantidadeTXT.getText());
        String format = String.format("%-50s %-20s",IngredienteTXT.getText(),QuantidadeTXT.getText());
        dlm.set(index,format);
        listaIngredientes.setModel(dlm);
        IngredienteTXT.setText("");
        QuantidadeTXT.setText("");
        atualizar.setVisible(false);
        eliminar.setVisible(false);
        AdicionarIngrediente.setVisible(true);
    }//GEN-LAST:event_atualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InsertPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertPlate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarIngrediente;
    private javax.swing.JTextField IngredienteTXT;
    private javax.swing.JButton ProcurarImagem;
    private javax.swing.JButton ProximoPasso;
    private javax.swing.JTextField QuantidadeTXT;
    private javax.swing.JButton atualizar;
    private javax.swing.JTextArea descricaoTXT;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel imagemDiretorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaIngredientes;
    private javax.swing.JTextField tituloTXT;
    // End of variables declaration//GEN-END:variables
}
