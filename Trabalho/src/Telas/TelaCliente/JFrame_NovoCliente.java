package Telas.TelaCliente;

import Tabelas.TabelaCliente;
import dao.DAO_Generalizado;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Cliente;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovoCliente extends JFrame_Cliente
{
    private final TabelaCliente tabelaCliente;
    
    public JFrame_NovoCliente(TabelaCliente tabelaCliente)
    {
        super();
        this.tabelaCliente = tabelaCliente;
        getjLabel_Titulo().setText("Novo Cliente");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
    }
    
    @Override
    public void Confirmar()
    {
        LimparErros();
        
        if(Verificacoes())
        {
            Cliente cliente = new Cliente();

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
            
            int id = (int) DAO_Generalizado.incluirAlterar(cliente, DAO_Generalizado.SALVAR);
            cliente.setIdCliente(id);
            tabelaCliente.Add(cliente);
            LimparCampos();
        }
    }
    
}
