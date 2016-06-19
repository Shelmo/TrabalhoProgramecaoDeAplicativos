package Telas.TelaProduto;

import Tabelas.TabelaProduto;
import Telas.JFrame_BaseFiltros;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarProduto extends JFrame_BaseFiltros
{
    private final int select;
    private final TabelaProduto tabelaProduto;
    
    public JFrame_LocalizarProduto(int select, TabelaProduto tabelaProduto)
    {
        super("src\\Imagens\\TelaProduto.jpg");
        this.select = select;
        this.tabelaProduto = tabelaProduto;
        
        //Textos
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        getjLabel_LocalizarFiltrar().setText("(*) Localizar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjCheckBox_PesquisarAbaixo().setText("Localizar Abaixo");
        getjCheckBox_PesquisarAcima().setText("Localizar Acima");
        
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

            if(tabelaProduto.selecionarLinhaTabela(select, coluna, getjFormattedTextField_LocalizarFiltrar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro!", 2);
        }
    }
    
}
