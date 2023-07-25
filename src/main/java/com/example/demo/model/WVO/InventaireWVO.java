package com.example.demo.model.WVO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class InventaireWVO implements Serializable {

    private Long id;

    @JsonProperty("inventoryUser")
    private UserWVO userWVO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserWVO getUserWVO() {
        return userWVO;
    }

    public void setUserWVO(UserWVO userWVO) {
        this.userWVO = userWVO;
    }

    public InventaireWVO() {
        //Default
    }

    public InventaireWVO(Long id, UserWVO userWVO) {
        this.id = id;
        this.userWVO = userWVO;
    }
}
