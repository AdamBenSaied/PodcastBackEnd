package com.example.demo.model.WVO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDate;

public class UserWVO implements Serializable {

    private String pseudoname;
    private String mail;
    private String name;
    private String surname;
    private String profilePhoto;
    private Integer age;
    private LocalDate dob;


    @JsonIgnore
    private Long id;

    //    @JsonIgnore
    // THIS JSON INCLUDE tkhalli l'password mayarja3esh ki yabda valeur mte3ou NULL !
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    public UserWVO(String pseudoname, String mail, String name, String surname, LocalDate dob) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }

    public UserWVO(String pseudoname, String mail, String name, String surname) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    public UserWVO(String pseudoname, String mail, String name, String surname, Integer age, LocalDate dob,String profilePhoto) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dob = dob;
        this.profilePhoto=profilePhoto;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
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
