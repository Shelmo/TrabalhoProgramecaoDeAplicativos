package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import util.Conecta;

/**
 *
 * @author Shelmo
 */
public class ClienteDAO
{
    public static void incluirCliente(Cliente cli)
    {
        Conecta conexao = new Conecta();
        String sql = "INSERT INTO Cliente VALUES(NULL, ?, ?, ?, ?, ?, ?, ?,"
                + "?, ?, ?, ?, ?)";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, cli.getNomeCliente());
            conexao.getPreparedStatement().setString(2, cli.getCpfCliente());
            conexao.getPreparedStatement().setString(3, cli.getCidadeCliente());
            conexao.getPreparedStatement().setString(4, cli.getBairroCliente());
            conexao.getPreparedStatement().setString(5, cli.getLogradouroCliente());
            conexao.getPreparedStatement().setInt(6, cli.getNumeroCliente());
            conexao.getPreparedStatement().setString(7, cli.getComplementoCliente());
            conexao.getPreparedStatement().setString(8, cli.getCepCliente());
            conexao.getPreparedStatement().setString(9, cli.getFoneCliente());
            conexao.getPreparedStatement().setString(10, cli.getCelularCliente());
            conexao.getPreparedStatement().setString(11, cli.getEmailCliente());
            conexao.getPreparedStatement().setDate(12, cli.getDataNascimentoCliente());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void alterarCliente(Cliente cli)
    {
        Conecta conexao = new Conecta();
        String sql = "UPDATE Cliente SET nome = ?, cpf = ?, cidade = ?,"
                + "bairro = ?, logradouro = ?, numero = ?, complemento = ?,"
                + "CEP = ?, fone = ?, celular=?, email = ?, dataNasc = ? "
                + "WHERE id = ?";
        
        conexao.pStmt(sql);
        
        try
        {
            conexao.getPreparedStatement().setString(1, cli.getNomeCliente());
            conexao.getPreparedStatement().setString(2, cli.getCpfCliente());
            conexao.getPreparedStatement().setString(3, cli.getCidadeCliente());
            conexao.getPreparedStatement().setString(4, cli.getBairroCliente());
            conexao.getPreparedStatement().setString(5, cli.getLogradouroCliente());
            conexao.getPreparedStatement().setInt(6, cli.getNumeroCliente());
            conexao.getPreparedStatement().setString(7, cli.getComplementoCliente());
            conexao.getPreparedStatement().setString(8, cli.getCepCliente());
            conexao.getPreparedStatement().setString(9, cli.getFoneCliente());
            conexao.getPreparedStatement().setString(10, cli.getCelularCliente());
            conexao.getPreparedStatement().setString(11, cli.getEmailCliente());
            conexao.getPreparedStatement().setDate(12, cli.getDataNascimentoCliente());
            conexao.getPreparedStatement().setInt(13, cli.getIdCliente());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
        
    }
    
    public static void excluirCliente(Cliente cli)
    {
        Conecta conexao = new Conecta();
        String sql = "DELETE FROM Cliente WHERE id = ?";
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setInt(1, cli.getIdCliente());
            conexao.getPreparedStatement().execute();
            conexao.Desconectar();
        }
        catch (SQLException ex)
        {
            conexao.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static ArrayList<Cliente> getListaCliente()
    {
        Conecta conexao = new Conecta();
        ArrayList<Cliente> listaCli = new ArrayList<>();
        Cliente cli;
        try
        {
            ResultSet rSet = conexao.getPreparedStatement().executeQuery("SELECT * FROM Cliente");
            for(;rSet.next();)
            {
                cli = new Cliente();
                cli.setIdCliente(rSet.getInt("id"));
                cli.setNomeCliente(rSet.getString("nome"));
                cli.setCpfCliente(rSet.getString("cpf"));
                cli.setCidadeCliente(rSet.getString("cidade"));
                cli.setBairroCliente(rSet.getString("bairro"));
                cli.setLogradouroCliente(rSet.getString("logradouro"));
                cli.setNumeroCliente(rSet.getInt("numero"));
                cli.setComplementoCliente(rSet.getString("complemento"));
                cli.setCepCliente(rSet.getString("CEP"));
                cli.setFoneCliente(rSet.getString("fone"));
                cli.setCelularCliente(rSet.getString("celular"));
                cli.setEmailCliente(rSet.getString("email"));
                cli.setDataNascimentoCliente(rSet.getDate("dataNasc"));
                listaCli.add(cli);
            }
            rSet.close();
            conexao.Desconectar();
            return listaCli;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaCli;
        }
    }
    
    public ArrayList<Cliente> getListaCliente(String filtroNomeCliente, int select)
    {
        Conecta conexao = new Conecta();
        ArrayList<Cliente> listaCli = new ArrayList<>();
        Cliente cli;
        
        String sql = "SELECT * FROM Cliente WHERE Cliente.nome like ?";
        if(select == 1)
            sql = "SELECT * FROM Cliente WHERE Cliente.cpf like ?";
        if(select == 2)
            sql = "SELECT * FROM Cliente WHERE Cliente.cidade like ?";
        if(select == 3)
            sql = "SELECT * FROM Cliente WHERE Cliente.bairro like ?";
        if(select == 4)
            sql = "SELECT * FROM Cliente WHERE Cliente.logradouro like ?";
        if(select == 5)
            sql = "SELECT * FROM Cliente WHERE Cliente.complemento like ?";
        if(select == 6)
            sql = "SELECT * FROM Cliente WHERE Cliente.CEP like ?";
        if(select == 7)
            sql = "SELECT * FROM Cliente WHERE Cliente.fone like ?";
        if(select == 8)
            sql = "SELECT * FROM Cliente WHERE Cliente.celular like ?";
        if(select == 9)
            sql = "SELECT * FROM Cliente WHERE Cliente.email like ?";
        
        
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setString(1, "%"+filtroNomeCliente+"%");
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                cli = new Cliente();
                cli.setIdCliente(rSet.getInt("id"));
                cli.setNomeCliente(rSet.getString("nome"));
                cli.setCpfCliente(rSet.getString("cpf"));
                cli.setCidadeCliente(rSet.getString("cidade"));
                cli.setBairroCliente(rSet.getString("bairro"));
                cli.setLogradouroCliente(rSet.getString("logradouro"));
                cli.setNumeroCliente(rSet.getInt("numero"));
                cli.setComplementoCliente(rSet.getString("complemento"));
                cli.setCepCliente(rSet.getString("CEP"));
                cli.setFoneCliente(rSet.getString("fone"));
                cli.setCelularCliente(rSet.getString("celular"));
                cli.setEmailCliente(rSet.getString("email"));
                cli.setDataNascimentoCliente(rSet.getDate("dataNasc"));
                listaCli.add(cli);
            }
            rSet.close();
            conexao.Desconectar();
            return listaCli;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaCli;
        }
    }
    
    public ArrayList<Cliente> getListaCliente(int filtroNumeroCliente)
    {
        Conecta conexao = new Conecta();
        ArrayList<Cliente> listaCli = new ArrayList<>();
        Cliente cli;
        
        String sql = "SELECT * FROM Cliente WHERE numero = ?";
        
        
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setInt(1, filtroNumeroCliente);
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                cli = new Cliente();
                cli.setIdCliente(rSet.getInt("id"));
                cli.setNomeCliente(rSet.getString("nome"));
                cli.setCpfCliente(rSet.getString("cpf"));
                cli.setCidadeCliente(rSet.getString("cidade"));
                cli.setBairroCliente(rSet.getString("bairro"));
                cli.setLogradouroCliente(rSet.getString("logradouro"));
                cli.setNumeroCliente(rSet.getInt("numero"));
                cli.setComplementoCliente(rSet.getString("complemento"));
                cli.setCepCliente(rSet.getString("CEP"));
                cli.setFoneCliente(rSet.getString("fone"));
                cli.setCelularCliente(rSet.getString("celular"));
                cli.setEmailCliente(rSet.getString("email"));
                cli.setDataNascimentoCliente(rSet.getDate("dataNasc"));
                listaCli.add(cli);
            }
            rSet.close();
            conexao.Desconectar();
            return listaCli;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaCli;
        }
    }
    
    public ArrayList<Cliente> getListaCliente(Date filtroDataCliente)
    {
        Conecta conexao = new Conecta();
        ArrayList<Cliente> listaCli = new ArrayList<>();
        Cliente cli;
        
        String sql = "SELECT * FROM Cliente WHERE dataNasc = ?";
        
        
        conexao.pStmt(sql);
        try
        {
            conexao.getPreparedStatement().setDate(1, filtroDataCliente);
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                cli = new Cliente();
                cli.setIdCliente(rSet.getInt("id"));
                cli.setNomeCliente(rSet.getString("nome"));
                cli.setCpfCliente(rSet.getString("cpf"));
                cli.setCidadeCliente(rSet.getString("cidade"));
                cli.setBairroCliente(rSet.getString("bairro"));
                cli.setLogradouroCliente(rSet.getString("logradouro"));
                cli.setNumeroCliente(rSet.getInt("numero"));
                cli.setComplementoCliente(rSet.getString("complemento"));
                cli.setCepCliente(rSet.getString("CEP"));
                cli.setFoneCliente(rSet.getString("fone"));
                cli.setCelularCliente(rSet.getString("celular"));
                cli.setEmailCliente(rSet.getString("email"));
                cli.setDataNascimentoCliente(rSet.getDate("dataNasc"));
                listaCli.add(cli);
            }
            rSet.close();
            conexao.Desconectar();
            return listaCli;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            conexao.Desconectar();
            return listaCli;
        }
    }

    public int getIdCliente(String nomeCliente)
    {
        Conecta conexao = new Conecta();
        int nCat = -1;
        Cliente cli = new Cliente();
        try
        {
            ResultSet rSet = conexao.getPreparedStatement().executeQuery("SELECT * FROM Cliente");
            for(;rSet.next();)
            {
                cli.setIdCliente(rSet.getInt("id"));
                cli.setNomeCliente(rSet.getString("nome"));
                if(nomeCliente.equalsIgnoreCase(cli.getNomeCliente()))
                {
                    nCat = cli.getIdCliente();
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
    
    public Cliente getCliente(String nomeCliente)
    {
        Conecta conexao = new Conecta();
        Cliente cli = new Cliente();
        conexao.pStmt("SELECT * FROM Cliente WHERE nome = ?");
        try
        {
            conexao.getPreparedStatement().setString(1, nomeCliente);
            ResultSet rSet = conexao.getPreparedStatement().executeQuery();
            for(;rSet.next();)
            {
                cli.setIdCliente(rSet.getInt("id"));
                cli.setNomeCliente(rSet.getString("nome"));
                cli.setCpfCliente(rSet.getString("cpf"));
                cli.setCidadeCliente(rSet.getString("cidade"));
                cli.setBairroCliente(rSet.getString("bairro"));
                cli.setLogradouroCliente(rSet.getString("logradouro"));
                cli.setNumeroCliente(rSet.getInt("numero"));
                cli.setComplementoCliente(rSet.getString("complemento"));
                cli.setCepCliente(rSet.getString("CEP"));
                cli.setFoneCliente(rSet.getString("fone"));
                cli.setCelularCliente(rSet.getString("celular"));
                cli.setEmailCliente(rSet.getString("email"));
                cli.setDataNascimentoCliente(rSet.getDate("dataNasc"));
            }
            rSet.close();
            conexao.Desconectar();
            return cli;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro!: " + ex.getMessage());
            conexao.Desconectar();
            return cli;
        }
    }
}
