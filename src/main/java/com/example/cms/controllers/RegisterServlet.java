package com.example.cms.controllers;

import com.example.cms.entities.MemberBean;
import com.example.cms.services.impl.AuthenticationServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
  private final AuthenticationServices authenticationServices =
      new AuthenticationServices();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");

    MemberBean memberBean = new MemberBean();
    memberBean.setUsername(username);
    memberBean.setPassword(password);
    memberBean.setEmail(email);
    String registerStatus = authenticationServices.register(memberBean);

    if ("SUCCESS".equals(registerStatus)) {
      resp.sendRedirect("/login");
    } else {
      req.setAttribute("ErrorMessage", registerStatus);
      req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }
  }
}
