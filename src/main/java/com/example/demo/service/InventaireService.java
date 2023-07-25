package com.example.demo.service;

import com.example.demo.model.VO.InventaireVO;
import com.example.demo.model.WVO.InventaireWVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.repository.InventaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventaireService {
    private final InventaireRepository inventaireRepository;
    private final UserService userService;

    @Autowired
    public InventaireService(InventaireRepository inventaireRepository, UserService userService) {
        this.inventaireRepository = inventaireRepository;
        this.userService = userService;
    }

    public List<InventaireWVO> getAllInventaire(){
        List<InventaireVO> inventaireVOList = inventaireRepository.findAll();
        List<InventaireWVO> inventaireWVOList = new ArrayList<>();
        inventaireVOList.forEach(inventaireVO -> {
            UserWVO userWVO = userService.getUserInfosById(inventaireVO.getUserVO().getId());
            InventaireWVO inventaireWVO = new InventaireWVO(inventaireVO.getId(),userWVO);
            inventaireWVOList.add(inventaireWVO);
        });
return inventaireWVOList;
    }


}
