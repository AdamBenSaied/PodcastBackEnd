package com.example.demo.controller;

import com.example.demo.model.WVO.InventairePodcastWVO;
import com.example.demo.service.InventairePodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.constants.ENDPOINTS.*;
import static com.example.demo.constants.PARAMS.USER_ID;
import static com.example.demo.constants.PARAMS.USER_MAIL;

import java.util.List;

@RestController
@RequestMapping(path = INVENTAIRE_ENDPOINT)
public class InventairePodcastController {

    private final InventairePodcastService inventairePodcastService;

    @Autowired
    public InventairePodcastController(InventairePodcastService inventairePodcastService) {
        this.inventairePodcastService = inventairePodcastService;
    }

    @GetMapping(INVENTAIRE_GET_BY_USER_ID)
    public List<InventairePodcastWVO> getInventoryByUserMail(@RequestParam(USER_MAIL) String userMail)
    {
        return inventairePodcastService.getInventoryByUserMail(userMail);
    }


    @GetMapping(path = INVENTAIRE_BOUGHT_ACTIVE_USER)
    public List<InventairePodcastWVO> boughtPodcastsActiveUser(){

        return inventairePodcastService.getActiveUserPodcasts();
    }



}
