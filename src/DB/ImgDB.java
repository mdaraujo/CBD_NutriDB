/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public void insertImage(String img) throws SQLException, FileNotFoundException {
        int len;
        String query;
        Connection dbConnection = null;
        PreparedStatement pstmt = null;
                 
        try {
            dbConnection = getDBConnection();          
            if (img != null) {
                File file = new File(img);
                FileInputStream fis = new FileInputStream(file);
                len = (int)file.length();

                query = ("INSERT INTO " + Contract.KEYVALUETable + " VALUES(?)");
                pstmt = dbConnection.prepareStatement(query);

                // Method used to insert a stream of bytes
                pstmt.setBinaryStream(1, fis, len); 
                pstmt.executeUpdate();
            }
            else { // TODO
                query = ("INSERT INTO " + Contract.KEYVALUETable + " VALUES (NULL)");
                pstmt = dbConnection.prepareStatement(query);
                pstmt.executeUpdate();
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (pstmt != null) {
                    pstmt.close();
            }

            if (dbConnection != null) {
                    dbConnection.close();
            }
        }
    }
    
    /* obter a imagem de um dado prato  */
    public byte[] getImage(int id) throws SQLException {
        byte[] fileBytes = null;
        String query;
        Connection dbConnection = null;
        Statement st = null;
        try {
            dbConnection = getDBConnection();
            query = "SELECT Prato_img FROM " + Contract.KEYVALUETable + " WHERE ID="+id;
            st = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                fileBytes = rs.getBytes(1);
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
        return fileBytes;
    }
    
    /* eliminar prato */
    public void deletePratoImage(int id) throws SQLException {
        String query;
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            query = "DELETE FROM "+Contract.KEYVALUETable + " WHERE ID="+id;
            st = dbConnection.prepareStatement(query);
            st.executeQuery();      
                         
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
    }

    /* atualizar pratos */
    public void updatePratoImg(int idPrato, String img) throws SQLException, FileNotFoundException {
        String query;
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            if (img != null) {
                File file = new File(img);
                FileInputStream fis = new FileInputStream(file);
                int len = (int)file.length();

                dbConnection = getDBConnection();
                query = "UPDATE "+ Contract.KEYVALUETable +" SET Prato_img=? Where ID=?";
                st = dbConnection.prepareStatement(query);
                st.setBinaryStream(1, fis, len); 
                st.setInt(2, idPrato);
                st.executeQuery();
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
    }
}
