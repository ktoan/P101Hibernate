package com.example.cms.dao;

import com.example.cms.entities.MemberBean;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public interface IMemberDAO {
  void save(MemberBean member);
  MemberBean getMember(int id);
  void update(MemberBean member);
  boolean existByUsername(String username);
  boolean existByEmail(String email);
  boolean existByEmailAndPassword(String email, String password);
}
