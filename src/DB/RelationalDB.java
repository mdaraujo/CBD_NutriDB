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
                System.out.println(nome);

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
