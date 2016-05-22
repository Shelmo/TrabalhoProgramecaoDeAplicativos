package model;

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
@Table(name = "Produto")
public class Produto
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idProduto;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    
    @Column(name = "nome", length = 255, nullable = true)
    private String nomeProduto;
    
    @Column(name = "descricao", length = 255)
    private String descricaoProduto;
    
    @Column(name = "valor", nullable = true)
    private double valorProduto;
    
    public Produto(){}

    public Produto(Categoria categoria, String nomeProduto, String descricaoProduto, double valorProduto)
    {
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
    }

    public int getIdProduto()
    {
        return idProduto;
    }

    public void setIdProduto(int idProduto)
    {
        this.idProduto = idProduto;
    }

    public Categoria getCategoria()
    {
        return categoria;
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }

    public String getNomeProduto()
    {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto)
    {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto()
    {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto)
    {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValorProduto()
    {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto)
    {
        this.valorProduto = valorProduto;
    }
    
    @Override
    public String toString()
    {
        return  nomeProduto;
    }
}
