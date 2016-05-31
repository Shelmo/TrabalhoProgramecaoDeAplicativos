package Telas.TelaProduto;

import Tabelas.TabelaProduto;
import Telas.JFrame_BaseLocalizar;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarProduto extends JFrame_BaseLocalizar
{
    private final int select;
    private final TabelaProduto tabelaProduto;
    
    public JFrame_LocalizarProduto(int select, TabelaProduto tabelaProduto)
    {
        super("src\\Imagens\\TelaProduto.jpg");
        this.select = select;
        this.tabelaProduto = tabelaProduto;
        
        getjCheckBox1().setText("Localizar por Categoria");
        getjCheckBox2().setText("Localizar por Nome");
        getjCheckBox3().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1(){/*Nenhuma ação necessária*/}

    @Override
    public void AcaoJCheckBox2(){/*Nenhuma ação necessária*/}

    @Override
    public void AcaoJCheckBox3(){/*JCheckBox não utilizado*/}

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

            if(tabelaProduto.selecionarLinhaTabela(select, coluna, getjFormattedTextField_Localizar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro!", 2);
        }
    }
    
}
