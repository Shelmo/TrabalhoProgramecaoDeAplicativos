package Telas.TelaCliente;

import Tabelas.TabelaCliente;
import Telas.JFrame_BaseFiltros;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarCliente extends JFrame_BaseFiltros
{
    private final int select;
    private final TabelaCliente tabelaCliente;
    public JFrame_LocalizarCliente(int select, TabelaCliente tabelaCliente)
    {
        super("src\\Imagens\\TelaCliente.jpg");
        this.select = select;
        this.tabelaCliente = tabelaCliente;
        
        //Textos
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        getjLabel_LocalizarFiltrar().setText("(*) Localizar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjCheckBox_PesquisarAbaixo().setText("Localizar Abaixo");
        getjCheckBox_PesquisarAcima().setText("Localizar Acima");
        
        getjCheckBox1().setText("Localizar por Nome");
        getjCheckBox2().setText("Localizar por CPF");
        getjCheckBox3().setVisible(false);
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
        setjFormattedTextField_LocalizarFiltrar(Mascaras.Mascaras.setFormat(getjFormattedTextField_LocalizarFiltrar(),"###.###.###-##", '_'));
        getjFormattedTextField_LocalizarFiltrar().setText(null);
    }

    @Override
    public void AcaoJCheckBox3(){/*jCheckBox não utilizado*/}

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
                if(getjFormattedTextField_LocalizarFiltrar().getText().equals("___.___.___-__"))
                {
                    getjLabel_ErroLocalizarFiltrar().setText("O campo Localizar é obrigatório!");
                    return;
                }
                
                coluna = 1;
            }

            if(tabelaCliente.selecionarLinhaTabela(select, coluna, getjFormattedTextField_LocalizarFiltrar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro!", 2);
        }
    }
    
}
