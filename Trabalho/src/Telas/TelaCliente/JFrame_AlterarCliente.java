package Telas.TelaCliente;

import Tabelas.MontarTabelas;
import dao.ClienteDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Cliente;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarCliente extends JFrame_Cliente
{
    private final Cliente cliente;
    private final int select;
    
    public JFrame_AlterarCliente(int select, Cliente cliente)
    {
        super(null);
        this.cliente = cliente;
        this.select = select;
        
        getjLabel_Titulo().setText("Alterar Cliente");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        getjButton_Confirmar().setText("Alterar");
        
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
    }
    
    @Override
    public void Confirmar()
    {
        LimparErros();
        if(Verificacoes())
        {
            cliente.setNomeCliente(getjTextField_Nome().getText());
            cliente.setCpfCliente(getjFormattedTextField_CPF().getText());
            cliente.setCidadeCliente(getjTextField_Cidade().getText());
            cliente.setBairroCliente(getjTextField_Bairro().getText());
            cliente.setLogradouroCliente(getjTextField_Logradouro().getText());
            cliente.setComplementoCliente(getjTextField_Complemento().getText());
            cliente.setCepCliente(getjFormattedTextField_CEP().getText());
            cliente.setFoneCliente(getjFormattedTextField_Fone().getText());
            cliente.setCelularCliente(getjFormattedTextField_Celular().getText());
            cliente.setEmailCliente(getjTextField_Email().getText());

            try
            {
                cliente.setNumeroCliente(Integer.parseInt(getjTextField_Numero().getText()));
            }
            catch(NumberFormatException ex){}
            
            try
            {
                java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(getjFormattedTextField_DataNasc().getText());
                Date data = new Date(dataUtil.getTime());
                cliente.setDataNascimentoCliente(data);
            }
            catch (ParseException ex){}
            
            ClienteDAO.alterarCliente(cliente);
            MontarTabelas.updateCliente(select, cliente);
            dispose();
        }
    }
}
