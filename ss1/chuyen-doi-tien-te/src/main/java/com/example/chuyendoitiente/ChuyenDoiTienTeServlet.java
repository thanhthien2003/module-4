package com.example.chuyendoitiente;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.example.chuyendoitiente.ChuyenDoiTienTeServlet", value = "/chuyen-doi")
public class ChuyenDoiTienTeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ChuyenDoiTienTe.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            float rate = Float.parseFloat(request.getParameter("vnd"));
            float usd = Float.parseFloat(request.getParameter("usd"));

            float vnd = rate * usd;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Rate: " + rate + "</h1>");
        writer.println("<h1> USD: " + usd + "</h1>");
        writer.println("<h1> VND: " + vnd + "</h1>");
        writer.println("</html>");
    }
}
