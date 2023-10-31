package com.example.demo.service;

import com.example.demo.model.VO.InventairePodcastVO;
import com.example.demo.model.WVO.InventairePodcastWVO;
import com.example.demo.model.WVO.InventaireWVO;
import com.example.demo.model.WVO.PodcastWVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.repository.InventairePodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class InventairePodcastService {
    private final InventairePodcastRepository inventairePodcastRepository;
    private final UserService userService;
    private final PodcastService podcastService;

    @Autowired
    public InventairePodcastService(InventairePodcastRepository inventairePodcastRepository,
                                    UserService userService, PodcastService podcastService) {
        this.inventairePodcastRepository = inventairePodcastRepository;
        this.userService = userService;
        this.podcastService = podcastService;
    }

    public List<InventairePodcastWVO> getInventoryByUserMail(String userMail) {
        List<InventairePodcastVO> inventairePodcastVOList = inventairePodcastRepository.findById_InventaireVO_UserVO_Mail(userMail);
        List<InventairePodcastWVO> inventairePodcastWVOList = new ArrayList<>();
        inventairePodcastVOList.forEach(inventairePodcastVO -> {

            PodcastWVO podcastWVO = podcastService.getPodcastById(inventairePodcastVO.getId().getPodcastVO().getId());

            InventairePodcastWVO inventairePodcastWVO = new InventairePodcastWVO(podcastWVO);
            inventairePodcastWVOList.add(inventairePodcastWVO);
        });

        return inventairePodcastWVOList;
    }

    public List<InventairePodcastWVO> getActiveUserPodcasts() {

        return getInventoryByUserMail(userService.getActiveUserInfos().getMail());

    }


}
