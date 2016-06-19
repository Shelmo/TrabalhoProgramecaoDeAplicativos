package Telas.TelaCategoria;

import Tabelas.TabelaCategoria;
import Telas.JFrame_BaseFiltros;
import dao.DAO_Generalizado;
import model.Categoria;
import util.Hibernate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Shelmo
 */
public class JFrame_FiltroCategoria extends JFrame_BaseFiltros
{
    private final TabelaCategoria tabelaCategoria;

    public JFrame_FiltroCategoria(TabelaCategoria tabelaCategoria)
    {
        super("");
        this.tabelaCategoria = tabelaCategoria;

        //Textos
        getjLabel_Titulo().setText("Filtrar");
        getjButton_Confirmar().setText("Filtrar");
        getjLabel_LocalizarFiltrar().setText("(*) Filtrar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");

        getjCheckBox1().setVisible(false);
        getjCheckBox2().setVisible(false);
        getjCheckBox3().setVisible(false);
        getjCheckBox_PesquisarAbaixo().setVisible(false);
        getjCheckBox_PesquisarAcima().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1()
    {
        //Não utilizado para nessa classe
    }

    @Override
    public void AcaoJCheckBox2()
    {
        //Não utilizado para nessa classe
    }

    @Override
    public void AcaoJCheckBox3()
    {
        //Não utilizado para nessa classe
    }

    @Override
    public void Confirmar()
    {
        if (Verificaoes())
        {
            Criteria criteria = Hibernate.getSession().createCriteria(Categoria.class);
            criteria.add(Restrictions.like("nomeCategoria", "%"+getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            tabelaCategoria.rebuild(DAO_Generalizado.getList(criteria));
            dispose();
        }
    }
}
