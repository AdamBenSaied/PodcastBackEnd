package com.example.demo.model.VO;


import java.io.Serializable;
import java.util.Objects;

public class PodcastGenrePK implements Serializable {

    private Long podcastVO;
    private Long genreVO;

    public PodcastGenrePK() {
    }

    public PodcastGenrePK(Long podcastVO, Long genreVO) {
        this.podcastVO = podcastVO;
        this.genreVO = genreVO;
    }

    public Long getPodcastVO() {
        return podcastVO;
    }

    public void setPodcastVO(Long podcastVo) {
        this.podcastVO = podcastVo;
    }

    public Long getGenreVO() {
        return genreVO;
    }

    public void setGenreVO(Long genreVO) {
        this.genreVO = genreVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PodcastGenrePK)) return false;
        PodcastGenrePK that = (PodcastGenrePK) o;
        return Objects.equals(podcastVO, that.podcastVO) &&
                Objects.equals(genreVO, that.genreVO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(podcastVO, genreVO);
    }
}
