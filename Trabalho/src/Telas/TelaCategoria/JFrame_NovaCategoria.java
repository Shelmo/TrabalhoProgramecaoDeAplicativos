package Telas.TelaCategoria;

import Tabelas.MontarTabelas;
import dao.DAO_Generalizado;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovaCategoria extends JFrame_Categoria
{
    public JFrame_NovaCategoria()
    {
        super();
        getjLabel_Titulo().setText("Nova Categoria");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
    }
    
    @Override
    public void Confirmar()
    {
        LimparjLabel_Erro();
        
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(getjTextField_Nome().getText());
        
        if(Verificacoes())
        {
            int id = (int) DAO_Generalizado.incluirAlterar(categoria, DAO_Generalizado.SALVAR);
            categoria.setIdCategoria(id);
            MontarTabelas.addCategoria(categoria);
            LimparCampos();
        }
    }
}
