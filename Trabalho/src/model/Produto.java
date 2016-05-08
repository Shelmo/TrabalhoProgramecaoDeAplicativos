package model;

/**
 *
 * @author Shelmo
 */
public class Produto
{
    private int idProduto;
    private int idCategoriaProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double valorProduto;
    
    public Produto(){}

    public Produto(int idCategoriaProduto, String nomeProduto, String descricaoProduto, double valorProduto)
    {
        this.idCategoriaProduto = idCategoriaProduto;
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

    public int getIdCategoriaProduto()
    {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(int idCategoriaProduto)
    {
        this.idCategoriaProduto = idCategoriaProduto;
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
}
