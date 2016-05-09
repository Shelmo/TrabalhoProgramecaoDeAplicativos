package Telas.TelaCategoria;

import Tabelas.MontarTabelas;
import dao.CategoriaDAO;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarCategoria extends JFrame_Categoria
{
    private final Categoria categoria;
    private final int select;
    
    public JFrame_AlterarCategoria(int select, Categoria categoria)
    {
        super();
        this.categoria = categoria;
        this.select = select;
        
        getjLabel_Titulo().setText("Alterar Categoria");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        getjButton_Confirmar().setText("Alterar");
        
        getjTextField_Nome().setText(this.categoria.getNomeCategoria());
    }
    
    @Override
    public void Confirmar()
    {
        LimparjLabel_Erro();
        categoria.setNomeCategoria(getjTextField_Nome().getText());
        
        if(Verificacoes())
        {
            CategoriaDAO.alterarCategoria(categoria);
            MontarTabelas.updateCategoria(categoria, select);
            LimparCampos();
            dispose();
        }
    }
}
