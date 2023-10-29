package com.example.cms.services.impl;

import com.example.cms.dao.impl.MemberDAO;
import com.example.cms.entities.MemberBean;
import com.example.cms.services.IMemberServices;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class MemberServices implements IMemberServices {
  private final MemberDAO memberDAO = new MemberDAO();

  @Override
  public MemberBean getMemberByEmail(String email) {
    return memberDAO.findByEmail(email);
  }

  @Override
  public String updateMember(MemberBean member) {
    try {
      memberDAO.update(member);
      return "SUCCESS";
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
