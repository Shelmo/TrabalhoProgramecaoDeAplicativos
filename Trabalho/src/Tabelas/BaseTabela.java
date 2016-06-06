/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shelmo
 */
public abstract class BaseTabela extends JTable
{
    
    public BaseTabela()
    {
        getTableHeader().setReorderingAllowed(false);
        setModel(new javax.swing.table.DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex)
            {
                return false;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                this.setHorizontalAlignment(CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
    }
    
    public boolean selecionarLinhaTabela(int inicio, int coluna, String Pesquisa, boolean pesquisarAbaixo)
    {
        if(pesquisarAbaixo)
            inicio++;
        else
            inicio--;
        
        for(int i = inicio;getModel().getRowCount() > i;)
        {
            if (i < 0)
                break;

            if (Pesquisa.equalsIgnoreCase((String) getValueAt(i, coluna)))
            {
                setRowSelectionInterval(i, i);
                return true;
            }

            if (pesquisarAbaixo)
                i++;
            else
                i--;
        }
        
        return false;
    }

    public DefaultTableModel getModelo()
    {
        return (DefaultTableModel) getModel();
    }
    
    public abstract void Add(Object object);
    
    public abstract void Remove(int select);
    
    public abstract void update (Object object, int select);
    
    public abstract ArrayList getLista();
}
