/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shelmo
 */
@WebServlet(name = "AlterarClienteServlet", urlPatterns =
{
    "/AlterarClienteServlet"
})
public class AlterarClienteServlet extends HttpServlet
{
    void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
            String format = "";

            if (request.getParameter("dataNasc") != null)
            {
                java.util.Date dataUtil = null;
                try
                {
                    dataUtil = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataNasc"));
                }
                catch (ParseException ex){}
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                format = sdf.format(dataUtil);
            }

            System.out.println("Texto: " + request.getParameter("nome"));
            
            response.sendRedirect("ClienteJSTL.jsp?cod=" + request.getParameter("codigo") + "&nome="  + request.getParameter("nome")
                    + "&cpf=" + request.getParameter("cpf") + "&cidade=" + request.getParameter("cidade")
                    + "&bairro=" + request.getParameter("bairro") + "&rua=" + request.getParameter("rua") + "&numero=" + request.getParameter("numero")
                    + "&complemento=" + request.getParameter("complemento") + "&cep=" + request.getParameter("cep")
                    + "&fone=" + request.getParameter("fone") + "&celular=" + request.getParameter("celular")
                    + "&email=" + request.getParameter("email") + "&dataNasc=" + format);

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
