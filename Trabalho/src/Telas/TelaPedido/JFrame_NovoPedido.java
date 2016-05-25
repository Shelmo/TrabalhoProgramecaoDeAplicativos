package Telas.TelaPedido;

import Tabelas.MontarTabelas;
import dao.DAO_Generalizado;
import java.util.Date;
import model.Cliente;
import model.ItensPedido;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovoPedido extends JFrame_Pedido
{
    public JFrame_NovoPedido()
    {
        super("");
        getjLabel_Titulo().setText("Novo Pedido");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
        getjButton_Add().addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LimparErros();
                if(VerificarProduto())
                {
                    ItensPedido itensPedido = new ItensPedido();
                    itensPedido.setProduto((Produto) getjComboBox_Produto().getSelectedItem());
                    itensPedido.setQuantidade((int) getjSpinner_Quantidade().getValue());
                    MontarTabelas.addItemPedido(itensPedido);
                    getjComboBox_Produto().setSelectedIndex(0);
                }
            }
        });
    }

    @Override
    public void Confirmar()
    {
        LimparErros();
        if(Verificacoes())
        {
            Pedido pedido = new Pedido();
            Date data = new Date();
            pedido.setCliente((Cliente) getjComboBox_Cliente().getSelectedItem());
            pedido.setMesa((String) getjComboBox_Mesa().getSelectedItem());
            pedido.setDataCadastro(data);
            int index = (int) DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.SALVAR);
            pedido.setIdPedido(index);
            MontarTabelas.addPedido(pedido);

            for(ItensPedido ip : MontarTabelas.getListaItensPedidos())
            {
                ip.setPedido(pedido);
                DAO_Generalizado.incluirAlterar(ip, DAO_Generalizado.SALVAR);
            }

            LimparCampos();
        }
    }
    
}
