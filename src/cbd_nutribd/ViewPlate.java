/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbd_nutribd;

import DB.GraphDB;
import DB.ImgDB;
import DB.RelationalDB;
import Data.Prato;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Andreia Machado
 */
public class ViewPlate extends javax.swing.JFrame {
    private List<String> ingredientes = new ArrayList<>();
    private List<String> quantidades = new ArrayList<>();
    private String imagem;
    private DefaultListModel dlm = new DefaultListModel();
    private int index;
    private int idPrato = 15;
    private Prato pratoOriginal;
    private boolean updateGraph = false;
    
    /**
     * Creates new form ViewPlate
     */
    public ViewPlate() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Detalhes do prato");
        listaIngredientes.setFont( new Font("monospaced", Font.PLAIN, 12) );
        atualizar.setVisible(false);
        eliminar.setVisible(false);
        AdicionarIngrediente.setVisible(false);
        ProcurarImagem.setVisible(false);
        imagemDiretorio.setVisible(false);
        jLabel6.setVisible(false);
        IngredienteTXT.setEditable(false);
        QuantidadeTXT.setEditable(false);
        descricaoTXT.setEditable(false);
        tituloTXT.setEditable(false);
        guardarAlteracoes.setVisible(false);
        updatePreparacao.setVisible(false);
    }
    
    public ViewPlate(int idPrato) {
        this();
        this.idPrato = idPrato;
        try {
            viewPlate();
        } catch (SQLException ex) {
            Logger.getLogger(ViewPlate.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoTXT = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        EditarPrato = new javax.swing.JButton();
        ProcurarImagem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        imagemDiretorio = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tituloTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IngredienteTXT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        QuantidadeTXT = new javax.swing.JTextField();
        AdicionarIngrediente = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaIngredientes = new javax.swing.JList<>();
        guardarAlteracoes = new javax.swing.JButton();
        preparacao = new javax.swing.JButton();
        updatePreparacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        descricaoTXT.setColumns(20);
        descricaoTXT.setRows(5);
        jScrollPane2.setViewportView(descricaoTXT);

        jLabel5.setText("Descrição");

        EditarPrato.setText("Editar Prato");
        EditarPrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPratoActionPerformed(evt);
            }
        });

        ProcurarImagem.setText("Browser");
        ProcurarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcurarImagemActionPerformed(evt);
            }
        });

        jLabel6.setText("Adicionar Imagem");

        imagemDiretorio.setText("Nada adicionado");

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

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

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        listaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaIngredientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaIngredientes);

        guardarAlteracoes.setText("Guardar alterações");
        guardarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarAlteracoesActionPerformed(evt);
            }
        });

        preparacao.setText("Preparação");
        preparacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preparacaoActionPerformed(evt);
            }
        });

        updatePreparacao.setText("Alterar Preparação");
        updatePreparacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePreparacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(imagemDiretorio)
                                        .addGap(51, 51, 51)
                                        .addComponent(ProcurarImagem))
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
                                .addGap(18, 18, 18)
                                .addComponent(eliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(preparacao)
                                        .addGap(36, 36, 36)
                                        .addComponent(updatePreparacao)
                                        .addGap(86, 86, 86)
                                        .addComponent(EditarPrato))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)))
                                .addGap(33, 33, 33)
                                .addComponent(guardarAlteracoes))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel3)
                        .addGap(234, 234, 234)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IngredienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantidadeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarIngrediente)
                    .addComponent(eliminar)
                    .addComponent(atualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagemDiretorio)
                    .addComponent(ProcurarImagem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarPrato)
                    .addComponent(guardarAlteracoes)
                    .addComponent(preparacao)
                    .addComponent(updatePreparacao))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditarPratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPratoActionPerformed
        setEnable();
        this.setTitle("Editar prato");
    }//GEN-LAST:event_EditarPratoActionPerformed

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
        updateGraph = true;
    }//GEN-LAST:event_eliminarActionPerformed

    private void tituloTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloTXTActionPerformed

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
        updateGraph = true;
    }//GEN-LAST:event_atualizarActionPerformed

    private void listaIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaIngredientesMouseClicked
        if (evt.getClickCount() == 1) {
            int i = -1;
            String p = listaIngredientes.getSelectedValue();
            String[] split = p.split("     ");
            index = ingredientes.indexOf(split[0]);
            IngredienteTXT.setText(split[0]);
            QuantidadeTXT.setText(quantidades.get(index));
            if (IngredienteTXT.isEditable()) {
                atualizar.setVisible(true);
                eliminar.setVisible(true);
                AdicionarIngrediente.setVisible(false);
            }
        }
    }//GEN-LAST:event_listaIngredientesMouseClicked

    private void AdicionarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarIngredienteActionPerformed
        ingredientes.add(IngredienteTXT.getText());
        quantidades.add(QuantidadeTXT.getText());
        String format = String.format("%-50s %-20s",IngredienteTXT.getText(),QuantidadeTXT.getText());
        dlm.addElement(format);
        listaIngredientes.setModel(dlm);
        IngredienteTXT.setText("");
        QuantidadeTXT.setText("");
        updateGraph = true;
    }//GEN-LAST:event_AdicionarIngredienteActionPerformed

    private void guardarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarAlteracoesActionPerformed
        boolean update = true;
        try {
            update = updatePrato();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ViewPlate.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizar.setVisible(false);
        eliminar.setVisible(false);
        AdicionarIngrediente.setVisible(false);
        ProcurarImagem.setVisible(false);
        imagemDiretorio.setVisible(false);
        jLabel6.setVisible(false);
        IngredienteTXT.setEditable(false);
        QuantidadeTXT.setEditable(false);
        descricaoTXT.setEditable(false);
        tituloTXT.setEditable(false);
        guardarAlteracoes.setVisible(false);
        updatePreparacao.setVisible(false);
        preparacao.setVisible(true);
        EditarPrato.setVisible(true);
        if (update)
            JOptionPane.showMessageDialog(this, "Prato alterado com sucesso!");
        else
            JOptionPane.showMessageDialog(this, "O prato não foi alterado!");
        this.setTitle("Detalhes do prato");
    }//GEN-LAST:event_guardarAlteracoesActionPerformed

    private void preparacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preparacaoActionPerformed
        ViewPreparacao ver = new ViewPreparacao(idPrato,tituloTXT.getText());
        ver.setName(tituloTXT.getText());
        ver.setIdPrato(idPrato);
        ver.setVisible(true);
        Prato plate = ver.getPrato();
        pratoOriginal.setCozinha(plate.getCozinha());
        pratoOriginal.setDificuldade(plate.getDificuldade());
        pratoOriginal.setDoses(plate.getDoses());
        pratoOriginal.setPreparacao(plate.getPreparacao());
        pratoOriginal.setTempo(plate.getTempo()); 
    }//GEN-LAST:event_preparacaoActionPerformed

    private void updatePreparacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePreparacaoActionPerformed
        UpdateDoc uD = null;
        try {
            uD = new UpdateDoc(pratoOriginal);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPlate.class.getName()).log(Level.SEVERE, null, ex);
        }
        uD.setVisible(true);
    }//GEN-LAST:event_updatePreparacaoActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPlate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPlate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarIngrediente;
    private javax.swing.JButton EditarPrato;
    private javax.swing.JTextField IngredienteTXT;
    private javax.swing.JButton ProcurarImagem;
    private javax.swing.JTextField QuantidadeTXT;
    private javax.swing.JButton atualizar;
    private javax.swing.JTextArea descricaoTXT;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardarAlteracoes;
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
    private javax.swing.JButton preparacao;
    private javax.swing.JTextField tituloTXT;
    private javax.swing.JButton updatePreparacao;
    // End of variables declaration//GEN-END:variables

    private void viewPlate() throws SQLException {
        RelationalDB relDB = new RelationalDB();
        GraphDB graphDB = new GraphDB();
        Prato plate = relDB.getPrato(idPrato);
        tituloTXT.setText(plate.getNome());
        descricaoTXT.setText(plate.getDescricao());
        graphDB.getIngredientesQuantidades(idPrato,plate);
        ingredientes = plate.getAlimentos();
        quantidades = plate.getQuantidades();
        for (int i=0;i<ingredientes.size();i++) {
            String format = String.format("%-50s %-20s",ingredientes.get(i),quantidades.get(i));
            dlm.addElement(format);
            listaIngredientes.setModel(dlm);
        }
        pratoOriginal = plate;
        pratoOriginal.setID(idPrato);
    }
    
    public void setIDPrato(int id) {
        idPrato=id;
    }

    private void setEnable() {
        atualizar.setVisible(false);
        eliminar.setVisible(false);
        AdicionarIngrediente.setVisible(true);
        ProcurarImagem.setVisible(true);
        imagemDiretorio.setVisible(true);
        jLabel6.setVisible(true);
        IngredienteTXT.setEditable(true);
        QuantidadeTXT.setEditable(true);
        descricaoTXT.setEditable(true);
        tituloTXT.setEditable(true);
        guardarAlteracoes.setVisible(true);
        preparacao.setVisible(false);
        updatePreparacao.setVisible(true);
        EditarPrato.setVisible(false);
    }

    private boolean updatePrato() throws SQLException, FileNotFoundException {
        RelationalDB relDB = new RelationalDB();
        GraphDB graphDB = new GraphDB();
        ImgDB imgDB = new ImgDB();
        boolean update = true;
        if (!(pratoOriginal.getNome().equals(tituloTXT.getText())) || !(pratoOriginal.getDescricao().equals(descricaoTXT.getText()))) {
            updatePratoOriginal();
            update = relDB.updatePrato(idPrato,tituloTXT.getText(),descricaoTXT.getText());
        }
        if (updateGraph) {
            update = graphDB.updatePratoGraph(idPrato,pratoOriginal);
        }
        update = imgDB.updatePratoImg(idPrato,imagem);
        return update;
    }

    private void updatePratoOriginal() {
        pratoOriginal.setNome(tituloTXT.getText());
        pratoOriginal.setDescricao(descricaoTXT.getText());
    }
}
