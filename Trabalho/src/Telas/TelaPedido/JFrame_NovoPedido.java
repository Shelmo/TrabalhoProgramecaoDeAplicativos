package Telas.TelaPedido;

import Tabelas.TabelaPedido;
import dao.DAO_Generalizado;
import java.util.Date;
import javax.swing.JOptionPane;
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

    private final TabelaPedido tabelaPedido;
    private ItensPedido itensPedido;
    private Pedido pedido = new Pedido();

    public JFrame_NovoPedido(TabelaPedido tabelaPedido)
    {
        super("");
        this.tabelaPedido = tabelaPedido;

        getjPanel_SOUTH_EAST().add(getjButton_FecharPedido());
        getjLabel_Titulo().setText("Novo Pedido");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
        getjButton_Add().addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    LimparErros();
                    if (VerificarProduto())
                    {
                        itensPedido = new ItensPedido();
                        itensPedido.setProduto((Produto) getjComboBox_Produto().getSelectedItem());
                        itensPedido.setQuantidade((int) getjSpinner_Quantidade().getValue());
                        pedido.getListItensPedidos().add(itensPedido);
                        getTabelaItensPedido().Add(itensPedido);
                        getjComboBox_Produto().setSelectedIndex(0);
                        getjSpinner_Quantidade().setValue(1);
                    }
        });

        getjButton_Remove().addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    int select = getTabelaItensPedido().getSelectedRow();
                    if (select == -1)
                    {
                        JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
                        return;
                    }
                    getTabelaItensPedido().Remove(select);
        });
        
        getjButton_Search().addActionListener((java.awt.event.ActionEvent evt) ->
        {
            int select = getTabelaItensPedido().getSelectedRow();
            if (select == -1)
            {
                JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
                return;
            }
            
            new JFrame_LocalizarItensPedido(select, getTabelaItensPedido());
        });
        getjButton_FecharPedido().addActionListener((java.awt.event.ActionEvent evt) ->
        {
            this.pedido.setSituacao("F");
            this.pedido.setDataFechamento(new Date());
            Confirmar();
        });
    }

    @Override
    public void Confirmar()
    {
        LimparErros();
        if (Verificacoes())
        {
            pedido.setCliente((Cliente) getjComboBox_Cliente().getSelectedItem());
            pedido.setMesa((String) getjComboBox_Mesa().getSelectedItem());
            pedido.setDataCadastro(new Date());
            pedido.setSituacao("A");
            int index = (int) DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.SALVAR);
            pedido.setIdPedido(index);
            tabelaPedido.Add(pedido);

            getTabelaItensPedido().clearTable();
            LimparCampos();
        }
    }

}
