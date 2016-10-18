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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class GraphDB {
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_CONNECTION = "jdbc:sqlserver://DESKTOP-8HJ3B7P:1433;databaseName=NutriDB_Graphs";
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
    
    public boolean addPratoGrafosDB(Prato prato) throws SQLException {

        RelationalDB relDB = new RelationalDB();
        int idPrato = relDB.getIdPrato(prato);

        List<String> inserts = new ArrayList<>();

        List<String> ingredientes = prato.getIngredientes();
        List<String> quantidades = prato.getQuantidades();

        int idIngrediente = 0;
        String qtd;
        for (int i = 0; i < ingredientes.size(); i++) {
            idIngrediente = relDB.getIdAlimento(ingredientes.get(i));
            qtd = quantidades.get(i);

            inserts.add(String.format("insert into "+Contract.GRAPHTable+" values(%d,%d,'%s');", idPrato, idIngrediente, qtd));
        }
        System.out.println(idIngrediente);
        //adicionar
        
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            for (String insert : inserts) {
                System.out.println(insert);
                st = dbConnection.prepareStatement(insert);
                st.executeUpdate();
            }
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
    
    
}
