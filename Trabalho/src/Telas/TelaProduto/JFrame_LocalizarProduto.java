package Telas.TelaProduto;

import Tabelas.MontarTabelas;
import Telas.JFrame_BaseLocalizar;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarProduto extends JFrame_BaseLocalizar
{
    private int select;
    
    public JFrame_LocalizarProduto(int select)
    {
        super("");
        this.select = select;
        
        getjCheckBox1().setText("Localizar por Categoria");
        getjCheckBox2().setText("Localizar por Nome");
        getjCheckBox3().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1()
    {
    }

    @Override
    public void AcaoJCheckBox2()
    {
        
    }

    @Override
    public void AcaoJCheckBox3(){/*JcheckBox não utilizado*/}

    @Override
    public void Confirmar()
    {
        if(Verificaoes())
        {
            int coluna = -1;
            if(getjCheckBox1().isSelected())
                coluna = 0;
            if(getjCheckBox2().isSelected())
                coluna = 1;

            if(MontarTabelas.SelecionarLinhaTabela(select, coluna, getjFormattedTextField_Localizar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro!", 2);
        }
    }
    
}
