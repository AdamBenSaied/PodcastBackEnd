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

    public List<InventairePodcastWVO> getInventoryByUserId(Long userId) {
        List<InventairePodcastVO> inventairePodcastVOList = inventairePodcastRepository.findById_InventaireVO_UserVO_Id(userId);
        List<InventairePodcastWVO> inventairePodcastWVOList = new ArrayList<>();
        inventairePodcastVOList.forEach(inventairePodcastVO -> {

            UserWVO userInventoryOwnerWVO = userService.getUserInfosById
                    (inventairePodcastVO.getId().getInventaireVO().getUserVO().getId());

            InventaireWVO inventaireWVO = new InventaireWVO(inventairePodcastVO.getId().getInventaireVO().getId(), userInventoryOwnerWVO);

          //  UserWVO userCreatorWVO = userService.getUserInfosById(inventairePodcastVO.getId().getPodcastVO().getUserVO().getId());


            PodcastWVO podcastWVO = podcastService.getPodcastById(inventairePodcastVO.getId().getPodcastVO().getId());

            InventairePodcastWVO inventairePodcastWVO = new InventairePodcastWVO(inventaireWVO, podcastWVO);
            inventairePodcastWVOList.add(inventairePodcastWVO);
        });

        return inventairePodcastWVOList;
    }


}
