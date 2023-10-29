package com.example.cms.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
@Entity
@Table(name = "Contents", schema = "dbo", catalog = "JWEBP101")
public class ContentBean {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id")
  private int id;
  @Basic
  @Column(name = "Title")
  private String title;
  @Basic
  @Column(name = "Brief")
  private String brief;
  @Basic
  @Column(name = "Content")
  private String content;
  @Basic
  @Column(name = "Sort")
  private String sort;
  @Basic
  @Column(name = "AuthorId")
  private Integer authorId;
  @Basic
  @CreationTimestamp
  @Column(name = "CreatedAt")
  private LocalDateTime createdAt;
  @Basic
  @UpdateTimestamp
  @Column(name = "ModifiedAt")
  private LocalDateTime modifiedAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public Integer getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Integer authorId) {
    this.authorId = authorId;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(LocalDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ContentBean that = (ContentBean) o;

    if (id != that.id) {
      return false;
    }
    if (title != null ? !title.equals(that.title) : that.title != null) {
      return false;
    }
    if (brief != null ? !brief.equals(that.brief) : that.brief != null) {
      return false;
    }
    if (content != null ? !content.equals(that.content) :
        that.content != null) {
      return false;
    }
    if (sort != null ? !sort.equals(that.sort) : that.sort != null) {
      return false;
    }
    if (authorId != null ? !authorId.equals(that.authorId) :
        that.authorId != null) {
      return false;
    }
    if (createdAt != null ? !createdAt.equals(that.createdAt) :
        that.createdAt != null) {
      return false;
    }
    if (modifiedAt != null ? !modifiedAt.equals(that.modifiedAt) :
        that.modifiedAt != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (brief != null ? brief.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (sort != null ? sort.hashCode() : 0);
    result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
    return result;
  }
}
