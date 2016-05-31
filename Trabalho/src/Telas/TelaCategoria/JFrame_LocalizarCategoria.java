package Telas.TelaCategoria;

import Telas.JFrame_BaseLocalizar;
import Tabelas.TabelaCategoria;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarCategoria extends JFrame_BaseLocalizar
{
    private final int select;
    private final TabelaCategoria tabelaCategoria;
    
    public JFrame_LocalizarCategoria(int select, TabelaCategoria tabelaCategoria)
    {
        super("src\\Imagens\\TelaCategoria.jpg");
        this.select = select;
        this.tabelaCategoria = tabelaCategoria;
        getjCheckBox1().setVisible(false);
        getjCheckBox2().setVisible(false);
        getjCheckBox3().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1(){/*CheckBox não utilizado*/}

    @Override
    public void AcaoJCheckBox2(){/*CheckBox não utilizado*/}

    @Override
    public void AcaoJCheckBox3(){/*CheckBox não utilizado*/}

    @Override
    public void Confirmar()
    {
        if(Verificaoes())
        {
            if(tabelaCategoria.selecionarLinhaTabela(select, 0, getjFormattedTextField_Localizar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Categoria não encontrada!", "Erro!", 2);
        }
    }
    
}
