package com.example.cms.test;

import static org.junit.jupiter.api.Assertions.*;
import com.example.cms.dao.impl.MemberDAO;
import com.example.cms.entities.MemberBean;
import org.junit.jupiter.api.Test;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
class MemberDAOTest {

  @Test
  void save() {

    MemberBean memberBean = new MemberBean();
    memberBean.setEmail("nktoanwork@gmail.com");
    memberBean.setPassword("123123");
    memberBean.setUsername("nktoanwork");

    new MemberDAO().save(memberBean);
  }

  @Test
  void getMember() {
    int id = 3;
    MemberBean memberBean = new MemberDAO().getMember(id);
    memberBean.setEmail("nktoan.20it1@vku.udn.vn");
    memberBean.setUsername("helloToan");

    new MemberDAO().update(memberBean);
  }

  @Test
  void existUsername() {
    System.out.println(new MemberDAO().existByUsername("nktoan"));
  }
}