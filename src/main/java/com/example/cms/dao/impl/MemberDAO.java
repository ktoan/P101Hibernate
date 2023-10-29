package com.example.cms.dao.impl;

import com.example.cms.dao.IMemberDAO;
import com.example.cms.entities.MemberBean;
import com.example.cms.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class MemberDAO implements IMemberDAO {
  private EntityManager entityManager;

  @Override
  public void save(MemberBean member) {
    entityManager = HibernateUtils.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(member);
    entityManager.getTransaction().commit();
  }

  @Override
  public MemberBean getMember(int id) {
    entityManager = HibernateUtils.getEntityManager();
    MemberBean member = entityManager.find(MemberBean.class, id);
    entityManager.detach(member);
    return member;
  }

  @Override
  public void update(MemberBean member) {
    entityManager = HibernateUtils.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.merge(member);
    entityManager.getTransaction().commit();
  }

  @Override
  public boolean existByUsername(String username) {
    entityManager = HibernateUtils.getEntityManager();
    TypedQuery<Long> query = entityManager.createQuery(
        "SELECT COUNT(m) FROM MemberBean m WHERE m.username = :username",
        Long.class);
    query.setParameter("username", username);
    Long count = query.getSingleResult();
    entityManager.close();
    return count > 0;
  }

  @Override
  public boolean existByEmail(String email) {
    entityManager = HibernateUtils.getEntityManager();
    TypedQuery<Long> query = entityManager.createQuery(
        "SELECT COUNT(m) FROM MemberBean m WHERE m.email = :email",
        Long.class);
    query.setParameter("email", email);
    Long count = query.getSingleResult();
    entityManager.close();
    return count > 0;
  }

  @Override
  public boolean existByEmailAndPassword(String email, String password) {
    entityManager = HibernateUtils.getEntityManager();
    MemberBean member = findByEmail(email);
    return member != null && password.equals(member.getPassword());
  }

  public MemberBean findByEmail(String email) {
    entityManager = HibernateUtils.getEntityManager();
    TypedQuery<MemberBean> query = entityManager.createQuery(
        "SELECT m FROM MemberBean m WHERE m.email = :email",
        MemberBean.class);
    query.setParameter("email", email);
    List<MemberBean> result = query.getResultList();
    entityManager.close();
    return result.isEmpty() ? null : result.get(0);
  }
}
