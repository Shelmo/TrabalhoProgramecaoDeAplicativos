package Telas.TelaPedido;

import Tabelas.TabelaPedido;
import Telas.JFrame_BaseFiltros;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarPedido extends JFrame_BaseFiltros
{
    private final int select;
    private final TabelaPedido tabelaPedido;
    
    public JFrame_LocalizarPedido(int select, TabelaPedido tabelaPedido)
    {
        super("");
        this.tabelaPedido = tabelaPedido;
        this.select = select;
        
        //Textos
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        getjLabel_LocalizarFiltrar().setText("(*) Localizar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjCheckBox_PesquisarAbaixo().setText("Localizar Abaixo");
        getjCheckBox_PesquisarAcima().setText("Localizar Acima");
        
        getjCheckBox1().setText("Localizar por Cliente");
        getjCheckBox2().setText("Localizar por Data de Cadastro");
        getjCheckBox3().setText("Localizar por Mesa");
    }

    @Override
    public void AcaoJCheckBox1()
    {
        getjFormattedTextField_LocalizarFiltrar().setFormatterFactory(null);
        getjFormattedTextField_LocalizarFiltrar().setText(null);
    }

    @Override
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_LocalizarFiltrar(Mascaras.Mascaras.setFormat(getjFormattedTextField_LocalizarFiltrar(),"##/##/####", '_'));
        getjFormattedTextField_LocalizarFiltrar().setText(null);
    }

    @Override
    public void AcaoJCheckBox3()
    {
        getjFormattedTextField_LocalizarFiltrar().setFormatterFactory(null);
        getjFormattedTextField_LocalizarFiltrar().setText(null);
    }

    @Override
    public void Confirmar()
    {
        if(Verificaoes())
        {
            int coluna = -1;
            if(getjCheckBox1().isSelected())
                coluna = 0;
            if(getjCheckBox2().isSelected())
            {
                if(getjFormattedTextField_LocalizarFiltrar().getText().equals("__/__/____"))
                {
                    getjLabel_ErroLocalizarFiltrar().setText("O campo Localizar é obrigatório!");
                    return;
                }
                
                coluna = 1;
            }
            if(getjCheckBox3().isSelected())
                coluna = 2;

            if(tabelaPedido.selecionarLinhaTabela(select, coluna, getjFormattedTextField_LocalizarFiltrar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro!", 2);
        }
    }
    
}
