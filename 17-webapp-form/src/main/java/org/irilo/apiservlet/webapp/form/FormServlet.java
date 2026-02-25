package org.irilo.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");

        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");

        Map<String,String> errores = new HashMap<>();


        if (username.isBlank() || username == null) {
            errores.put("username","El username es requerido");
        }

        if (password.isBlank() || password == null) {
            errores.put("password","El password es requerido");
        }
        if (!email.contains("@") || email == null) {
            errores.put("email","El email es requerido y debe tener formato de correo");
        }
        if (pais.isBlank() || username == null) {
            errores.put("pais","El país es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes","El lenguaje es requerido");
        }
        if (roles == null || roles.length == 0) {
            errores.put("roles","El rol es requerido");
        }
        if (idioma == null) {
            errores.put("idioma","El idioma es requerido");
        }
        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title> Resultado Form </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Resultado Form!</h1>");
                out.println("<ul>");

                out.println("<li>Username: " + username + "</li>");
                out.println("<li>Password: " + password + "</li>");
                out.println("<li>Email: " + email + "</li>");
                out.println("<li>País: " + pais + "</li>");
                out.println("<li>Lenguajes: <ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("<li>" + lenguaje + "</li>");
                });
                out.println("</ul></li>");
                out.println("<li>Roles: <ul>");
                Arrays.asList(roles).forEach(rol -> {
                    out.println("<li>" + rol + "</li>");
                });
                out.println("</ul></li>");
                out.println("<li>Idioma: " + idioma + "</li>");
                out.println("<li>Habilitado: " + habilitar + "</li>");
                out.println("<li>Secreto: " + secreto + "</li>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
//                errores.forEach(error ->{
//                    out.println("<li>" + error + "</li>");
//                });
//                out.println("<p><a href=\"/webapp-form/index.jsp\">Volver</a></p>");
        }

    }
}
