package Telas.TelaCliente;

import Tabelas.TabelaCliente;
import Telas.JFrame_BaseLocalizar;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarCliente extends JFrame_BaseLocalizar
{
    private final int select;
    private final TabelaCliente tabelaCliente;
    public JFrame_LocalizarCliente(int select, TabelaCliente tabelaCliente)
    {
        super("src\\Imagens\\TelaCliente.jpg");
        this.select = select;
        this.tabelaCliente = tabelaCliente;
        
        getjCheckBox1().setText("Localizar por Nome");
        getjCheckBox2().setText("Localizar por CPF");
        getjCheckBox3().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1()
    {
        getjFormattedTextField_Localizar().setFormatterFactory(null);
        getjFormattedTextField_Localizar().setText(null);
    }

    @Override
    public void AcaoJCheckBox2()
    {
        setjFormattedTextField_Localizar(Mascaras.Mascaras.setFormat(getjFormattedTextField_Localizar(),"###.###.###-##", '_'));
        getjFormattedTextField_Localizar().setText(null);
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
                if(getjFormattedTextField_Localizar().getText().equals("___.___.___-__"))
                {
                    getjLabel_ErroLocalizar().setText("O campo Localizar é obrigatório!");
                    return;
                }
                
                coluna = 1;
            }

            if(tabelaCliente.selecionarLinhaTabela(select, coluna, getjFormattedTextField_Localizar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
                dispose();
            else
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro!", 2);
        }
    }
    
}
