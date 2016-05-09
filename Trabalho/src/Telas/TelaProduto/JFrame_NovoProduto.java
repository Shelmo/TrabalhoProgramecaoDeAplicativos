package Telas.TelaProduto;

import Tabelas.MontarTabelas;
import Telas.JFrame_Base;
import dao.ProdutoDAO;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovoProduto extends JFrame_Produto
{
    public JFrame_NovoProduto()
    {
        super(null);
        getjLabel_Titulo().setText("Novo Produto");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
    }
    
    @Override
    public void Confirmar()
    {
        LimparErros();
        
        if(Verificaoes())
        {
            Produto produto = new Produto();
            produto.setIdCategoriaProduto(getjComboBox_Categoria().getSelectedIndex());
            produto.setNomeProduto(getjTextField_Nome().getText());
            String valor = getjTextField_Valor().getText().replace(',', '.');
            produto.setValorProduto(Double.parseDouble(valor));
            produto.setDescricaoProduto(getjTextArea_Descricao().getText());
            ProdutoDAO.incluirProduto(produto);
            MontarTabelas.addProduto(produto);
            LimparCampos();
        }
    }
}
