package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Shelmo
 */
public class Conecta
{
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String db = "pizzaria";
    private String url = "jdbc:mysql://localhost:3306/" + db;
    private String username = "root";
    private String password = "29642119";
    private String sql = "";
    private PreparedStatement pStatement;
    private ResultSet rSet;
    private Connection c;
    private String msg;
    
    
    public Conecta()
    {
        msg = Conectar();
    }
    
    public Conecta(String database, String user, String pw)
    {
        url = database;
        username = user;
        password = pw;
        msg = Conectar();
    }
    
    private String Conectar()
    {
        try
        {
            Class.forName(this.DRIVER);
            c = DriverManager.getConnection(url, username, password);
            
            pStatement = c.prepareStatement(sql);
            
            return "Conectado!";
        }
        catch (ClassNotFoundException e)
        {
            this.c = null;
            return "Não foi possível encontrar o driver de banco: " + e.getMessage();
        }
        catch(SQLException sqlex)
        {
            return "Erro: " + sqlex.getMessage();
        }
    }
    
    public String pStmt(String sql)
    {
        try
        {            
            pStatement = c.prepareStatement(sql);
            
            return "Comando Executado!";
        }
        catch(SQLException sqlex)
        {
            return "Erro: " + sqlex.getMessage();
        }
    }
    
    public String Desconectar()
    {
        try
        {
            if(getConnection() != null)
            {
                getConnection().close();
                c = null;
            }
            if(getPreparedStatement() != null)
                pStatement = null;
            
            return "Desconectado!";
        }
        catch(SQLException sqlex)
        {
            return "Erro: " + sqlex.getMessage();
        }
    }
    
    public ResultSet getResultSet()
    {
        try
        {
            rSet = pStatement.getResultSet();
            return rSet;
        }
        catch(SQLException sqlex)
        {
            System.out.println("Erro: " + sqlex.getMessage());
            return null;
        }
    }
    
    public Connection getConnection()
    {
        return c;
    }
    
    public PreparedStatement getPreparedStatement()
    {
        return pStatement;
    }
    
    public String getMsg()
    {
        return msg;
    }
}
