/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Data.Prato;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class DocDB {
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_CONNECTION = "jdbc:sqlserver://DESKTOP-8HJ3B7P:1433;databaseName=NutriDB_Docs";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "qwer";
    
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
    
    public void insertDoc(String doc) throws SQLException {
        int len;
        Connection dbConnection = null;
        PreparedStatement st = null;
                 
        try {
            dbConnection = getDBConnection();
            
            File file = new File("res\\doc\\" + doc + ".xml");
            FileInputStream fis = new FileInputStream(file);
            len = (int)file.length();
            
            String query = ("insert into Prato_Doc VALUES(?)");
            st = dbConnection.prepareStatement(query);
   
            // Method used to insert a stream of bytes
            st.setBinaryStream(1, fis, len); 
            st.executeUpdate();
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        } finally {
            
            if (st != null) {
                    st.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
    }
    
    public Prato getPrato(int id) throws SQLException {
        
        Connection dbConnection = null;
        PreparedStatement st = null;
        Prato prato = null;
        
        try {
            dbConnection = getDBConnection();
            String query = "SELECT \n" +
                            "Doc.value('(/prato//Cozinha/node())[1]', 'nvarchar(max)') as cozinha,\n" +
                            "Doc.value('(/prato//Dificuldade/node())[1]', 'nvarchar(max)') as dif,\n" +
                            "Doc.value('(/prato//Tempo/node())[1]', 'nvarchar(max)') as tempo,\n" +
                            "Doc.value('(/prato//Doses/node())[1]', 'nvarchar(max)') as doses\n" +
                            "FROM Prato_Doc WHERE ID = ?";
            st = dbConnection.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                
                String cozinha = rs.getString("cozinha");
                String dificuldade = rs.getString("dif");
                String tempo = rs.getString("tempo");
                int doses = rs.getInt("doses");
                
                prato = new Prato(id, cozinha, dificuldade, tempo, doses);
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
        
        return prato;
    }
    
    public List selectPratos(String selectSQL) throws SQLException {

        Connection dbConnection = null;
        Statement st = null;
        List<Prato> pratos = new ArrayList<>();

        try {
            
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(selectSQL);
            
            
            while (rs.next()) {

                int id = rs.getInt("id");
                String cozinha = rs.getString("cozinha");
                String dificuldade = rs.getString("dif");
                String tempo = rs.getString("tempo");
                int doses = rs.getInt("doses");
                
                Prato prato = new Prato(id, cozinha, dificuldade, tempo, doses);
                pratos.add(prato);
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
        return pratos;
    }
}
