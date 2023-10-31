package com.example.demo.model.VO;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class UserVO implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PSEUDO")
    private String pseudoname;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "ISADMIN")
    private boolean isAdmin;

    @Column(name = "PROFILEPHOTO")
    private String prophilePhoto;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_INVENTAIRE", referencedColumnName = "ID")
    private InventaireVO inventaireVO;

    @Transient
    private Integer age;

    @Transient
    private boolean IsLegal;

    public UserVO(String pseudoname, String mail, String name, String surname, String password,
                  LocalDate dob, InventaireVO inventaireVO) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.dob = dob;
        this.inventaireVO = inventaireVO;
    }

    public UserVO(String pseudoname, String mail, String name, String surname, String password,
                  LocalDate dob, String prophilePhoto, InventaireVO inventaireVO) {
        this.pseudoname = pseudoname;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.dob = dob;
        this.prophilePhoto = prophilePhoto;
        this.inventaireVO = inventaireVO;
    }

    public UserVO() {
    }

    public Long getId() {
        return id;
    }

    public InventaireVO getInventaireVO() {
        return inventaireVO;
    }

    public void setInventaireVO(InventaireVO inventaireVO) {
        this.inventaireVO = inventaireVO;
    }

    public String getPseudoname() {
        return pseudoname;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String getProphilePhoto() {
        return prophilePhoto;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isLegal() {
        if (getAge() > 18) {
            return true;
        } else {
            return false;
        }
    }


    public void setPseudoname(String pseudoname) {
        this.pseudoname = pseudoname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setProphilePhoto(String prophilePhoto) {
        this.prophilePhoto = prophilePhoto;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLegal(boolean legal) {
        IsLegal = legal;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(String.valueOf(isAdmin())));
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}




