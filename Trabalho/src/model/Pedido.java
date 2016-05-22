package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Shelmo
 */
@Entity
@Table(name = "Pedido")
public class Pedido
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idPedido;
    
    @Column(name = "dataCadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @Column(name = "mesa", length = 3)
    private String mesa;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public int getIdPedido()
    {
        return idPedido;
    }

    public void setIdPedido(int idPedido)
    {
        this.idPedido = idPedido;
    }

    public Date getDataCadastro()
    {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }

    public String getMesa()
    {
        return mesa;
    }

    public void setMesa(String mesa)
    {
        this.mesa = mesa;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }
}
