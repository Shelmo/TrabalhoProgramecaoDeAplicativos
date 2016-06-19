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
public class JFrame_AlterarPedido extends JFrame_Pedido
{

    private final int select;
    private final TabelaPedido tabelaPedido;
    private ItensPedido itensPedido;
    private final Pedido pedido;

    public JFrame_AlterarPedido(int select, Pedido pedido, TabelaPedido tabelaPedido)
    {
        super("");
        this.select = select;
        this.tabelaPedido = tabelaPedido;
        this.pedido = pedido;

        getjPanel_SOUTH_EAST().add(getjButton_FecharPedido());
        getjLabel_Titulo().setText("Alterar Pedido");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        getjButton_Confirmar().setText("Alterar");

        getjComboBox_Cliente().setSelectedItem(pedido.getCliente());
        getjComboBox_Mesa().setSelectedItem(pedido.getMesa());

        pedido.getListItensPedidos().stream().forEach(getTabelaItensPedido()::Add);

        getjButton_Add().addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    LimparErros();
                    if (VerificarProduto())
                    {
                        itensPedido = new ItensPedido();
                        itensPedido.setProduto((Produto) getjComboBox_Produto().getSelectedItem());
                        itensPedido.setQuantidade((int) getjSpinner_Quantidade().getValue());
                        getTabelaItensPedido().Add(itensPedido);
                        getjComboBox_Produto().setSelectedIndex(0);
                        getjSpinner_Quantidade().setValue(1);
                    }
        });

        getjButton_Remove().addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    int selectt = getTabelaItensPedido().getSelectedRow();
                    if (selectt == -1)
                    {
                        JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
                        return;
                    }
                    getTabelaItensPedido().Remove(selectt);
        });

        getjButton_Search().addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    int selectt = getTabelaItensPedido().getSelectedRow();
                    if (selectt == -1)
                    {
                        JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
                        return;
                    }

                    new JFrame_LocalizarItensPedido(selectt, getTabelaItensPedido());
        });
        getjButton_FecharPedido().addActionListener((java.awt.event.ActionEvent evt)
                -> 
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
            pedido.setListItensPedidos(getTabelaItensPedido().getLista());
            DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.ATUALIZAR);
            tabelaPedido.update(pedido, select);
            dispose();
        }
    }

}
