package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Shelmo
 */

@Entity
@Table(name = "ItensPedido")
public class ItensPedido implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idItensPedido;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduto")
    private Produto produto;
    
    @Column(name = "quantidade", nullable = true)
    private int quantidade;

    public int getIdItensPedido()
    {
        return idItensPedido;
    }

    public void setIdItensPedido(int idItensPedido)
    {
        this.idItensPedido = idItensPedido;
    }

    public Produto getProduto()
    {
        return produto;
    }

    public void setProduto(Produto produto)
    {
        this.produto = produto;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
}
