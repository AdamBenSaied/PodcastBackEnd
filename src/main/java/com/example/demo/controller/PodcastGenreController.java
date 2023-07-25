package com.example.demo.controller;

import com.example.demo.model.VO.PodcastGenreVO;
import com.example.demo.model.VO.PodcastVO;
import com.example.demo.model.WVO.PodcastGenreWVO;
import com.example.demo.service.PodcastGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.constants.ENDPOINTS.PODCAST_ENDPOINT;
import static com.example.demo.constants.ENDPOINTS.PODCAST_GET_BY_GENRE;
import static com.example.demo.constants.PARAMS.GENRE_NAME;

@RestController
@RequestMapping(path = PODCAST_ENDPOINT)
public class PodcastGenreController {

    private final PodcastGenreService podcastGenreService;

    @Autowired
    public PodcastGenreController(PodcastGenreService podcastGenreService) {
        this.podcastGenreService = podcastGenreService;
    }



@GetMapping(path = PODCAST_GET_BY_GENRE)
    public List <PodcastGenreWVO> getPodcastsByGenre(@RequestParam(GENRE_NAME) String genreName)
    {
        return podcastGenreService.getPodcastsByGenre(genreName);
    }



}
