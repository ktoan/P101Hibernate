package com.example.cms.services.impl;

import com.example.cms.dao.impl.ContentDAO;
import com.example.cms.entities.ContentBean;
import com.example.cms.services.IContentServices;
import java.util.List;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class ContentServices implements IContentServices {
  private final ContentDAO contentDAO = new ContentDAO();

  @Override
  public String createContent(ContentBean content) {
    try {
      contentDAO.save(content);
      return "SUCCESS";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public List<ContentBean> getContents(int authorId) {
    return contentDAO.getContentsByAuthorId(authorId);
  }
}
