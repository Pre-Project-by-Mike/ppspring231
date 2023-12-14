package org.itmentor.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name = "name")
   private String name;

   @Column(name = "surName")
   private String surName;

   @Column(name = "email")
   private String email;

   public User() {
   }
   
   public User(String name, String surName, String email) {
      this.name = name;
      this.surName = surName;
      this.email = email;
   }

    public User(int id, String name, String surName, String email) {
       this.id = id;
       this.name = name;
       this.surName = surName;
       this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String lastName) {
        this.surName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return  Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurName(), user.getSurName()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurName(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + surName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}