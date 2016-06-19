package Telas.TelaProduto;

import Tabelas.TabelaProduto;
import Telas.JFrame_BaseFiltros;
import dao.DAO_Generalizado;
import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class JFrame_FiltroProduto extends JFrame_BaseFiltros
{
    private final TabelaProduto tabelaProduto;

    public JFrame_FiltroProduto(TabelaProduto tabelaProduto)
    {
        super("");
        this.tabelaProduto = tabelaProduto;

        //Textos
        getjLabel_Titulo().setText("Filtrar");
        getjButton_Confirmar().setText("Filtrar");
        getjLabel_LocalizarFiltrar().setText("(*) Filtrar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");

        getjCheckBox1().setText("Filtrar por Categoria");
        getjCheckBox2().setText("Filtrar por Nome");
        getjCheckBox3().setVisible(false);
        getjCheckBox_PesquisarAbaixo().setVisible(false);
        getjCheckBox_PesquisarAcima().setVisible(false);
    }

    @Override
    public void AcaoJCheckBox1()
    {
        /*JCheckBox não utilizado*/
    }

    @Override
    public void AcaoJCheckBox2()
    {
        /*JCheckBox não utilizado*/
    }

    @Override
    public void AcaoJCheckBox3()
    {
        /*JCheckBox não utilizado*/
    }

    @Override
    public void Confirmar()
    {
        if (Verificaoes())
        {
            Criteria criteria = Hibernate.getSession().createCriteria(Produto.class);
            if(getjCheckBox1().isSelected())
            {
                Criteria cr = criteria.createCriteria("categoria");
                cr.add(Restrictions.like("nomeCategoria", "%"+getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            }
            if(getjCheckBox2().isSelected())
            {
                criteria.add(Restrictions.like("nomeProduto", "%"+getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            }
            tabelaProduto.rebuild(DAO_Generalizado.getList(criteria));
            dispose();
        }
    }
    
}
