package com.example.demo.model.VO;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class GenreVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idGenre;

    @Column(name = "NAME")
    private String name;

   @Column(name = "DESCRIPTION")
    private  String Description;

    @Column(name = "IS_KID_FRIENDLY")
    private boolean isKidFriendly;

    public GenreVO() {
    }

    public GenreVO(String name, String description, boolean isKidFriendly) {
        this.name = name;
        Description = description;
        this.isKidFriendly = isKidFriendly;
    }

    public long getIdGenre() {
        return idGenre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

   /* @OneToMany
    private List<PodcastGenreVO> podcastGenreVOS = new ArrayList<>();

    public void add(PodcastGenreVO podcastGenreVO) {
        podcastGenreVO.setGenreVO(this);
        this.podcastGenreVOS.add(podcastGenreVO);
    }*/


}
