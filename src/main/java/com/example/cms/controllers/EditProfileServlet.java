package com.example.cms.controllers;

import com.example.cms.entities.MemberBean;
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
@WebServlet(value = "/edit-profile")
public class EditProfileServlet extends HttpServlet {
  private final MemberServices memberServices = new MemberServices();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String email = session.getAttribute("email").toString();
    MemberBean member = memberServices.getMemberByEmail(email);
    req.setAttribute("member", member);
    req.getRequestDispatcher("/views/edit-profile.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String phone = req.getParameter("phone");
    String description = req.getParameter("description");
    HttpSession session = req.getSession();
    String email = session.getAttribute("email").toString();
    MemberBean member = memberServices.getMemberByEmail(email);
    member.setFirstName(firstName);
    member.setLastName(lastName);
    member.setPhone(phone);
    member.setDescription(description);
    String memberModificationStatus = memberServices.updateMember(member);
    if (!"SUCCESS".equals(memberModificationStatus)) {
      req.setAttribute("ErrorMessage", memberModificationStatus);
    }
    req.getRequestDispatcher("/views/edit-profile.jsp").forward(req, resp);
  }
}
