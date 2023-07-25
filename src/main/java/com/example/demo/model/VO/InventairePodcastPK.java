package com.example.demo.model.VO;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InventairePodcastPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_INVENTAIRE", referencedColumnName = "ID")
    private InventaireVO inventaireVO;

    @ManyToOne
    @JoinColumn(name = "ID_PODCAST", referencedColumnName = "ID")
    private PodcastVO podcastVO;


    public InventairePodcastPK() {
    }

    public InventaireVO getInventaireVO() {
        return inventaireVO;
    }

    public void setInventaireVO(InventaireVO inventaireVO) {
        this.inventaireVO = inventaireVO;
    }

    public PodcastVO getPodcastVO() {
        return podcastVO;
    }

    public void setPodcastVO(PodcastVO podcastVO) {
        this.podcastVO = podcastVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventairePodcastPK)) return false;
        InventairePodcastPK that = (InventairePodcastPK) o;
        return Objects.equals(inventaireVO, that.inventaireVO) &&
                Objects.equals(podcastVO, that.podcastVO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventaireVO, podcastVO);
    }
}
