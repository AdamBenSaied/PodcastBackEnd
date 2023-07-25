package com.example.demo.controller;

import com.example.demo.model.VO.PodcastVO;
import com.example.demo.model.WVO.GenreWVO;
import com.example.demo.model.WVO.PodcastWVO;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.constants.ENDPOINTS.GENRE_ENDPOINT;
import static com.example.demo.constants.ENDPOINTS.GENRE_INFOS_BY_ID;
import static com.example.demo.constants.PARAMS.GENRE_ID;

@RestController
@RequestMapping(path = GENRE_ENDPOINT)
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(path = GENRE_INFOS_BY_ID)
    public GenreWVO getGenreInfosById(@RequestParam(GENRE_ID) Long genreId) {
        return genreService.getGenreById(genreId);
    }
}
