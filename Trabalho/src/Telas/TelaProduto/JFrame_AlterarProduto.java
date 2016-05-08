package Telas.TelaProduto;

import Tabelas.MontarTabelas;
import dao.ProdutoDAO;
import java.text.DecimalFormat;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarProduto extends JFrame_Produto
{
    private final Produto produto;
    private final int select;
    
    public JFrame_AlterarProduto(int select, Produto produto)
    {
        super(null);
        this.produto = produto;
        this.select = select;
        
        getjLabel_Titulo().setText("Alterar Produto");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        getjButton_Confirmar().setText("Alterar");
        
        getjComboBox_Categoria().setSelectedIndex(select+1);
        getjTextField_Nome().setText(this.produto.getNomeProduto());
        String valor = String.valueOf(String.format("%.2f", this.produto.getValorProduto())).replace(",", "");
        getjTextField_Valor().setText(valor);
        getjTextArea_Descricao().setText(this.produto.getDescricaoProduto());
    }
    
    @Override
    public void Confirmar()
    {
        LimparErros();
        
        if(Verificaoes())
        {
            produto.setIdCategoriaProduto(getjComboBox_Categoria().getSelectedIndex());
            produto.setNomeProduto(getjTextField_Nome().getText());
            String valor = getjTextField_Valor().getText().replace(',', '.');
            produto.setValorProduto(Double.parseDouble(valor));
            produto.setDescricaoProduto(getjTextArea_Descricao().getText());
            ProdutoDAO.alterarProduto(produto);
            MontarTabelas.updateProduto(select, produto);
            dispose();
        }
    }
}
