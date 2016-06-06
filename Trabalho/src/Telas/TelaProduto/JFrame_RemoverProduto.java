package Telas.TelaProduto;

import Tabelas.TabelaProduto;
import dao.DAO_Generalizado;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverProduto extends JFrame_Produto
{
    private final Produto produto;
    private final int select;
    private final TabelaProduto tabelaProduto;
    public JFrame_RemoverProduto(int select, Produto produto, TabelaProduto tabelaProduto)
    {
        super();
        this.produto = produto;
        this.select = select;
        this.tabelaProduto = tabelaProduto;
        
        getjLabel_Titulo().setText("Remover Produto");
        getjLabel_Aviso().setText("Deseja realmente remover esse Produto?");
        getjButton_Confirmar().setText("Remover");
        
        getjComboBox_Categoria().setSelectedIndex(select+1);
        getjTextField_Nome().setText(this.produto.getNomeProduto());
        String valor = String.valueOf(String.format("%.2f", this.produto.getValorProduto())).replace(",", "");
        getjTextField_Valor().setText(valor);
        getjTextArea_Descricao().setText(this.produto.getDescricaoProduto());
        
        getjComboBox_Categoria().setEnabled(false);
        getjTextArea_Descricao().setEditable(false);
        getjTextField_Nome().setEditable(false);
        getjTextField_Valor().setEditable(false);
    }
    
    @Override
    public void Confirmar()
    {
        DAO_Generalizado.remover(produto);
        tabelaProduto.Remove(select);
        dispose();
    }
}
