package com.example.demo.model.WVO;


import java.io.Serializable;

public class InventairePodcastWVO implements Serializable {


//    private InventaireWVO inventaireWVO;
    private PodcastWVO podcastWVO;

    public InventairePodcastWVO() {
        //Default
    }

    public InventairePodcastWVO(InventaireWVO inventaireWVO, PodcastWVO podcastWVO) {
//        this.inventaireWVO = inventaireWVO;
        this.podcastWVO = podcastWVO;
    }

    public InventairePodcastWVO(PodcastWVO podcastWVO) {
        this.podcastWVO = podcastWVO;
    }
//    public InventaireWVO getInventaireWVO() {
//        return inventaireWVO;
//    }

//    public void setInventaireWVO(InventaireWVO inventaireWVO) {
//        this.inventaireWVO = inventaireWVO;
//    }

    public PodcastWVO getPodcastWVO() {
        return podcastWVO;
    }

    public void setPodcastWVO(PodcastWVO podcastWVO) {
        this.podcastWVO = podcastWVO;
    }
}
