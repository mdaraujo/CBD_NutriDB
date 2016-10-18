/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    public void insertDoc(Connection conn,int id,String doc) {
        int len;
        String query;
        PreparedStatement pstmt;
                 
        try {
            File file = new File("res\\doc\\" + doc + ".xml");
            FileInputStream fis = new FileInputStream(file);
            len = (int)file.length();
 
            query = ("insert into Prato_Doc VALUES(?)");
            pstmt = conn.prepareStatement(query);
   
            // Method used to insert a stream of bytes
            pstmt.setBinaryStream(1, fis, len); 
            pstmt.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
