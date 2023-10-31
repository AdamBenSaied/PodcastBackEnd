package com.example.demo.model.WVO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PodcastGenreWVO implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("podcast")
    private PodcastWVO podcastWVO;

    @JsonProperty("genre")
    private GenreWVO genreWVO;

    public PodcastGenreWVO() {
        //Default
    }


    public PodcastGenreWVO(PodcastWVO podcastWVO, GenreWVO genreWVO) {
        this.podcastWVO = podcastWVO;
        this.genreWVO = genreWVO;
    }

    public PodcastGenreWVO(GenreWVO genreWVO) {
        this.genreWVO = genreWVO;
    }

    public PodcastWVO getPodcastWVO() {
        return podcastWVO;
    }

    public void setPodcastWVO(PodcastWVO podcastWVO) {
        this.podcastWVO = podcastWVO;
    }

    public GenreWVO getGenreWVO() {
        return genreWVO;
    }

    public void setGenreWVO(GenreWVO genreWVO) {
        this.genreWVO = genreWVO;
    }
}
