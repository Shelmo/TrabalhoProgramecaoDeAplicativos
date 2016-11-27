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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItensPedido;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Shelmo
 */
@WebServlet(name = "ItensPedidoServlet", urlPatterns =
{
    "/ItensPedidoServlet"
})
public class ItensPedidoServlet extends HttpServlet
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

            Produto produto = new Produto();
            produto.setIdProduto(Integer.parseInt(request.getParameter("cbx_produto")));

            ItensPedido itensPedido = new ItensPedido();
            itensPedido.setProduto(produto);
            itensPedido.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));

//            DAO_Generalizado.incluirAlterar(itensPedido, DAO_Generalizado.SALVAR);
            ArrayList listaPedido = DAO_Generalizado.getList("from Pedido where id = " + request.getParameter("codigo"));
            Pedido pedido;

            if (listaPedido.size() == 1)
            {
                pedido = (Pedido) listaPedido.get(0);

                boolean produtoExistente = false;
                for (int i = 0; i < pedido.getListItensPedidos().size(); i++)
                {
                    if (pedido.getListItensPedidos().get(i).getProduto().getIdProduto() == produto.getIdProduto())
                    {
                        pedido.getListItensPedidos().get(i).setQuantidade(pedido.getListItensPedidos().get(i).getQuantidade() + itensPedido.getQuantidade());
                        DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.ATUALIZAR);
                        response.sendRedirect("ItensPedidoJSTL.jsp?codigo=" + pedido.getIdPedido() + "&nome="
                                + pedido.getCliente().getNomeCliente() + "&mesa=" + pedido.getMesa());
                        produtoExistente = true;
                        break;
                    }
                }

                if (!produtoExistente)
                {
                    if (request.getParameter("nomeIncluido") != null)
                    {
                        pedido.getListItensPedidos().add(itensPedido);
                        DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.ATUALIZAR);
                        response.sendRedirect("ItensPedidoJSTL.jsp?codigo=" + pedido.getIdPedido() + "&nome="
                                + pedido.getCliente().getNomeCliente() + "&mesa=" + pedido.getMesa() + "&nomeIncluido="
                                + request.getParameter("nomeIncluido"));
                    }
                    else
                    {
                        pedido.getListItensPedidos().add(itensPedido);
                        DAO_Generalizado.incluirAlterar(pedido, DAO_Generalizado.ATUALIZAR);
                        response.sendRedirect("ItensPedidoJSTL.jsp?codigo=" + pedido.getIdPedido() + "&nome="
                                + pedido.getCliente().getNomeCliente() + "&mesa=" + pedido.getMesa());
                    }
                }
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
