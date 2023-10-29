package com.example.cms.services;

import com.example.cms.entities.ContentBean;
import java.util.List;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public interface IContentServices {
  String createContent(ContentBean content);
  List<ContentBean> getContents(int authorId);
}
