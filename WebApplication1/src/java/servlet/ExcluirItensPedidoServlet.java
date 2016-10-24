package servlet;

import dao.DAO_Generalizado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItensPedido;

/**
 *
 * @author Shelmo
 */
@WebServlet(name = "ExcluirItensPedidoServlet", urlPatterns =
{
    "/ExcluirItensPedidoServlet"
})
public class ExcluirItensPedidoServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");

            ArrayList listaItens = DAO_Generalizado.getList("from ItensPedido where id = " + request.getParameter("codigo"));
            if (listaItens.size() == 1)
            {
                ItensPedido itensPedido = (ItensPedido) listaItens.get(0);

                if (itensPedido.getQuantidade() > 1)
                {
                    itensPedido.setQuantidade(itensPedido.getQuantidade() - 1);
                    DAO_Generalizado.incluirAlterar(itensPedido, DAO_Generalizado.ATUALIZAR);
                }
                else
                {
                    DAO_Generalizado.remover(itensPedido);
                }
                response.sendRedirect("ItensPedidoJSTL.jsp?codigo=" + request.getParameter("codigoPedido") + "&nome="
                        + request.getParameter("cliente") + "&mesa=" + request.getParameter("mesa"));
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
