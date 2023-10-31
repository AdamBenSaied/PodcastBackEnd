package com.example.demo.service;


import com.example.demo.model.VO.GenreVO;
import com.example.demo.model.VO.PodcastGenreVO;
import com.example.demo.model.VO.PodcastVO;
import com.example.demo.model.WVO.GenreWVO;
import com.example.demo.model.WVO.PodcastGenreWVO;
import com.example.demo.model.WVO.PodcastWVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.repository.PodcastGenreRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PodcastGenreService {

    private final PodcastGenreRepository podcastGenreRepository;

    private final GenreService genreService;
    private final UserService userService;
    private final PodcastService podcastService;

    @Autowired
    public PodcastGenreService(PodcastGenreRepository podcastGenreRepository, GenreService genreService,
                               UserService userService, PodcastService podcastService) {
        this.podcastGenreRepository = podcastGenreRepository;
        this.genreService = genreService;
        this.userService = userService;
        this.podcastService = podcastService;
    }


    public List<PodcastGenreWVO> getPodcastsByGenre(String genreName) {
        List<PodcastGenreVO> podcastGenreVOList = podcastGenreRepository.findByGenreVO_Name(genreName);
        List<PodcastGenreWVO> podcastGenreWVOList = new ArrayList<>();
        podcastGenreVOList.forEach(podcastGenreVO -> {

            GenreWVO genreWVO = genreService.getGenreById(podcastGenreVO.getGenreVO().getIdGenre());

//            UserWVO userWVO = userService.getUserInfosById(podcastGenreVO.getPodcastVO().getUserVO().getId());

            PodcastWVO podcastWVO = podcastService.getPodcastById(podcastGenreVO.getPodcastVO().getId());

            PodcastGenreWVO podcastGenreWVO = new PodcastGenreWVO(podcastWVO, genreWVO);
            podcastGenreWVOList.add(podcastGenreWVO);
        });
        return podcastGenreWVOList;
    }

    public void addNewPodcastGenre(PodcastVO podcastVO, GenreVO genreVO) {

        PodcastGenreVO podcastGenreVO = new PodcastGenreVO(podcastVO, genreVO);

        podcastGenreRepository.saveAndFlush(podcastGenreVO);

    }

    public List<PodcastGenreWVO> getGenreByPodcastId(Long podcastId) {

        List<PodcastGenreVO> podcastGenreVOList = podcastGenreRepository.findByPodcastVO_Id(podcastId);
        List<PodcastGenreWVO> podcastGenreWVOList = new ArrayList<>();

        podcastGenreVOList.forEach(podcastGenreVO -> {
            GenreWVO genreWVO = genreService.getGenreById(podcastGenreVO.getGenreVO().getIdGenre());
            PodcastGenreWVO podcastGenreWVO = new PodcastGenreWVO(genreWVO);
            podcastGenreWVOList.add(podcastGenreWVO);
        });

        return podcastGenreWVOList;
    }


}
