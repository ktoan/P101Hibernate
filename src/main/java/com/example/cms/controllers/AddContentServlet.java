package com.example.cms.controllers;

import com.example.cms.entities.ContentBean;
import com.example.cms.entities.MemberBean;
import com.example.cms.services.impl.ContentServices;
import com.example.cms.services.impl.MemberServices;
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
@WebServlet(value = "/add-content")
public class AddContentServlet extends HttpServlet {
  private final ContentServices contentServices = new ContentServices();
  private final MemberServices memberServices = new MemberServices();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/views/add-content.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String title = req.getParameter("title");
    String brief = req.getParameter("brief");
    String content = req.getParameter("content");
    HttpSession session = req.getSession();
    String email = session.getAttribute("email").toString();
    MemberBean memberBean = memberServices.getMemberByEmail(email);

    ContentBean contentBean = new ContentBean();
    contentBean.setTitle(title);
    contentBean.setBrief(brief);
    contentBean.setContent(content);
    contentBean.setAuthorId(memberBean.getId());

    String contentCreationStatus = contentServices.createContent(contentBean);

    if ("SUCCESS".equals(contentCreationStatus)) {
      resp.sendRedirect("/");
    } else {
      req.setAttribute("ErrorMessage", contentCreationStatus);
      req.getRequestDispatcher("/views/add-content.jsp").forward(req, resp);
    }
  }
}
