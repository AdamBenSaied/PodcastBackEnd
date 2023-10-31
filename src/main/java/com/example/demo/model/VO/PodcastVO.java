package com.example.demo.model.VO;

import com.example.demo.model.WVO.UserWVO;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "podcasts")
public class PodcastVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STARTDATE")
    private LocalDateTime startdate;
    /* WA9TELLI N7EB NTALLA3 L'USER BEL PODCAST NAAMEL LIAISON HEDHI       */

    @Column(name = "CREATEDDATE")
    private LocalDateTime createdDate;

    @Column(name = "PRICE")
    private float price ;

    @Column(name = "URL")
    private String url;

    public PodcastVO(String name, LocalDateTime startdate, LocalDateTime createdDate,
                     float price, String url, UserVO userVO) {
        this.name = name;
        this.startdate = startdate;
        this.createdDate = createdDate;
        this.price = price;
        this.url = url;
        this.userVO = userVO;

    }



    public float getPrice() {
        return price;
    }



    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private UserVO userVO;

    @OneToMany
    @Fetch(FetchMode.SELECT)
    private List<PodcastGenreVO> podcastGenreVOS = new ArrayList<>();





    public PodcastVO() {
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public PodcastVO(String name, LocalDateTime startdate, LocalDateTime createdDate) {
        this.name = name;
        this.startdate = startdate;
        this.createdDate = createdDate;
    }

    public PodcastVO(Long id, String name, LocalDateTime startdate, LocalDateTime createdDate, UserVO userVO) {
        this.id = id;
        this.name = name;
        this.startdate = startdate;
        this.createdDate = createdDate;
        this.userVO = userVO;
    }

    public PodcastVO(String name, LocalDateTime startdate, LocalDateTime createdDate,
                     float price, String url, UserVO userVO, List<PodcastGenreVO> podcastGenreVOS) {
        this.name = name;
        this.startdate = startdate;
        this.createdDate = createdDate;
        this.price = price;
        this.url = url;
        this.userVO = userVO;
        this.podcastGenreVOS = podcastGenreVOS;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PodcastGenreVO> getPodcastGenreVOS() {
        return podcastGenreVOS;
    }

    public void setPodcastGenreVOS(List<PodcastGenreVO> podcastGenreVOS) {
        this.podcastGenreVOS = podcastGenreVOS;
    }
}
