package Telas.TelaCliente;

import Tabelas.TabelaCliente;
import Telas.JFrame_BaseFiltros;
import dao.DAO_Generalizado;
import model.Cliente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class JFrame_FiltroCliente extends JFrame_BaseFiltros
{

    private final TabelaCliente tabelaCliente;

    public JFrame_FiltroCliente(TabelaCliente tabelaCliente)
    {
        super("");
        this.tabelaCliente = tabelaCliente;

        //Textos
        getjLabel_Titulo().setText("Filtrar");
        getjButton_Confirmar().setText("Filtrar");
        getjLabel_LocalizarFiltrar().setText("(*) Filtrar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjCheckBox1().setText("Filtrar por Nome");
        getjCheckBox2().setText("Filtrar por CPF");

        getjCheckBox3().setVisible(false);
        getjCheckBox_PesquisarAbaixo().setVisible(false);
        getjCheckBox_PesquisarAcima().setVisible(false);
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
        setjFormattedTextField_LocalizarFiltrar(Mascaras.Mascaras.setFormat(getjFormattedTextField_LocalizarFiltrar(), "###.###.###-##", '_'));
        getjFormattedTextField_LocalizarFiltrar().setText(null);
    }

    @Override
    public void AcaoJCheckBox3()
    {/*jCheckBox não utilizado*/
    }

    @Override
    public void Confirmar()
    {
        if (Verificaoes())
        {
            Criteria criteria = Hibernate.getSession().createCriteria(Cliente.class);
            if (getjCheckBox1().isSelected())
            {
                criteria.add(Restrictions.like("nomeCliente", "%"+getjFormattedTextField_LocalizarFiltrar().getText()+"%"));
            }
            if (getjCheckBox2().isSelected())
            {
                if (getjFormattedTextField_LocalizarFiltrar().getText().equals("___.___.___-__"))
                {
                    getjLabel_ErroLocalizarFiltrar().setText("O campo Localizar é obrigatório!");
                    return;
                }
                criteria.add(Restrictions.like("cpfCliente", getjFormattedTextField_LocalizarFiltrar().getText()));
            }
            tabelaCliente.rebuild(DAO_Generalizado.getList(criteria));
            dispose();
        }
    }
}
