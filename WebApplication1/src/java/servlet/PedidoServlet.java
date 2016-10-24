/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DAO_Generalizado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;

/**
 *
 * @author Shelmo
 */
@WebServlet(name = "PedidoServlet", urlPatterns =
{
    "/PedidoServlet"
})
public class PedidoServlet extends HttpServlet
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
            
            Cliente cliente;
            cliente = (Cliente) DAO_Generalizado.getList("from Cliente where id = " + request.getParameter("cbx_cliente")).get(0);
            
            Pedido pedido;
            
            if (request.getParameter("txtCod") != null)
            {
                ArrayList listaPedidos = DAO_Generalizado.getList("from Pedido where id = " + request.getParameter("txtCod"));
                pedido = (Pedido) listaPedidos.get(0);
            }
            else
            {
                pedido = new Pedido();
            }
            
            pedido.setCliente(cliente);
            pedido.setMesa(request.getParameter("txtMesa"));
            pedido.setSituacao("A");
            pedido.setDataCadastro(new Date());
            
            if (request.getParameter("txtCod") != null)
            {
                pedido.setIdPedido(Integer.parseInt(request.getParameter("txtCod")));
                DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.ATUALIZAR);
                response.sendRedirect("index.jsp?nomeIncluido=" + pedido.getCliente().getNomeCliente() + "&idPedido=" + request.getParameter("txtCod"));
            }
            else
            {
                DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.SALVAR);
                response.sendRedirect("index.jsp?nomeIncluido=" + pedido.getCliente().getNomeCliente());
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
