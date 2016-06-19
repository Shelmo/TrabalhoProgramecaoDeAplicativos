package Telas.TelaPedido;

import Tabelas.TabelaItensPedido;
import Telas.JFrame_BaseFiltros;
import dao.DAO_Generalizado;
import model.ItensPedido;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class JFrame_FiltroItensPedido extends JFrame_BaseFiltros
{
    private final TabelaItensPedido tabelaItensPedido;

    public JFrame_FiltroItensPedido(TabelaItensPedido tabelaItensPedido)
    {
        super("");
        this.tabelaItensPedido = tabelaItensPedido;

        //Textos
        getjLabel_Titulo().setText("Filtrar");
        getjButton_Confirmar().setText("Filtrar");
        getjLabel_LocalizarFiltrar().setText("(*) Filtrar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");

        getjCheckBox1().setText("Filtrar por Categoria");
        getjCheckBox2().setText("Filtrar por Produto");
        getjCheckBox3().setVisible(false);
        getjCheckBox_PesquisarAbaixo().setVisible(false);
        getjCheckBox_PesquisarAcima().setVisible(false);
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
            Criteria criteria = Hibernate.getSession().createCriteria(ItensPedido.class);
            if(getjCheckBox1().isSelected())
            {
                Criteria cr = criteria.createCriteria("categoria");
                cr.add(Restrictions.like("nomeCategoria", "%"+getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            }
            if(getjCheckBox2().isSelected())
            {
                Criteria cr = criteria.createCriteria("produto");
                cr.add(Restrictions.like("nomeProduto", "%"+getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            }
            tabelaItensPedido.rebuild(DAO_Generalizado.getList(criteria));
            dispose();
        }
    }
}
