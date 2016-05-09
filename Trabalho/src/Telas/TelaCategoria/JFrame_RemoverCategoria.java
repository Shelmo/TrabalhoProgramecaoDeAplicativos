package Telas.TelaCategoria;

import Tabelas.MontarTabelas;
import dao.CategoriaDAO;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverCategoria extends JFrame_Categoria
{
    private final Categoria categoria;
    private final int select;
    
    public JFrame_RemoverCategoria(int select, Categoria categoria)
    {
        super();
        this.categoria = categoria;
        this.select = select;
        
        getjLabel_Titulo().setText("Remover Categoria");
        getjLabel_Aviso().setText("Deseja realmente remover essa Categoria?");
        getjButton_Confirmar().setText("Remover");
        
        getjTextField_Nome().setText(this.categoria.getNomeCategoria());
        getjTextField_Nome().setEditable(false);
    }
    
    @Override
    public void Confirmar()
    {
        CategoriaDAO.excluirCategoria(categoria);
        MontarTabelas.removeCategoria(select);
        dispose();
    }
}
