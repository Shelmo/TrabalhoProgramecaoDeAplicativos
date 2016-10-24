/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DAO_Generalizado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Shelmo
 */
@WebServlet(name = "ClienteServlet", urlPatterns =
{
    "/ClienteServlet"
})
public class ClienteServlet extends HttpServlet
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
            
            Cliente cliente = new Cliente();
            cliente.setNomeCliente(request.getParameter("txtNome"));
            cliente.setCpfCliente(request.getParameter("txtCPF"));
            cliente.setCidadeCliente(request.getParameter("txtCidade"));
            cliente.setBairroCliente(request.getParameter("txtBairro"));
            cliente.setRuaCliente(request.getParameter("txtRua"));
            cliente.setComplementoCliente(request.getParameter("txtComplemento"));
            cliente.setCepCliente(request.getParameter("txtCEP"));
            cliente.setFoneCliente(request.getParameter("txtFone"));
            cliente.setCelularCliente(request.getParameter("txtCelular"));
            cliente.setEmailCliente(request.getParameter("txtEmail"));
            
            if(!request.getParameter("txtNumero").isEmpty())
                cliente.setNumeroCliente(Integer.parseInt(request.getParameter("txtNumero")));
            
            try
            {
                java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("txtDataNasc"));
                Date data = new Date(dataUtil.getTime());
                cliente.setDataNascimentoCliente(data);
            }
            catch (ParseException ex){}
            
            if (request.getParameter("txtCod") != null)
            {
                cliente.setIdCliente(Integer.parseInt(request.getParameter("txtCod")));
                DAO_Generalizado.incluirAlterar(cliente, DAO_Generalizado.ATUALIZAR);
                response.sendRedirect("ListaClienteJSTL.jsp?nomeIncluido=" + cliente.getNomeCliente() + "&idCliente=" + request.getParameter("txtCod"));
            }
            else
            {
                DAO_Generalizado.incluirAlterar(cliente, DAO_Generalizado.SALVAR);
                response.sendRedirect("ListaClienteJSTL.jsp?nomeIncluido=" + cliente.getNomeCliente());
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
