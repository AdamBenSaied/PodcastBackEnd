package com.example.demo.model.WVO;

import java.io.Serializable;
import java.time.LocalDate;

public class UserWVO implements Serializable {

    private String pseudoname;
    private String mail;
    private String name;
    private String surname;
    private Integer age;
    private LocalDate dob;
    private Long id;
    private String password;

    public UserWVO() {
        //Default
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserWVO(String pseudoname, String mail, String name, String surname, LocalDate dob, String password) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.password = password;
    }

    public UserWVO(String pseudoname, String mail, String name, String surname) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    public UserWVO(String pseudoname, String mail, String name, String surname, Integer age, LocalDate dob) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPseudoname() {
        return pseudoname;
    }

    public void setPseudoname(String pseudoname) {
        this.pseudoname = pseudoname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
