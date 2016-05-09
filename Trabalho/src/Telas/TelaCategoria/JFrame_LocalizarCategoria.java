package Telas.TelaCategoria;

import Telas.JFrame_BaseLocalizar;
import Tabelas.MontarTabelas;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarCategoria extends JFrame_BaseLocalizar
{
    private int select;
    
    public JFrame_LocalizarCategoria(int select)
    {
        super("src\\Imagens\\TelaCategoria.jpg");
        this.select = select;
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
            if(MontarTabelas.SelecionarLinhaTabela(select, 0, getjFormattedTextField_Localizar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Categoria não encontrada!", "Erro!", 2);
        }
    }
    
}
