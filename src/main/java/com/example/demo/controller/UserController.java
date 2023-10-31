package com.example.demo.controller;

import com.example.demo.model.VO.UserVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.constants.ENDPOINTS.*;
import static com.example.demo.constants.PARAMS.USER_ID;

@RestController
@RequestMapping(USER_ENDPOINT)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(USER_GET_INFOS)
    public UserWVO GetUserInfos(@RequestParam(USER_ID) Long userId) {

        return userService.getUserInfosById(userId);


    }

    @GetMapping(ACTIVE_USER)
    public UserWVO getActiveUserInfos() {
        return userService.getActiveUserInfos();
    }

    @PutMapping(MODIFY_INFOS_USER)
    public UserWVO updateActiveUserInfos(@RequestBody UserWVO userWVO){
        return userService.modifyActiveUserInfos(userWVO);
    }


}
