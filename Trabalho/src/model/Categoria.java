package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Shelmo
 */

@Entity
@Table(name = "Categoria")
public class Categoria
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idCategoria;
    
    @Column(name = "nome", length = 255, nullable = true)
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
