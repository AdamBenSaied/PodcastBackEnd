package com.example.demo.controller;

import com.example.demo.model.VO.InventairePodcastVO;
import com.example.demo.model.WVO.InventairePodcastWVO;
import com.example.demo.model.WVO.PodcastWVO;
import com.example.demo.service.InventairePodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.constants.ENDPOINTS.*;
import static com.example.demo.constants.PARAMS.USER_ID;

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
    public List<InventairePodcastWVO> getInventoryByUserId(@RequestParam(USER_ID) Long userId)
    {
        return inventairePodcastService.getInventoryByUserId(userId);
    }



}
