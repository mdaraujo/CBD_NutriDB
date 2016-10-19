/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Data.Prato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;

/**
 *
 * @author Miguel
 */
public class RelationalDB {
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_CONNECTION = "jdbc:sqlserver://DESKTOP-8HJ3B7P:1433;databaseName=NutriDB_Relational";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "qwer";
    
    public int getIdPrato(Prato prato) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement st = null;
        int id = -1;

        try {
            dbConnection = getDBConnection();
            String query = "select ID from "+Contract.PratoTable+" where Nome=?";
            st = dbConnection.prepareStatement(query);
            st.setString(1,prato.getTitulo());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                id = rs.getInt("ID");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        } finally {

            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
        
        if(id == -1){
            addPrato(prato);
            return getIdPrato(prato);
        }
            
        return id;
    }
    
    public int getIdAlimento(String nome) throws SQLException {
        
        Connection dbConnection = null;
        Statement st = null;
        int id = -1;

        try {
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = "select ID from "+Contract.IngredienteTable+" where Nome='"+nome+"'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        } finally {

            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
        
        if(id==-1){
            addAlimento(nome);
            return getIdAlimento(nome);
        }
            
        return id;
    }
    
    public boolean addPrato(Prato prato) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            String query = "insert into "+Contract.PratoTable+" (Nome,Descricao) values(?,?)";
            st = dbConnection.prepareStatement(query);
            st.setString(1, prato.getTitulo());
            st.setString(2, prato.getDescricao());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
    }
    
    public boolean addAlimento(String nome) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            int id = newIdIngredientes();
            String query = "insert into " + Contract.IngredienteTable +" (ID,Nome) values (?,?)";
            st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
            st.setString(2, nome);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("addAlimento " + e.getMessage());
            return false;
        } finally {

            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
    }
    
    public int newIdIngredientes() throws SQLException {
        
        Connection dbConnection = null;
        Statement st = null;
        int id = 1;

        try {
            //Estalbelecimento da ligacao
            String query = "select * from "+Contract.IngredienteTable+";";

            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            while (rs.last()) {
                return Integer.parseInt(rs.getString("ID")) + 1;
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }

        return id;

    }
    
    public DefaultListModel selectPratos(String selectSQL) throws SQLException {

        Connection dbConnection = null;
        Statement st = null;
        DefaultListModel listModel = new DefaultListModel();

        try {
            
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(selectSQL);
            
            
            while (rs.next()) {

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String desc = rs.getString("Descricao");

                Prato prato = new Prato(id, nome, desc);
                
                listModel.addElement(prato);
            }
            
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
        return listModel;
    }
    
    public Connection getDBConnection() {
        
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            dbConnection = DriverManager.getConnection(
                DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}