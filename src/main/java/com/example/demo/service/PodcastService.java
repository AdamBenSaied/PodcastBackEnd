package com.example.demo.service;


import com.example.demo.model.VO.GenreVO;
import com.example.demo.model.VO.PodcastGenreVO;
import com.example.demo.model.VO.PodcastVO;
import com.example.demo.model.WVO.*;
import com.example.demo.repository.GenreRepository;
import com.example.demo.repository.PodcastGenreRepository;
import com.example.demo.repository.PodcastRepository;
import com.example.demo.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class PodcastService {

    @Autowired
    private Mapper mapper;

    private final PodcastRepository podcastRepository;

    private final UserService userService;

    private final UserRepository userRepository;

    private final PodcastGenreRepository podcastGenreRepository;

    private final GenreRepository genreRepository;

    private final InventairePodcastService inventairePodcastService;

    @Lazy
    @Autowired
    public PodcastService(PodcastRepository podcastRepository, UserService userService,
                          UserRepository userRepository, PodcastGenreRepository podcastGenreRepository,
                          GenreRepository genreRepository, InventairePodcastService inventairePodcastService) {
        this.podcastRepository = podcastRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.podcastGenreRepository = podcastGenreRepository;
        this.genreRepository = genreRepository;
        this.inventairePodcastService = inventairePodcastService;

    }

    public PodcastWVO getPodcastById(Long podcastId) {
        Optional<PodcastVO> podcastVO = podcastRepository.findById(podcastId);

        UserWVO userWVO = userService.getUserInfosById(podcastVO.get().getUserVO().getId());

        PodcastWVO podcastWVO = new PodcastWVO(podcastVO.get().getName(), podcastVO.get().getStartdate(),
                podcastVO.get().getCreatedDate(), userWVO);

        return podcastWVO;

    }

    public List<PodcastWVO> getAllPodcasts() {
        List<PodcastVO> podcastVOList = podcastRepository.findAll();
        List<PodcastWVO> podcastWVOList = new ArrayList<>();
        podcastVOList.forEach(podcastVO -> {

            PodcastWVO podcastWVO = getPodcastById(podcastVO.getId());
            podcastWVOList.add(podcastWVO);
        });
        return podcastWVOList;
    }

    public List<PodcastWVO> getUserPodcasts(Long userId) {
        List<PodcastVO> podcastVOList = podcastRepository.findByUserVO_Id(userId);
        List<PodcastWVO> podcastWVOList = new ArrayList<>();
        podcastVOList.forEach(podcastVO -> {

            PodcastWVO podcastWVO = new PodcastWVO(podcastVO.getName(),
                    podcastVO.getStartdate(), podcastVO.getCreatedDate(), userService.getUserInfosById(userId));
            podcastWVOList.add(podcastWVO);
        });
        return podcastWVOList;

    }

    public List<PodcastWVO> getPodcastbyName(String podcastName) {
        List<PodcastVO> podcastVOList = podcastRepository.findByName(podcastName);
        List<PodcastWVO> podcastWVOList = new ArrayList<>();
        podcastVOList.forEach(podcastVO -> {
            PodcastWVO podcastWVO = new PodcastWVO(podcastVO.getName(),
                    podcastVO.getStartdate(), podcastVO.getCreatedDate(), userService.getUserInfosById(podcastVO.getUserVO().getId()));
            podcastWVOList.add(podcastWVO);
        });
        return podcastWVOList;

    }


    public void addNewPodcast(PodcastWVO podcastWVO) {

        PodcastVO podcastVO = new PodcastVO(podcastWVO.getName(), podcastWVO.getStartdate(),
                LocalDateTime.now(), userRepository.findUserVOById(podcastWVO.getUserWVO().getId()));

        podcastRepository.saveAndFlush(podcastVO);

        List<PodcastGenreWVO> podcastGenreWVOS = podcastWVO.getPodcastGenreWVOS();
        //  List<PodcastGenreVO> podcastGenreVOS = new ArrayList<>();
        podcastGenreWVOS.forEach(podcastGenreWVO -> {
            GenreVO genreVO = genreRepository.findByIdGenre(podcastGenreWVO.getGenreWVO().getId());
           /* GenreVO genreVO = new GenreVO(podcastGenreWVO.getGenreWVO().getName(),
                    podcastGenreWVO.getGenreWVO().getDescription(),
                    podcastGenreWVO.getGenreWVO().isKidFriendly());*/

            PodcastGenreVO podcastGenreVO = new PodcastGenreVO(podcastVO, genreVO);

            podcastGenreRepository.saveAndFlush(podcastGenreVO);
        });

    }


    public List<PodcastWVO> getUpcomingPodcasts() {
        List<PodcastWVO> allPodcastWVOList = getAllPodcasts();
        List<PodcastWVO> upcomingPodcasts = new ArrayList<>();
        allPodcastWVOList.forEach(podcastWVO -> {

            if (podcastWVO.getStartdate().compareTo(LocalDateTime.now()) > 0) {
                upcomingPodcasts.add(podcastWVO);
            }

        });
        return upcomingPodcasts;
    }


    public List<PodcastWVO> getUnboughtPodcasts(Long userId) {
        List<PodcastWVO> upcomingPodcasts = getUpcomingPodcasts();
        List<PodcastWVO> unboughtPodcasts = new ArrayList<>();
        List<InventairePodcastWVO> usersboughtPodcasts = inventairePodcastService.getInventoryByUserId(userId);

        upcomingPodcasts.forEach(podcastWVO -> {

            if (!(usersboughtPodcasts.stream().map(InventairePodcastWVO::getPodcastWVO).anyMatch(podcastWVO1 ->
                    podcastWVO.equals(podcastWVO1)))) {

                unboughtPodcasts.add(podcastWVO);
            }
        });
        return unboughtPodcasts;
    }

}
