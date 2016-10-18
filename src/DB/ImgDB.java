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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Miguel
 */
public class ImgDB {
    
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_CONNECTION = "jdbc:sqlserver://DESKTOP-8HJ3B7P:1433;databaseName=NutriDB_KeyValue";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "qwer";
    
    public Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
        } catch(ClassNotFoundException ex) {
            System.out.println(ex.getException());
            System.exit(1);
        }
        String url = DB_CONNECTION;
        try {
            conn = DriverManager.getConnection(url,DB_USER,DB_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
 
    /* Inserir prato */
    public void insertImage(Connection conn,String img,int id) {
        int len;
        String query;
        PreparedStatement pstmt;
                 
        try {
            if (img != null) {
                File file = new File(img);
                FileInputStream fis = new FileInputStream(file);
                len = (int)file.length();

                query = ("INSERT INTO " + Contract.KEYVALUETable + " VALUES(?)");
                pstmt = conn.prepareStatement(query);

                // Method used to insert a stream of bytes
                pstmt.setBinaryStream(1, fis, len); 
                pstmt.executeUpdate();
            }
            else { // TODO
                query = ("INSERT INTO " + Contract.KEYVALUETable + "(ID) VALUES NULL");
                pstmt = conn.prepareStatement(query);
                pstmt.executeUpdate();
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /* obter a imagem de um dado prato  */
    public byte[] getImage(Connection conn,int id) {
        byte[] fileBytes = null;
        String query;
        try {
            query = "SELECT Prato_img FROM " + Contract.KEYVALUETable + " WHERE ID="+id;
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(query);
            if (rs.next()) {
                fileBytes = rs.getBytes(1);
            }        
                         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }
    
    /* eliminar prato */
    public void deletePratoImage(Connection conn,int id) {
        byte[] fileBytes = null;
        String query;
        try {
            query = "DELETE FROM "+Contract.KEYVALUETable + " WHERE ID="+id;
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(query);
            rs.absolute(id);
            rs.deleteRow();      
                         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
