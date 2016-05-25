package Telas.TelaCategoria;

import Tabelas.TabelaCategoria;
import dao.DAO_Generalizado;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverCategoria extends JFrame_Categoria
{
    private final Categoria categoria;
    private final int select;
    private final TabelaCategoria tabelaCategoria;
    
    public JFrame_RemoverCategoria(int select, Categoria categoria, TabelaCategoria tabelaCategoria)
    {
        super();
        this.categoria = categoria;
        this.select = select;
        this.tabelaCategoria = tabelaCategoria;
        
        getjLabel_Titulo().setText("Remover Categoria");
        getjLabel_Aviso().setText("Deseja realmente remover essa Categoria?");
        getjButton_Confirmar().setText("Remover");
        
        getjTextField_Nome().setText(this.categoria.getNomeCategoria());
        getjTextField_Nome().setEditable(false);
    }
    
    @Override
    public void Confirmar()
    {
        DAO_Generalizado.remover(categoria);
        tabelaCategoria.Remove(select);
        dispose();
    }
}
