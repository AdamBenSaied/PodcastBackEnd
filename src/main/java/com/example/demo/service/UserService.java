package com.example.demo.service;

import com.example.demo.model.VO.InventaireVO;
import com.example.demo.model.VO.UserVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.repository.InventaireRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        UserWVO userWVO = new UserWVO(
                userVO.getPseudoname(),
                userVO.getMail(),
                userVO.getName(),
                userVO.getSurname(),
                userVO.getAge(),
                userVO.getDob(),
                userVO.getProphilePhoto()
        );

        return userWVO;
    }


    public UserWVO getActiveUserInfos() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserVO currentUser = (UserVO) authentication.getPrincipal();
        UserWVO userWVO = new UserWVO(currentUser.getPseudoname(), currentUser.getMail(),
                currentUser.getName(), currentUser.getSurname(),
                currentUser.getAge(), currentUser.getDob(), currentUser.getProphilePhoto());
        return userWVO;
    }

    public UserWVO modifyActiveUserInfos(UserWVO userWVO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserVO currentUser = (UserVO) authentication.getPrincipal();
        if ((userWVO.getDob() != currentUser.getDob()) && userWVO.getDob() !=null ) {
            currentUser.setDob(userWVO.getDob());
        }
        if ( (userWVO.getName() != currentUser.getName()) && userWVO.getName() !=null) {
            currentUser.setName(userWVO.getName());
        }
        if ((userWVO.getPseudoname() != currentUser.getPseudoname()) && userWVO.getPseudoname() !=null) {
            currentUser.setPseudoname(userWVO.getPseudoname());
        }
        if ((userWVO.getProfilePhoto() != currentUser.getProphilePhoto()) && userWVO.getProfilePhoto() !=null) {
            currentUser.setProphilePhoto(userWVO.getProfilePhoto());
        }

        userRepository.saveAndFlush(currentUser);

        return getActiveUserInfos();
    }

}


