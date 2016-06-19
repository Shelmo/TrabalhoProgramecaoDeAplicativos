package Telas.TelaPedido;

import Tabelas.TabelaPedido;
import Telas.JFrame_BaseFiltros;
import dao.DAO_Generalizado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class JFrame_FiltroPedido extends JFrame_BaseFiltros
{

    private final TabelaPedido tabelaPedido;

    public JFrame_FiltroPedido(TabelaPedido tabelaPedido)
    {
        super("");
        this.tabelaPedido = tabelaPedido;

        //Textos
        getjLabel_Titulo().setText("Filtrar");
        getjButton_Confirmar().setText("Filtrar");
        getjLabel_LocalizarFiltrar().setText("(*) Filtrar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");

        getjCheckBox1().setText("Filtrar por Cliente");
        getjCheckBox2().setText("Filtrar por Data de Cadastro");
        getjCheckBox3().setText("Filtrar por Mesa");
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
        setjFormattedTextField_LocalizarFiltrar(Mascaras.Mascaras.setFormat(getjFormattedTextField_LocalizarFiltrar(), "##/##/####", '_'));
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
        if (Verificaoes())
        {
            Criteria criteria = Hibernate.getSession().createCriteria(Pedido.class);
            if (getjCheckBox1().isSelected())
            {
                Criteria cr = criteria.createCriteria("cliente");
                cr.add(Restrictions.like("nomeCliente", "%" + getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            }
            if (getjCheckBox2().isSelected())
            {
                if (!getjFormattedTextField_LocalizarFiltrar().getText().equals("__/__/____"))
                {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    try
                    {
                        java.sql.Date data = new java.sql.Date(format.parse(getjFormattedTextField_LocalizarFiltrar().getText()).getTime());
                        criteria.add(Restrictions.like("dataCadastro", data));
                    }
                    catch (ParseException ex)
                    {
                        System.err.println("Erro! Data inválida!");
                    }
                }
                else
                {
                    getjLabel_ErroLocalizarFiltrar().setText("O campo Filtrar é obrigatório!");
                    return;
                }

            }
            if (getjCheckBox3().isSelected())
            {
                criteria.add(Restrictions.like("mesa", "%" + getjFormattedTextField_LocalizarFiltrar().getText() + "%"));
            }
            tabelaPedido.rebuild(DAO_Generalizado.getList(criteria));
            dispose();
        }
    }
}
