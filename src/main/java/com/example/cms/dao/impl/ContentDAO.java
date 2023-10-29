package com.example.cms.dao.impl;

import com.example.cms.dao.IContentDAO;
import com.example.cms.entities.ContentBean;
import com.example.cms.entities.MemberBean;
import com.example.cms.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class ContentDAO implements IContentDAO {
  private EntityManager entityManager;

  @Override
  public void save(ContentBean content) {
    entityManager = HibernateUtils.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(content);
    entityManager.getTransaction().commit();
  }

  @Override
  public List<ContentBean> getContentsByAuthorId(int authorId) {
    entityManager = HibernateUtils.getEntityManager();
    TypedQuery<ContentBean> query = entityManager.createQuery(
        "SELECT c FROM ContentBean c WHERE c.authorId = :authorId",
        ContentBean.class);
    query.setParameter("authorId", authorId);
    return query.getResultList();
  }
}
