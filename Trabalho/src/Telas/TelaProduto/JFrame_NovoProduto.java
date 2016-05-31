package Telas.TelaProduto;

import Tabelas.TabelaProduto;
import dao.DAO_Generalizado;
import model.Categoria;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovoProduto extends JFrame_Produto
{
    private final TabelaProduto tabelaProduto;
    
    public JFrame_NovoProduto(TabelaProduto tabelaProduto)
    {
        super();
        
        this.tabelaProduto = tabelaProduto;
        
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
            produto.setCategoria((Categoria) getjComboBox_Categoria().getSelectedItem());
            produto.setNomeProduto(getjTextField_Nome().getText());
            String valor = getjTextField_Valor().getText().replace(',', '.');
            produto.setValorProduto(Double.parseDouble(valor));
            produto.setDescricaoProduto(getjTextArea_Descricao().getText());
            int id = (int) DAO_Generalizado.incluirAlterar(produto, DAO_Generalizado.SALVAR);
            produto.setIdProduto(id);
            tabelaProduto.Add(produto);
            LimparCampos();
        }
    }
}
