package com.example.cms.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class HibernateUtils {
  private static final EntityManagerFactory entityManagerFactory;

  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory("cms");
    } catch (Exception ex) {
      throw new ExceptionInInitializerError(
          "Error creating EntityManagerFactory: " + ex);
    }
  }

  public static EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }
}
