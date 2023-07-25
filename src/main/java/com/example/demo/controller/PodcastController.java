package com.example.demo.controller;

import com.example.demo.model.VO.PodcastVO;
import com.example.demo.model.WVO.PodcastWVO;
import com.example.demo.service.PodcastService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.constants.ENDPOINTS.*;
import static com.example.demo.constants.PARAMS.*;

@RestController
@RequestMapping(path = PODCAST_ENDPOINT)
public class PodcastController {

    private final PodcastService podcastService;

    @Autowired
    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @GetMapping(PODCAST_GET_ALL)
    public List<PodcastWVO> getPodcasts() {
        return podcastService.getAllPodcasts();
    }

    @GetMapping(path = PODCAST_GET_BY_USER)
    public List<PodcastWVO> getUserPodcasts(@RequestParam(USER_ID) Long userId) {
        return podcastService.getUserPodcasts(userId);
    }

    @GetMapping(path = PODCAST_GET_BY_NAME)
    public List<PodcastWVO> getPodcastByName(@RequestParam(PODCAST_NAME) String podcastName) {
        return podcastService.getPodcastbyName(podcastName);
    }

    @GetMapping(path = PODCAST_GET_BY_ID)
    public PodcastWVO getPodcastById(@RequestParam(PODCAST_ID) Long podcastId) {
        return podcastService.getPodcastById(podcastId);
    }

    @GetMapping(path = PODCAST_UPCOMING)
    public List<PodcastWVO> getUpcomingPodcasts() {
        return podcastService.getUpcomingPodcasts();
    }

    @GetMapping(path = PODCAST_UNBOUGHT)
    public List<PodcastWVO> getUnboughtPodcasts(@RequestParam(USER_ID) Long userId) {
        return podcastService.getUnboughtPodcasts(userId);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = PODCAST_POST_NEW_PODCAST)
    public void newPodcast(@Valid @RequestBody PodcastWVO podcastWVO) {
        podcastService.addNewPodcast(podcastWVO);

    }


}
