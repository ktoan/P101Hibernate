package com.example.cms.controllers;

import com.example.cms.entities.ContentBean;
import com.example.cms.entities.MemberBean;
import com.example.cms.services.impl.ContentServices;
import com.example.cms.services.impl.MemberServices;
import java.io.IOException;
import java.util.List;
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
@WebServlet(value = "/")
public class ViewContentServlet extends HttpServlet {
  private final MemberServices memberServices = new MemberServices();
  private final ContentServices contentServices = new ContentServices();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String email = session.getAttribute("email").toString();
    MemberBean member = memberServices.getMemberByEmail(email);
    List<ContentBean> contents = contentServices.getContents(member.getId());
    req.setAttribute("contents", contents);
    req.getRequestDispatcher("/views/view-content.jsp").forward(req, resp);
  }
}
