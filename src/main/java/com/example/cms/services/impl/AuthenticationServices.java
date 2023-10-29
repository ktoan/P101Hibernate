package com.example.cms.services.impl;

import com.example.cms.dao.impl.MemberDAO;
import com.example.cms.entities.MemberBean;
import com.example.cms.services.IAuthenticationServices;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class AuthenticationServices implements IAuthenticationServices {
  private final MemberDAO memberDAO = new MemberDAO();

  @Override
  public String login(String email, String password) {
    boolean isExistsAccount =
        memberDAO.existByEmailAndPassword(email, password);
    return isExistsAccount ? "SUCCESS" : "Email or password is invalid!";
  }

  @Override
  public String register(MemberBean memberBean) {
    try {
      if (memberDAO.existByEmail(memberBean.getEmail())) {
        return "Email is taken!";
      }
      if (memberDAO.existByUsername(memberBean.getUsername())) {
        System.out.println("...");
        return "Username is taken!";
      }
      memberDAO.save(memberBean);
      return "SUCCESS";
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
