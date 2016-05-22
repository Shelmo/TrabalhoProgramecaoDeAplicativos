package Telas.TelaPedido;

/**
 *
 * @author Shelmo
 */
public class JFrame_NovoPedido extends JFrame_Pedido
{

    public JFrame_NovoPedido()
    {
        super("");
        getjLabel_Titulo().setText("Novo Pedido");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        getjButton_Confirmar().setText("Salvar");
    }

    @Override
    public void Confirmar()
    {
        
    }
    
}
