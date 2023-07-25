package com.example.demo.model.VO;

import com.example.demo.model.WVO.PodcastGenreWVO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "podcasts_genres")
@IdClass(PodcastGenrePK.class)
public class PodcastGenreVO {
    /*@Id
    private String idPodcast;

    @Id
    private String idGenre;
    */
    @Id
    @MapsId
    @ManyToOne
    @JoinColumn(name = "ID_PODCAST", referencedColumnName = "ID")
    private PodcastVO podcastVO;

    @Id
    @MapsId
    @ManyToOne
    @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID")
    private GenreVO genreVO;

    public PodcastGenreVO() {
    }

    public PodcastGenreVO(PodcastVO podcastVO, GenreVO genreVO) {
        this.podcastVO = podcastVO;
        this.genreVO = genreVO;
    }

    public PodcastGenreVO(GenreVO genreVO) {
        this.genreVO = genreVO;
    }

    public void setPodcastVO(PodcastVO idPodcast) {
        this.podcastVO = idPodcast;
    }

    public void setGenreVO(GenreVO idGenre) {
        this.genreVO = idGenre;
    }

    public PodcastVO getPodcastVO() {
        return podcastVO;
    }

    public GenreVO getGenreVO() {
        return genreVO;
    }


}
