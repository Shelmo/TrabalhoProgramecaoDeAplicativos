package Telas;


import javax.swing.*; 
import java.awt.*; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.lang.reflect.InvocationHandler; 
import java.lang.reflect.Method; 
import java.lang.reflect.Proxy; 


public class Modal
{
    static class EventPump implements InvocationHandler
    {
        private final Frame frame;

        public EventPump(Frame frame)
        {
            this.frame = frame;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            return frame.isShowing() ? Boolean.TRUE : Boolean.FALSE;
        }

        public void start() throws Exception
        {
            Class clazz = Class.forName("java.awt.Conditional");
            Object conditional = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
            Method pumpMethod = Class.forName("java.awt.EventDispatchThread").getDeclaredMethod("pumpEvents", new Class[]{clazz});
            pumpMethod.setAccessible(true);
            pumpMethod.invoke(Thread.currentThread(), new Object[]{conditional});
        }
    }
    
    public static void showAsModal(final JFrame frame, final JFrame owner)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                owner.setEnabled(false);
            }

            @Override
            public void windowClosed(WindowEvent e)
            {
                frame.removeWindowListener(this);
                owner.setEnabled(true);
                owner.toFront();
            }
        });

        owner.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowActivated(WindowEvent e)
            {
                if (frame.isShowing())
                {
                    frame.setExtendedState(JFrame.NORMAL);
                    frame.toFront();
                }
                else
                    owner.removeWindowListener(this);

            }
        });

        frame.setVisible(true);
        try
        {
            new EventPump(frame).start();
        }
        catch (Throwable throwable)
        {
            throw new RuntimeException(throwable);
        }
    }
}
