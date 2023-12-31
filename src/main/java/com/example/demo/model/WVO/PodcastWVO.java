package com.example.demo.model.WVO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PodcastWVO implements Serializable {

    @NotBlank
    private String name;

    private float price;

    private String url;

    @Future
    private LocalDateTime startdate;

    private LocalDateTime createdDate;


    @JsonProperty("creator")
    private UserWVO userWVO;


    @JsonProperty("podcastGenre")
    private List<PodcastGenreWVO> podcastGenreWVOS;


    public PodcastWVO() {
        //Default
    }

    public PodcastWVO(@NotBlank String name, float price, String url,
                      @Future LocalDateTime startdate, LocalDateTime createdDate, UserWVO userWVO) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.startdate = startdate;
        this.createdDate = createdDate;
        this.userWVO = userWVO;
    }

    public PodcastWVO(@NotBlank String name, float price, String url, @Future LocalDateTime startdate,
                      LocalDateTime createdDate, UserWVO userWVO, List<PodcastGenreWVO> podcastGenreWVOS) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.startdate = startdate;
        this.createdDate = createdDate;
        this.userWVO = userWVO;
        this.podcastGenreWVOS = podcastGenreWVOS;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public float getPrice() {
        return price;
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

    public UserWVO getUserWVO() {
        return userWVO;
    }

    public void setUserWVO(UserWVO userWVO) {
        this.userWVO = userWVO;
    }

    public List<PodcastGenreWVO> getPodcastGenreWVOS() {
        return podcastGenreWVOS;
    }

    public void setPodcastGenreWVOS(List<PodcastGenreWVO> podcastGenreWVOS) {
        this.podcastGenreWVOS = podcastGenreWVOS;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PodcastWVO)) return false;
        PodcastWVO that = (PodcastWVO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(userWVO, that.userWVO) &&
                Objects.equals(podcastGenreWVOS, that.podcastGenreWVOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startdate, createdDate, userWVO, podcastGenreWVOS);
    }
}
