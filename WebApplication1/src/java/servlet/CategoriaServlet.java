package servlet;

import model.Categoria;
import dao.DAO_Generalizado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shelmo
 */
@WebServlet(name = "CategoriaServlet", urlPatterns =
{
    "/CategoriaServlet"
})
public class CategoriaServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");

            Categoria cat = new Categoria();
            cat.setNomeCategoria(request.getParameter("txtNome"));
            if (request.getParameter("txtCod") != null)
            {
                cat.setIdCategoria(Integer.parseInt(request.getParameter("txtCod")));
                DAO_Generalizado.incluirAlterar(cat, DAO_Generalizado.ATUALIZAR);
                response.sendRedirect("ListaCategoriaJSTL.jsp?nomeIncluido="+cat.getNomeCategoria()+"&idCategoria="+request.getParameter("txtCod"));
            }
            else
            {
                DAO_Generalizado.incluirAlterar(cat, DAO_Generalizado.SALVAR);
                response.sendRedirect("ListaCategoriaJSTL.jsp?nomeIncluido="+cat.getNomeCategoria());
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
