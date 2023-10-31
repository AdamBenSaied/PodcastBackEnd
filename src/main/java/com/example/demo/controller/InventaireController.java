package com.example.demo.controller;

import com.example.demo.model.VO.InventaireVO;
import com.example.demo.model.WVO.InventaireWVO;
import com.example.demo.service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.constants.ENDPOINTS.*;

@RestController
@RequestMapping(INVENTAIRE_ENDPOINT)
public class InventaireController {

    private InventaireService inventaireService;

    @Autowired
    public InventaireController(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    @GetMapping(path = INVENTAIRE_ALL)
    public List<InventaireWVO> getInventoryById() {
        return inventaireService.getAllInventaire();
    }


}
