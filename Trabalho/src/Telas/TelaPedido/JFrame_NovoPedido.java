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
        
        getjButton_Search().addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    int select = getTabelaItensPedido().getSelectedRow();
                    if (select == -1)
                    {
                        JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
                        return;
                    }
                    
                    new JFrame_LocalizarItensPedido(select, getTabelaItensPedido());
        });
    }

    @Override
    public void Confirmar()
    {
        LimparErros();
        if (Verificacoes())
        {
            Pedido pedido = new Pedido();
            Date data = new Date();
            pedido.setCliente((Cliente) getjComboBox_Cliente().getSelectedItem());
            pedido.setMesa((String) getjComboBox_Mesa().getSelectedItem());
            pedido.setDataCadastro(data);
            int index = (int) DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.SALVAR);
            pedido.setIdPedido(index);
            tabelaPedido.Add(pedido);

            getTabelaItensPedido().getLista().stream().map((ip)
                    -> 
                    {
                        ip.setPedido(pedido);
                        return ip;
            }).forEach((ip)
                    -> 
                    {
                        DAO_Generalizado.incluirAlterar(ip, DAO_Generalizado.SALVAR);
            });

            getTabelaItensPedido().clearTable();
            LimparCampos();
        }
    }

}
