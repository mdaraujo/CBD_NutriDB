/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Data.Alimento;
import Data.Prato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            String query = "select ID from " + Contract.PratoTable + " where Nome=?";
            st = dbConnection.prepareStatement(query);
            st.setString(1, prato.getNome());
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

        if (id == -1) {
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
            String query = "select ID from " + Contract.AlimentoTable + " where Nome='" + nome + "'";
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

        if (id == -1) {
            addAlimento(nome);
            return getIdAlimento(nome);
        }

        return id;
    }
    
    /* inserir pratos */
    public boolean addPrato(Prato prato) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            String query = "insert into " + Contract.PratoTable + " (Nome,Descricao) values(?,?)";
            st = dbConnection.prepareStatement(query);
            st.setString(1, prato.getNome());
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
    
    /* inserir alimentos */
    public boolean addAlimento(String nome) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            String query = "insert into " + Contract.AlimentoTable + " (Nome) values (?)";
            st = dbConnection.prepareStatement(query);
            st.setString(1,nome);
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
    
    /* inserir alimentos */
    public boolean addAlimento(Alimento alimento) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            String query = "insert into " + Contract.AlimentoTable + " (Nome, Humidade_perc, Energia_kcal, Proteina_g, Lipidos_g, Colestrol_mg, HidratosDeCarb_g, FibraAlimentar_g, Categoria) values(?,?,?,?,?,?,?,?,?)";
            st = dbConnection.prepareStatement(query);
            st.setString(1, alimento.getNome());
            st.setFloat(2, alimento.getHumidade());
            st.setInt(3, alimento.getEnergia());
            st.setFloat(4, alimento.getProteina());
            st.setFloat(5, alimento.getLipidos());
            st.setInt(6, alimento.getColestrol());
            st.setFloat(7, alimento.getHidratos());
            st.setFloat(8, alimento.getFibra());
            st.setString(9, alimento.getCategoria());
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
    
    /* atualizar alimento */
    public boolean updateAlimento(Alimento alimento) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            String query = "UPDATE " + Contract.AlimentoTable + " SET Nome=?, Humidade_perc=?, Energia_kcal=?, Proteina_g=?, Lipidos_g=?, Colestrol_mg=?, HidratosDeCarb_g=?, FibraAlimentar_g=?, Categoria=? WHERE ID=?";
            st = dbConnection.prepareStatement(query);
            st.setInt(10, alimento.getID());
            st.setString(1, alimento.getNome());
            st.setFloat(2, alimento.getHumidade());
            st.setInt(3, alimento.getEnergia());
            st.setFloat(4, alimento.getProteina());
            st.setFloat(5, alimento.getLipidos());
            st.setInt(6, alimento.getColestrol());
            st.setFloat(7, alimento.getHidratos());
            st.setFloat(8, alimento.getFibra());
            st.setString(9, alimento.getCategoria());
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
    
    /* eliminar alimento */
    public boolean deleteAlimento(int id) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            String query = "DELETE FROM " + Contract.AlimentoTable + " WHERE ID=?";
            st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
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
    
    public Alimento getAlimento(int id) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        Alimento alimento = null;

        try {
            dbConnection = getDBConnection();
            String query = "SELECT * FROM Alimentos WHERE ID = ?";
            st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                String nome = rs.getString("Nome");
                float humidade = rs.getFloat("Humidade_perc");
                int energia = rs.getInt("Energia_kcal");
                float proteina = rs.getFloat("Proteina_g");
                float lipidos = rs.getFloat("Lipidos_g");
                int colestrol = rs.getInt("Colestrol_mg");
                float hidratos = rs.getFloat("HidratosDeCarb_g");
                float fibra = rs.getFloat("FibraAlimentar_g");
                String categoria = rs.getString("Categoria");
                
                alimento = new Alimento(id, nome, humidade, energia, proteina, lipidos, colestrol, hidratos, fibra, categoria);
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

        return alimento;
    }
    
    /* obter informações sobre o prato */
    public Prato getPrato(int id) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement st = null;
        Prato prato = null;

        try {
            dbConnection = getDBConnection();
            String query = "SELECT * FROM Pratos WHERE ID = ?";
            st = dbConnection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                String nome = rs.getString("Nome");
                String descricao = rs.getString("Descricao");

                prato = new Prato(id, nome, descricao);
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
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(selectSQL);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String desc = rs.getString("Descricao");

                Prato prato = new Prato(id, nome, desc);
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
    
    public DefaultListModel selectAlimentos(String selectSQL) throws SQLException {

        Connection dbConnection = null;
        Statement st = null;
        DefaultListModel listModel = new DefaultListModel();

        String header = String.format("%-4s %-70s %-8s %-6s %-8s %-7s %-9s %-8s %-7s %-20s", "ID", "NOME", "HUMIDADE", "ENEGIA", "PROTEINA", "LIPIDOS", "COLESTROL", "HIDRATOS", "FIBRA", "CATEGORIA");
        listModel.addElement(header);
        
        try {

            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(selectSQL);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                float humidade = rs.getFloat("Humidade_perc");
                int energia = rs.getInt("Energia_kcal");
                float proteina = rs.getFloat("Proteina_g");
                float lipidos = rs.getFloat("Lipidos_g");
                int colestrol = rs.getInt("Colestrol_mg");
                float hidratos = rs.getFloat("HidratosDeCarb_g");
                float fibra = rs.getFloat("FibraAlimentar_g");
                String categoria = rs.getString("Categoria");
                
                Alimento alimento = new Alimento(id, nome, humidade, energia, proteina, lipidos, colestrol, hidratos, fibra, categoria);
                listModel.addElement(alimento.toString());
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
    
    /* eliminar prato */
    public boolean deletePratoRelational(int id) throws SQLException {
        String query;
        Connection dbConnection = null;
        Statement st = null;
        try {
            dbConnection = getDBConnection();
            query = "DELETE FROM "+Contract.PratoTable + " WHERE ID="+id;
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
    
    /* obter o nome do ingrediente */
    public String getNomeIng(int id) throws SQLException {
        Connection dbConnection = null;
        Statement st = null;
        String nome = null;

        try {
            
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM "+Contract.AlimentoTable+" WHERE ID ="+id;
            ResultSet rs = st.executeQuery(query);
            
            
            while (rs.next()) {
                nome = rs.getString("Nome");
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
        return nome;
    }
    
    /* atualizar pratos */
    public boolean updatePrato(int idPrato, String nome, String descricao) throws SQLException {
        String query;
        Connection dbConnection = null;
        PreparedStatement st = null;
        try {
            dbConnection = getDBConnection();
            query = "UPDATE "+ Contract.PratoTable +" SET Nome=?,Descricao=? WHERE ID=?";
            st = dbConnection.prepareStatement(query);
            st.setString(1, nome);
            st.setString(2, descricao);
            st.setInt(3, idPrato);
            st.executeUpdate();
                         
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
     * 
     * @param ingrediente
     * @return lista de ingredientes (string) que contêem o nome do ingrediente 
     * (dado como parametro)
     */
    public List<String> getIngredientes(String ingrediente) throws SQLException{
        List<String> ingredientes = new ArrayList<>();
        
        Connection dbConnection = null;
        Statement st = null;
        
        try {
            
            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT Nome FROM " + Contract.AlimentoTable+" WHERE Nome LIKE '%"+ingrediente+"%'";
            ResultSet rs = st.executeQuery(query);
            
            
            while (rs.next()) {
                ingredientes.add(rs.getString("Nome"));
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
        return ingredientes;
    }
    
    // Not Used
    public DefaultListModel selectPratosLM(String selectSQL) throws SQLException {

        Connection dbConnection = null;
        Statement st = null;
        DefaultListModel listModel = new DefaultListModel();

        try {

            dbConnection = getDBConnection();
            st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(selectSQL);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String desc = rs.getString("Descricao");

                Prato prato = new Prato(id, nome, desc);

                listModel.addElement(prato.toString());
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
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}
