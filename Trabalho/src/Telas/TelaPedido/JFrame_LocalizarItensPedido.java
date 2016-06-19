/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.TelaPedido;

import Tabelas.TabelaItensPedido;
import Telas.JFrame_BaseFiltros;
import javax.swing.JOptionPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_LocalizarItensPedido extends JFrame_BaseFiltros
{

    private final int select;
    private final TabelaItensPedido tabelaItensPedido;

    public JFrame_LocalizarItensPedido(int select, TabelaItensPedido tabelaItensPedido)
    {
        super("");

        this.select = select;
        this.tabelaItensPedido = tabelaItensPedido;

        //Textos
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        getjLabel_LocalizarFiltrar().setText("(*) Localizar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjCheckBox_PesquisarAbaixo().setText("Localizar Abaixo");
        getjCheckBox_PesquisarAcima().setText("Localizar Acima");
        
        getjCheckBox1().setText("Localizar por Categoria");
        getjCheckBox2().setText("Localizar por Produto");
        getjCheckBox3().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1()
    {
        //Não utilizado!
    }

    @Override
    public void AcaoJCheckBox2()
    {
        //Não utilizado!
    }

    @Override
    public void AcaoJCheckBox3()
    {
        //Não utilizado!
    }

    @Override
    public void Confirmar()
    {
        if (Verificaoes())
        {
            int coluna = -1;
            if (getjCheckBox1().isSelected())
            {
                coluna = 0;
            }
            if (getjCheckBox2().isSelected())
            {
                coluna = 1;
            }

            if (tabelaItensPedido.selecionarLinhaTabela(select, coluna, getjFormattedTextField_LocalizarFiltrar().getText(), getjCheckBox_PesquisarAbaixo().isSelected()))
            {
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Item não encontrado!", "Erro!", 2);
            }
        }
    }

}
