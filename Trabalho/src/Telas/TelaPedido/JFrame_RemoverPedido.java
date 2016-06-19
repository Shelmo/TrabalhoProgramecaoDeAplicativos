package Telas.TelaPedido;

import Tabelas.TabelaPedido;
import dao.DAO_Generalizado;
import model.Pedido;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverPedido extends JFrame_Pedido
{
    private final int select;
    private final TabelaPedido tabelaPedido;
    private final Pedido pedido;

    public JFrame_RemoverPedido(int select, Pedido pedido, TabelaPedido tabelaPedido)
    {
        super("");
        this.select = select;
        this.tabelaPedido = tabelaPedido;
        this.pedido = pedido;
        
        getjLabel_Titulo().setText("Remover Pedido");
        getjLabel_Aviso().setText("Deseja realmente remover esse Pedido?");
        getjButton_Confirmar().setText("Remover");
        
        getjButton_Add().setVisible(false);
        getjButton_Remove().setVisible(false);
        getjButton_Search().setVisible(false);
        getjComboBox_Produto().setVisible(false);
        getjComboBox_Cliente().setEnabled(false);
        getjComboBox_Mesa().setEnabled(false);
        getjSpinner_Quantidade().setVisible(false);
        getjLabel_Produto().setVisible(false);
        getjLabel_Quantidade().setVisible(false);
        
        getjComboBox_Cliente().setSelectedItem(pedido.getCliente());

        pedido.getListItensPedidos().stream().forEach(getTabelaItensPedido()::Add);
        getjComboBox_Mesa().setSelectedItem(pedido.getMesa());
        getTabelaItensPedido().setEnabled(false);
    }

    @Override
    public void Confirmar()
    {
        DAO_Generalizado.remover(pedido);
        tabelaPedido.Remove(select);
        dispose();
    }
    
}
