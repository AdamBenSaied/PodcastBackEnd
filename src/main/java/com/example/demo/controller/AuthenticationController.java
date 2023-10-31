package com.example.demo.controller;


import com.example.demo.auth.AuthenticationResponse;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.demo.constants.ENDPOINTS.*;

@RestController
@RequestMapping(AUTH_ENDPOINT)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = AUTH_REGISTER)
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserWVO userWVO) {

        return ResponseEntity.ok(authenticationService.register(userWVO));
    }

    @PostMapping(path = AUTH_LOGIN)
    public ResponseEntity<AuthenticationResponse> login(@RequestBody UserWVO userWVO) {
        return authenticationService.login(userWVO);
    }
    @PostMapping(path = REFRESH_TOKEN)
    public void refreshToken( HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request, response);
    }

}
