package com.example.cms.test;

import static org.junit.jupiter.api.Assertions.*;
import com.example.cms.dao.impl.ContentDAO;
import com.example.cms.entities.ContentBean;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
class ContentDAOTest {

  @Test
  void save() {
    ContentBean contentBean = new ContentBean();
    contentBean.setTitle("Title 1");
    contentBean.setBrief("Brief 1");
    contentBean.setContent("Content 1");
    contentBean.setAuthorId(7);

    new ContentDAO().save(contentBean);
  }

  @Test
  void getContentsByAuthorId() {
    List<ContentBean> contentBeanList = new ContentDAO().getContentsByAuthorId(1);
    System.out.println(contentBeanList);
  }
}