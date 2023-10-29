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
@Table(name = "Members", schema = "dbo", catalog = "JWEBP101")
public class MemberBean {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id")
  private int id;
  @Basic
  @Column(name = "FirstName")
  private String firstName;
  @Basic
  @Column(name = "LastName")
  private String lastName;
  @Basic
  @Column(name = "Username")
  private String username;
  @Basic
  @Column(name = "Password")
  private String password;
  @Basic
  @Column(name = "Phone")
  private String phone;
  @Basic
  @Column(name = "Email")
  private String email;
  @Basic
  @Column(name = "Description")
  private String description;
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

    MemberBean that = (MemberBean) o;

    if (id != that.id) {
      return false;
    }
    if (firstName != null ? !firstName.equals(that.firstName) :
        that.firstName != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(that.lastName) :
        that.lastName != null) {
      return false;
    }
    if (username != null ? !username.equals(that.username) :
        that.username != null) {
      return false;
    }
    if (password != null ? !password.equals(that.password) :
        that.password != null) {
      return false;
    }
    if (phone != null ? !phone.equals(that.phone) : that.phone != null) {
      return false;
    }
    if (email != null ? !email.equals(that.email) : that.email != null) {
      return false;
    }
    if (description != null ? !description.equals(that.description) :
        that.description != null) {
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
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MemberBean{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", description='" + description + '\'' +
        ", createdAt=" + createdAt +
        ", modifiedAt=" + modifiedAt +
        '}';
  }
}
