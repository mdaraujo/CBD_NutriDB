/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Data.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 * 
 * falta mudar query na funcao addIngredienteDB
 * falta mudar query na funcao getIdIngrediente 
 */
public class LigacaoDB {

    private Connection conn;

    public LigacaoDB(String nomeBD, String username, String password) {

        conn = null;

        String url = "jdbc:sqlserver://DESKTOP-8HJ3B7P:1433;databaseName=" + nomeBD + ";";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getException());
            System.exit(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addPratoGrafosDB(Prato prato) {

        int idPrato = getIdPrato(prato);

        List<String> inserts = new ArrayList<>();

        List<String> ingredientes = prato.getIngredientes();
        List<String> quantidades = prato.getQuantidades();

        int idIngrediente;
        String ligacao;
        for (int i = 0; i < ingredientes.size(); i++) {
            idIngrediente = getIdIngrediente(ingredientes.get(i));
            ligacao = quantidades.get(i);

            inserts.add(String.format("insert into Grafos values(%d,%d,%s);", idPrato, idIngrediente, ligacao));
        }

        //adicionar
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            for (String insert : inserts) {
                st.executeUpdate(insert);
            }

            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public boolean addPratoDB(Prato prato) {
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String insert = String.format("insert into Pratos values('%s')", prato.getTitulo());
            st.executeUpdate(insert);

            return true;
        } catch (SQLException ex) {
            return false;
        }

    }
    
    public boolean addIngredienteDB(String ingrediente) {
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String insert = String.format("insert into Ingredientes values(%s)", ingrediente);
            st.executeUpdate(insert);

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    private int getIdPrato(Prato prato) {
        int id=-1;

        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = String.format("select id from Pratos where nome='%s'", prato.getTitulo());
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException ex) {}
        
        if(id==-1){
            addPratoDB(prato);
            return getIdPrato(prato);
        }
            
        return id;
    }

    private int getIdIngrediente(String ingrediente) {
        int id=-1;

        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = String.format("select id from Ingredientes where nome='%s'", ingrediente);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException ex) {}
        
        if(id==-1){
            addIngredienteDB(ingrediente);
            return getIdIngrediente(ingrediente);
        }
            
        return id;
    }
    
    

    
}
