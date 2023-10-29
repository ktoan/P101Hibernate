package com.example.cms.services;

import com.example.cms.entities.MemberBean;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public interface IMemberServices {
  MemberBean getMemberByEmail(String email);
  String updateMember(MemberBean member);
}
