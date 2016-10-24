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
    
    /* adicionar pratos */
    public boolean addPratoGrafosDB(Prato prato) throws SQLException {

        RelationalDB relDB = new RelationalDB();
        int idPrato = relDB.getIdPrato(prato);

        List<String> inserts = new ArrayList<>();

        List<String> ingredientes = prato.getAlimentos();
        List<String> quantidades = prato.getQuantidades();

        int idIngrediente = 0;
        String qtd;
        for (int i = 0; i < ingredientes.size(); i++) {
            idIngrediente = relDB.getIdAlimento(ingredientes.get(i));
            qtd = quantidades.get(i);
            if (!existsPratoIng(idPrato,idIngrediente))
                inserts.add(String.format("insert into "+Contract.GRAPHTable+" values(%d,%d,'%s');", idPrato, idIngrediente, qtd));
        }
        //adicionar
        
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            for (String insert : inserts) {
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

    private boolean existsPratoIng(int idPrato, int idIngrediente) throws SQLException {
        Connection dbConnection = null;
        Statement st = null;
        int countRows = 0;
        boolean exits=false;
        try {
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = "select quantidade from "+Contract.GRAPHTable+" where idPrato="+idPrato+" and idIngrediente="+idIngrediente;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                countRows++;
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
        if(countRows!=0){
            exits = true;
        }
            
        return exits;
    }
    
    public boolean existsIngEmPrato(int idIngrediente) throws SQLException {
        Connection dbConnection = null;
        Statement st = null;
        int countRows = 0;
        boolean exits=false;
        try {
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = "select idPrato,quantidade from "+Contract.GRAPHTable+" where idIngrediente="+idIngrediente;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                countRows++;
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
        if(countRows!=0){
            exits = true;
        }
            
        return exits;
    }
    
    /* eliminar pratos */
    public boolean deletePratoGraph(int id) throws SQLException {
        String query;
        Connection dbConnection = null;
        Statement st = null;
        try {
            dbConnection = getDBConnection();
            query = "DELETE FROM "+Contract.GRAPHTable+" WHERE idPrato="+id;
            st = dbConnection.createStatement();
            st.execute(query);        
                         
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
        return true;
    }
    
    /* eliminar ingrediente */
    public boolean deleteAlimentoGraph(int id) throws SQLException {
        String query;
        Connection dbConnection = null;
        Statement st = null;
        try {
            dbConnection = getDBConnection();
            query = "DELETE FROM "+Contract.GRAPHTable+" WHERE idIngrediente="+id;
            st = dbConnection.createStatement();
            st.execute(query);        
                         
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
        return true;
    }
    
    /**
     * @param ingredientes os id's dos ingredientes
     * @return uma lista com os id's dos pratos que contêem todos os
     * ingredientes
     */
    public List<Integer> pratoByIngredientes(List<Integer> ingredientes) {
        List<Integer> todosIds = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        Connection conn = getDBConnection();

        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = "select * from Prato_Alimentos ";

            rs = st.executeQuery(query);
            
            int pratoId = -1, ingredienteId;
            int pratoIdAnterior = -1;
           
            List<Integer> idsIngredientes = new ArrayList<>();
            
            while (rs.next()) {
                pratoId = Integer.parseInt(rs.getString("idPrato"));
                ingredienteId = Integer.parseInt(rs.getString("idIngrediente"));

                if (pratoId == pratoIdAnterior) {
                    idsIngredientes.add(ingredienteId);
                    pratoIdAnterior = pratoId;

                } else {

                    if (idsIngredientes.containsAll(ingredientes)) {
                        ids.add(pratoId);
                    }
                    idsIngredientes = new ArrayList<>();
                    pratoIdAnterior = pratoId;
                    idsIngredientes.add(ingredienteId);

                }
            }
            if (idsIngredientes.containsAll(ingredientes)) {
                ids.add(pratoId);
            }

        } catch (SQLException ex) {
        }

        return ids;

    }
    
    /* obter os ingredientes e respetiva quantidade de um dado prato */
    public Prato getIngredientesQuantidades(int id,Prato plate) throws SQLException {
        Connection dbConnection = null;
        Statement st = null;
        List<String> quantidades = new ArrayList<>();
        List<Integer> idIngredientes = new ArrayList<>();
        List<String> ingredientes = new ArrayList<>();
        try {
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String query = "select idIngrediente,quantidade from "+Contract.GRAPHTable+" where idPrato="+id;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int idIng = rs.getInt("idIngrediente");
                String quantidade = rs.getString("quantidade");
                idIngredientes.add(idIng);
                quantidades.add(quantidade);
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
        
        RelationalDB relDB = new RelationalDB();
        for(int idIng: idIngredientes)
            ingredientes.add(relDB.getNomeIng(idIng));
        plate.setAlimentos(ingredientes);
        plate.setQuantidades(quantidades);
        
        return plate;
    }

    /* atualizar prato */
    public boolean updatePratoGraph(int idPrato, Prato prato) throws SQLException {
        boolean update = deletePratoGraph(idPrato);
        update = addPratoGrafosDB(prato);
        return update;
    }
}
