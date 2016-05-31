package Telas.TelaCliente;

import Tabelas.TabelaCliente;
import dao.DAO_Generalizado;
import java.text.SimpleDateFormat;
import model.Cliente;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverCliente extends JFrame_Cliente
{
    private final Cliente cliente;
    private final int select;
    private final TabelaCliente tabelaCliente;
    
    public JFrame_RemoverCliente(int select, Cliente cliente, TabelaCliente tabelaCliente)
    {
        super();
        this.cliente = cliente;
        this.select = select;
        this.tabelaCliente = tabelaCliente;
        
        getjLabel_Titulo().setText("Remover Cliente");
        getjLabel_Aviso().setText("Deseja realmente remover esse Cliente?");
        getjButton_Confirmar().setText("Remover");
        
        getjTextField_Nome().setText(this.cliente.getNomeCliente());
        getjFormattedTextField_CPF().setText(this.cliente.getCpfCliente());
        if(cliente.getDataNascimentoCliente() != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String format = sdf.format(this.cliente.getDataNascimentoCliente());
            getjFormattedTextField_DataNasc().setText(format);
        }
        getjTextField_Cidade().setText(this.cliente.getCidadeCliente());
        getjTextField_Bairro().setText(this.cliente.getBairroCliente());
        getjTextField_Logradouro().setText(this.cliente.getLogradouroCliente());
        getjTextField_Numero().setText(String.valueOf(this.cliente.getNumeroCliente()));
        getjTextField_Complemento().setText(this.cliente.getComplementoCliente());
        getjFormattedTextField_CEP().setText(this.cliente.getCepCliente());
        getjFormattedTextField_Fone().setText(this.cliente.getFoneCliente());
        getjFormattedTextField_Celular().setText(this.cliente.getCelularCliente());
        getjTextField_Email().setText(this.cliente.getEmailCliente());
        
        getjFormattedTextField_CEP().setEditable(false);
        getjFormattedTextField_CPF().setEditable(false);
        getjFormattedTextField_Celular().setEditable(false);
        getjFormattedTextField_DataNasc().setEditable(false);
        getjFormattedTextField_Fone().setEditable(false);
        getjTextField_Bairro().setEditable(false);
        getjTextField_Cidade().setEditable(false);
        getjTextField_Complemento().setEditable(false);
        getjTextField_Email().setEditable(false);
        getjTextField_Logradouro().setEditable(false);
        getjTextField_Nome().setEditable(false);
        getjTextField_Numero().setEditable(false);
    }
    
    @Override
    public void Confirmar()
    {
        DAO_Generalizado.remover(cliente);
        tabelaCliente.Remove(select);
        dispose();
    }
}
