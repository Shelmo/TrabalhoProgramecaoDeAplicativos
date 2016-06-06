package Telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Base extends javax.swing.JFrame
{
    private JPanel jPanel_SOUTH;
    private JPanel jPanel_NORTH;
    private JPanel jPanel_CENTER;
    private JPanel jPanel_SOUTH_CENTER;
    private JPanel jPanel_SOUTH_EAST;
    private JPanel jPanel_NORTH_CENTER;
    private JPanel jPanel_NORTH_WEST;
    private JLabel jLabel_Titulo;
    private JLabel jLabel_Aviso;
    private JLabel jLabel_Background;
    private JButton jButton_Voltar;
    private JButton jButton_Confirmar;
    private GridBagConstraints cons;
    
    
    public JFrame_Base(String image)
    {
        JLabel_Background(new ImageIcon(image));
        componentes();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void componentes()
    {
        cons = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();  

        jLabel_Titulo = new JLabel();
        jLabel_Aviso = new JLabel();
        jButton_Voltar = new JButton();
        jButton_Confirmar = new JButton();
        
        jPanel_SOUTH = new JPanel();
        jPanel_NORTH = new JPanel();
        jPanel_CENTER = new JPanel();
        jPanel_SOUTH_CENTER = new JPanel();
        jPanel_SOUTH_EAST = new JPanel();
        jPanel_NORTH_CENTER = new JPanel();
        jPanel_NORTH_WEST = new JPanel();
        jPanel_CENTER.setOpaque(false);
        jPanel_SOUTH.setOpaque(false);
        jPanel_NORTH.setOpaque(false);
        jPanel_SOUTH_CENTER.setOpaque(false);
        jPanel_SOUTH_EAST.setOpaque(false);
        jPanel_NORTH_CENTER.setOpaque(false);
        jPanel_NORTH_WEST.setOpaque(false);

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        
        jPanel_SOUTH_CENTER.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel_SOUTH_EAST.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        jPanel_NORTH_CENTER.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel_NORTH_WEST.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        jPanel_SOUTH.setLayout(new BorderLayout());
        jPanel_NORTH.setLayout(new BorderLayout());
        jPanel_CENTER.setLayout(layout);

        
        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Hibernate.CloseSession();
                dispose();
            }
        });
        
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Confirmar();
            }
        });
        
        jPanel_SOUTH_CENTER.add(jLabel_Aviso);
        jPanel_SOUTH_EAST.add(jButton_Confirmar);
        jPanel_SOUTH_EAST.add(jButton_Voltar);
        jPanel_SOUTH.add(BorderLayout.NORTH, jPanel_SOUTH_CENTER);
        jPanel_SOUTH.add(BorderLayout.SOUTH, jPanel_SOUTH_EAST);
        jPanel_NORTH_CENTER.add(jLabel_Titulo);
        jPanel_NORTH.add(BorderLayout.NORTH, jPanel_NORTH_WEST);
        jPanel_NORTH.add(BorderLayout.SOUTH, jPanel_NORTH_CENTER);
        jLabel_Background.setLayout(new BorderLayout());
        jLabel_Background.add(BorderLayout.SOUTH, jPanel_SOUTH);
        jLabel_Background.add(BorderLayout.NORTH, jPanel_NORTH);
        jLabel_Background.add(BorderLayout.CENTER, jPanel_CENTER);
        setSize(600, 400);
        setVisible(true);
    }
    
    private void JLabel_Background(ImageIcon img_bg)
    {
        Icon img_background = img_bg;
        jLabel_Background = new JLabel(img_background);
        setContentPane(jLabel_Background);
    }
    
    public JPanel getjPanel_CENTER()
    {
        return jPanel_CENTER;
    }

    public JPanel getjPanel_NORTH_CENTER()
    {
        return jPanel_NORTH_CENTER;
    }

    public JPanel getjPanel_NORTH_WEST()
    {
        return jPanel_NORTH_WEST;
    }
    
    public JLabel getjLabel_Titulo()
    {
        return jLabel_Titulo;
    }
    
    public JLabel getjLabel_Aviso()
    {
        return jLabel_Aviso;
    }

    public GridBagConstraints getGBC()
    {
        return cons;
    }

    public JButton getjButton_Confirmar()
    {
        return jButton_Confirmar;
    }

    public JButton getjButton_Voltar()
    {
        return jButton_Voltar;
    }

    public JPanel getjPanel_SOUTH_EAST()
    {
        return jPanel_SOUTH_EAST;
    }

    public JPanel getjPanel_SOUTH_CENTER()
    {
        return jPanel_SOUTH_CENTER;
    }

    public abstract void Confirmar();
}
