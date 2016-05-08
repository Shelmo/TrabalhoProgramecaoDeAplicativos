package model;

/**
 *
 * @author Shelmo
 */
public class Categoria
{
    private int idCategoria;
    private String nomeCategoria;
    
    public Categoria(){}

    public Categoria(String nomeCategoria)
    {
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdCategoria()
    {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria)
    {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria()
    {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria)
    {
        this.nomeCategoria = nomeCategoria;
    }
    
    @Override
    public String toString()
    {
        return nomeCategoria;
    }
}
