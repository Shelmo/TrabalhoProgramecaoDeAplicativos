package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 *
 * @author Shelmo
 */

@Entity
@Table(name = "Cliente")
public class Cliente
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idCliente;
    
    @Column(name = "nome", length = 255, nullable = true)
    private String nomeCliente;
    
    @Column(name = "cpf", length = 14, nullable = true)
    private String cpfCliente;
    
    @Column(name = "cidade", length = 255)
    private String cidadeCliente;
    
    @Column(name = "bairro", length = 255)
    private String bairroCliente;
    
    @Column(name = "logradouro", length = 255)
    private String logradouroCliente;
    
    @Column(name = "numero")
    private int numeroCliente;
    
    @Column(name = "complemento", length = 255)
    private String complementoCliente;
    
    @Column(name = "cep", length = 10)
    private String cepCliente;
    
    @Column(name = "fone", length = 13)
    private String foneCliente;
    
    @Column(name = "celular", length = 13)
    private String celularCliente;
    
    @Column(name = "email", length = 255)
    private String emailCliente;
    
    @Column(name = "dataNasc")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimentoCliente;
    
    
    
    public Cliente(){}

    public Cliente(String nomeCliente, String cpfCliente, String cidadeCliente,
            String bairroCliente, String logradouroCliente,
            int numeroCliente, String complementoCliente, String cepCliente,
            String foneCliente, String celularCliente, String emailCliente,
            Date dataNascimentoCliente)
    {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.cidadeCliente = cidadeCliente;
        this.bairroCliente = bairroCliente;
        this.logradouroCliente = logradouroCliente;
        this.numeroCliente = numeroCliente;
        this.complementoCliente = complementoCliente;
        this.cepCliente = cepCliente;
        this.foneCliente = foneCliente;
        this.celularCliente = celularCliente;
        this.emailCliente = emailCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public int getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public String getNomeCliente()
    {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente)
    {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() 
    {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente)
    {
        this.cpfCliente = cpfCliente;
    }

    public String getCidadeCliente()
    {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente)
    {
        this.cidadeCliente = cidadeCliente;
    }

    public String getBairroCliente()
    {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente)
    {
        this.bairroCliente = bairroCliente;
    }

    public String getLogradouroCliente()
    {
        return logradouroCliente;
    }

    public void setLogradouroCliente(String logradouroCliente)
    {
        this.logradouroCliente = logradouroCliente;
    }

    public int getNumeroCliente()
    {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente)
    {
        this.numeroCliente = numeroCliente;
    }

    public String getComplementoCliente()
    {
        return complementoCliente;
    }

    public void setComplementoCliente(String complementoCliente)
    {
        this.complementoCliente = complementoCliente;
    }

    public String getCepCliente()
    {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente)
    {
        this.cepCliente = cepCliente;
    }

    public String getFoneCliente()
    {
        return foneCliente;
    }

    public void setFoneCliente(String foneCliente)
    {
        this.foneCliente = foneCliente;
    }

    public String getCelularCliente()
    {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente)
    {
        this.celularCliente = celularCliente;
    }

    public String getEmailCliente()
    {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente)
    {
        this.emailCliente = emailCliente;
    }

    public Date getDataNascimentoCliente()
    {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(Date dataNascimentoCliente)
    {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }
}
