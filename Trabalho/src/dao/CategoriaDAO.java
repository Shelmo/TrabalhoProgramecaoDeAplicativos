package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Categoria;
import util.Conecta;

/**
 *
 * @author Shelmo
 */
public class CategoriaDAO
{
    
    public static void incluirCategoria(Categoria cat)
    {
        Conecta conexao = new Conecta();
        String sql = "INSERT INTO Categoria VALUES(NULL, ?)";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, cat.getNomeCategoria());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void alterarCategoria(Categoria cat)
    {
        Conecta conexao = new Conecta();
        String sql = "UPDATE Categoria SET nome = ? WHERE id = ?";
        
        conexao.pStmt(sql);
        
        try
        {
            conexao.getPreparedStatement().setString(1, cat.getNomeCategoria());
            conexao.getPreparedStatement().setInt(2, cat.getIdCategoria());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
        
    }
    
    public static void excluirCategoria(Categoria cat)
    {
        Conecta conexao = new Conecta();
        String sql = "DELETE FROM Categoria WHERE id = ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setInt(1, cat.getIdCategoria());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static ArrayList<Categoria> getListaCategorias()
    {
        Conecta conexao = new Conecta();
        ArrayList<Categoria> listaCat = new ArrayList<Categoria>();
        Categoria cat = new Categoria();
        try
        {
            ResultSet rSet = conexao.getPreparedStatement().executeQuery("SELECT * FROM Categoria");
            for(;rSet.next();)
            {
                cat = new Categoria();
                cat.setIdCategoria(rSet.getInt("id"));
                cat.setNomeCategoria(rSet.getString("nome"));
                listaCat.add(cat);
            }
            rSet.close();
            conexao.Desconectar();
            return listaCat;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaCat;
        }
    }
    
    public ArrayList<Categoria> getListaCategorias(String filtroNomeCategoria)
    {
        Conecta conexao = new Conecta();
        ArrayList<Categoria> listaCat = new ArrayList<Categoria>();
        Categoria cat = new Categoria();
        String sql = "SELECT * FROM Categoria WHERE Categoria.nome like ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, "%"+filtroNomeCategoria+"%");
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                cat = new Categoria();
                cat.setIdCategoria(rSet.getInt("id"));
                cat.setNomeCategoria(rSet.getString("nome"));
                listaCat.add(cat);
            }
            rSet.close();
            conexao.Desconectar();
            return listaCat;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaCat;
        }
    }
    
}