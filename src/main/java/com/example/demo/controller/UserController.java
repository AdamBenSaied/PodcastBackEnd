package com.example.demo.controller;

import com.example.demo.model.WVO.UserWVO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.constants.ENDPOINTS.*;
import static com.example.demo.constants.PARAMS.USER_ID;

@RestController
@RequestMapping(USER_ENDPOINT)
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(USER_GET_INFOS)
    public UserWVO GetUserInfos(@RequestParam (USER_ID) Long userId){

        return userService.getUserInfosById(userId);


    }


    @PostMapping(USER_SIGN_UP)
    public void createUser(@RequestBody UserWVO userWVO)
    {
        userService.createUser(userWVO);
    }







}
