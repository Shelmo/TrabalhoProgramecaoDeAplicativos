package Telas.TelaCategoria;

import Tabelas.MontarTabelas;
import dao.CategoriaDAO;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovaCategoria extends JFrame_Categoria
{
    public JFrame_NovaCategoria()
    {
        super("");
        getjLabel_Titulo().setText("Nova Categoria");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
    }
    
    @Override
    public void Confirmar()
    {
        LimparjLabel_Erro();
        
        Categoria c = new Categoria();
        c.setNomeCategoria(getjTextField_Nome().getText());
        
        if(Verificacoes())
        {
            CategoriaDAO.incluirCategoria(c);
            MontarTabelas.addCategoria(c);
            LimparCampos();
        }
    }
}
