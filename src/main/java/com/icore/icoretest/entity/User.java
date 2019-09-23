package com.icore.icoretest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ICORE_USER")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Фамилия обязательно")
    private String lastname;

    @NotBlank(message = "Имя обязательно")
    private String firstname;

    @NotBlank(message = "Отчество обязательно")
    private String patronymic;

    @NotBlank(message = "Дата рождения")
    private String birthddate;

    @NotBlank(message = "Пол")
    private String sex;

    @NotBlank(message = "Место жительства")
    private String address;

    public User() {}

    public User(String user_ln,
                String user_fn,
                String user_patronymic,
                String user_birth,
                String user_sex,
                String user_address) {
        this.lastname = user_ln;
        this.firstname = user_fn;
        this.patronymic = user_patronymic;
        this.birthddate = user_birth;
        this.sex = user_sex;
        this.address = user_address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthddate() {
        return birthddate;
    }

    public void setBirthddate(String birthddate) {
        this.birthddate = birthddate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", lname=" + lastname + ", fname=" + firstname + '}';
    }


    //@OneToOne(fetch = FetchType.LAZY,
    //        cascade =  CascadeType.ALL,
    //        mappedBy = "user")
    //private IdentityCard identityCard;
    @OneToOne(mappedBy = "user")
    private IdentityCard identityCard;

    public IdentityCard getIdentityCard()
    {
        return identityCard;
    }
    public void setIdentityCard(IdentityCard card)
    {
        this.identityCard=card;
    }
}