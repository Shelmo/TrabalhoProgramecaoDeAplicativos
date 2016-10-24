package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Shelmo
 */
@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idPedido;
    
    @Column(name = "dataCadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @Column(name = "mesa")
    private String mesa;
    
    @Column(name = "situacao")
    private String situacao;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @OneToMany (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="idPedido")
    @Fetch(FetchMode.JOIN)
    private List<ItensPedido> listItensPedidos = new ArrayList<>();

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

    public String getSituacao()
    {
        return situacao;
    }

    public void setListItensPedidos(List<ItensPedido> listItensPedidos)
    {
        this.listItensPedidos = listItensPedidos;
    }

    public List<ItensPedido> getListItensPedidos()
    {
        return listItensPedidos;
    }

    public void setSituacao(String situacao)
    {
        this.situacao = situacao;
    }
}
