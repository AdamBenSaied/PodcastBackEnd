package com.example.demo.model.WVO;

import java.io.Serializable;

public class GenreWVO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private boolean isKidFriendly;

    public GenreWVO() {
        //Default
    }

    public GenreWVO(String name, String description, boolean isKidFriendly) {
        this.name = name;
        this.description = description;
        this.isKidFriendly = isKidFriendly;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKidFriendly() {
        return isKidFriendly;
    }

    public void setKidFriendly(boolean kidFriendly) {
        isKidFriendly = kidFriendly;
    }

    public Long getId() {
        return id;
    }
}
