package com.example.demo.model.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "inventaires")
public class InventaireVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @OneToOne(mappedBy = "inventaireVO",fetch = FetchType.EAGER)
    private UserVO userVO;

    public InventaireVO(UserVO userVO) {
    }

    public InventaireVO() {

    }

    public long getId() {
        return id;
    }


    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}


