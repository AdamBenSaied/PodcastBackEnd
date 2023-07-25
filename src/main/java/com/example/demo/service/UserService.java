package com.example.demo.service;

import com.example.demo.model.VO.InventaireVO;
import com.example.demo.model.VO.UserVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.repository.InventaireRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final InventaireRepository inventaireRepository;

    @Lazy
    @Autowired
    public UserService(UserRepository userRepository, InventaireRepository inventaireRepository) {
        this.userRepository = userRepository;
        this.inventaireRepository = inventaireRepository;
    }

    public UserWVO getUserInfosById(Long userId) {

        UserVO userVO = userRepository.findUserVOById(userId);
        UserWVO userWVO= new UserWVO(
                userVO.getPseudoname(),
                userVO.getMail(),
                userVO.getName(),
                userVO.getSurname(),
                userVO.getAge(),
                userVO.getDob()
        );

return userWVO;
    }

    public void createUser(UserWVO userWVO) {

        InventaireVO inventaireVO = new InventaireVO();

        inventaireRepository.saveAndFlush(inventaireVO);

        UserVO userVO = new UserVO(userWVO.getPseudoname(),userWVO.getMail(),
                userWVO.getName(),userWVO.getSurname(),userWVO.getPassword(), userWVO.getDob(),inventaireVO);
        userRepository.saveAndFlush(userVO);



    }
}
