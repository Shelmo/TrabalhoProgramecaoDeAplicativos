package model;

import java.io.Serializable;
import java.util.Objects;
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
public class Categoria implements Serializable
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

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nomeCategoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.nomeCategoria, other.nomeCategoria);
    }
    
    
}
