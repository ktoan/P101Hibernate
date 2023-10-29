package com.example.cms.controllers;

import com.example.cms.services.impl.AuthenticationServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
  private final AuthenticationServices authenticationServices =
      new AuthenticationServices();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    String loginStatus = authenticationServices.login(email, password);

    if ("SUCCESS".equals(loginStatus)) {
      HttpSession session = req.getSession();
      session.setAttribute("email", email);
      resp.sendRedirect("/");
    } else {
      req.setAttribute("ErrorMessage", loginStatus);
      req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }
  }
}
