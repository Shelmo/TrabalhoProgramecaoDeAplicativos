package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;
import util.Conecta;

/**
 *
 * @author Shelmo
 */
public class ProdutoDAO
{
    public static void incluirProduto(Produto prod)
    {
        Conecta conexao = new Conecta();
        String sql = "INSERT INTO Produto VALUES(NULL, ?, ?, ?, ?)";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setInt(1, prod.getIdCategoriaProduto());
            conexao.getPreparedStatement().setString(2, prod.getNomeProduto());
            conexao.getPreparedStatement().setString(3, prod.getDescricaoProduto());
            conexao.getPreparedStatement().setDouble(4, prod.getValorProduto());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void alterarProduto(Produto prod)
    {
        Conecta conexao = new Conecta();
        String sql = "UPDATE Produto SET idCategoria = ?, nome = ?, descricao = ?, valor = ? WHERE id = ?";
        
        conexao.pStmt(sql);
        
        try
        {
            conexao.getPreparedStatement().setInt(1, prod.getIdCategoriaProduto());
            conexao.getPreparedStatement().setString(2, prod.getNomeProduto());
            conexao.getPreparedStatement().setString(3, prod.getDescricaoProduto());
            conexao.getPreparedStatement().setDouble(4, prod.getValorProduto());
            conexao.getPreparedStatement().setInt(5, prod.getIdProduto());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
        
    }
    
    public static void excluirProduto(Produto prod)
    {
        Conecta conexao = new Conecta();
        String sql = "DELETE FROM Produto WHERE id = ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setInt(1, prod.getIdProduto());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static ArrayList<Produto> getListaProdutos()
    {
        Conecta conexao = new Conecta();
        ArrayList<Produto> listaProd = new ArrayList<>();
        Produto prod;
        try
        {
            ResultSet rSet = conexao.getPreparedStatement().executeQuery("SELECT * FROM Produto");
            for(;rSet.next();)
            {
                prod = new Produto();
                prod.setIdProduto(rSet.getInt("id"));
                prod.setIdCategoriaProduto(rSet.getInt("idCategoria"));
                prod.setNomeProduto(rSet.getString("nome"));
                prod.setDescricaoProduto(rSet.getString("descricao"));
                prod.setValorProduto(rSet.getDouble("valor"));
                listaProd.add(prod);
            }
            rSet.close();
            conexao.Desconectar();
            return listaProd;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaProd;
        }
    }
    
    public ArrayList<Produto> getListaProdutos(String filtroNomeProduto)
    {
        Conecta conexao = new Conecta();
        ArrayList<Produto> listaProd = new ArrayList<>();
        Produto prod;
        String sql = "SELECT * FROM Produto WHERE Produto.nome like ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, "%"+filtroNomeProduto+"%");
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                prod = new Produto();
                prod.setIdProduto(rSet.getInt("id"));
                prod.setIdCategoriaProduto(rSet.getInt("idCategoria"));
                prod.setNomeProduto(rSet.getString("nome"));
                prod.setDescricaoProduto(rSet.getString("descricao"));
                prod.setValorProduto(rSet.getDouble("valor"));
                listaProd.add(prod);
            }
            rSet.close();
            conexao.Desconectar();
            return listaProd;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaProd;
        }
    }
    
    public ArrayList<Produto> getListaProduto(String filtroDescricaoProduto)
    {
        Conecta conexao = new Conecta();
        ArrayList<Produto> listaProd = new ArrayList<>();
        Produto prod;
        String sql = "SELECT * FROM Produto WHERE Produto.descricao like ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, "%"+filtroDescricaoProduto+"%");
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                prod = new Produto();
                prod.setIdProduto(rSet.getInt("id"));
                prod.setIdCategoriaProduto(rSet.getInt("idCategoria"));
                prod.setNomeProduto(rSet.getString("nome"));
                prod.setDescricaoProduto(rSet.getString("descricao"));
                prod.setValorProduto(rSet.getDouble("valor"));
                listaProd.add(prod);
            }
            rSet.close();
            conexao.Desconectar();
            return listaProd;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaProd;
        }
    }
    
    public ArrayList<Produto> getListaProdutos(double filtroValorProduto)
    {
        Conecta conexao = new Conecta();
        ArrayList<Produto> listaProd = new ArrayList<>();
        Produto prod;
        String sql = "SELECT * FROM Produto WHERE Produto.valor like ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, "%"+filtroValorProduto+"%");
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                prod = new Produto();
                prod.setIdProduto(rSet.getInt("id"));
                prod.setIdCategoriaProduto(rSet.getInt("idCategoria"));
                prod.setNomeProduto(rSet.getString("nome"));
                prod.setDescricaoProduto(rSet.getString("descricao"));
                prod.setValorProduto(rSet.getDouble("valor"));
                listaProd.add(prod);
            }
            rSet.close();
            conexao.Desconectar();
            return listaProd;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaProd;
        }
    }
    
    public ArrayList<Produto> getListaProdutos(int filtroCategoriaProduto)
    {
        Conecta conexao = new Conecta();
        ArrayList<Produto> listaProd = new ArrayList<>();
        Produto prod;
        String sql = "SELECT * FROM Produto WHERE idCategoria = ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setInt(1, filtroCategoriaProduto);
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                prod = new Produto();
                prod.setIdProduto(rSet.getInt("id"));
                prod.setIdCategoriaProduto(rSet.getInt("idCategoria"));
                prod.setNomeProduto(rSet.getString("nome"));
                prod.setDescricaoProduto(rSet.getString("descricao"));
                prod.setValorProduto(rSet.getDouble("valor"));
                listaProd.add(prod);
            }
            rSet.close();
            conexao.Desconectar();
            return listaProd;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaProd;
        }
    }

    public int getIdProduto(String nomeProduto)
    {
        Conecta conexao = new Conecta();
        int nCat = -1;
        Produto prod = new Produto();
        try
        {
            ResultSet rSet = conexao.getPreparedStatement().executeQuery("SELECT * FROM Produto");
            for(;rSet.next();)
            {
                prod.setIdProduto(rSet.getInt("id"));
                prod.setNomeProduto(rSet.getString("nome"));
                if(nomeProduto.equalsIgnoreCase(prod.getNomeProduto()))
                {
                    nCat = prod.getIdProduto();
                    break;
                }
            }
            rSet.close();
            conexao.Desconectar();
            return nCat;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro!: " + ex.getMessage());
            conexao.Desconectar();
            return nCat;
        }
    }
    
    public Produto getProduto(String nomeProduto)
    {
        Conecta conexao = new Conecta();
        Produto prod = new Produto();
        conexao.pStmt("SELECT * FROM Produto WHERE nome = ?");
        try
        {
            conexao.getPreparedStatement().setString(1, nomeProduto);
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                prod.setIdProduto(rSet.getInt("id"));
                prod.setIdCategoriaProduto(rSet.getInt("idCategoria"));
                prod.setNomeProduto(rSet.getString("nome"));
                prod.setDescricaoProduto(rSet.getString("descricao"));
                prod.setValorProduto(rSet.getDouble("valor"));
            }
            rSet.close();
            conexao.Desconectar();
            return prod;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro!: " + ex.getMessage());
            conexao.Desconectar();
            return prod;
        }
    }
    
}
