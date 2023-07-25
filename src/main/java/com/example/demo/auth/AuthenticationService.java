package com.example.demo.auth;


import com.example.demo.configuration.JwtService;
import com.example.demo.model.VO.InventaireVO;
import com.example.demo.model.VO.TokenType;
import com.example.demo.model.VO.TokenVO;
import com.example.demo.model.VO.UserVO;
import com.example.demo.model.WVO.UserWVO;
import com.example.demo.repository.InventaireRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final InventaireRepository inventaireRepository;
    private final TokenRepository tokenRepository;


    @Autowired
    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder, JwtService jwtService,
                                 AuthenticationManager authenticationManager, InventaireRepository inventaireRepository,
                                 TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.inventaireRepository = inventaireRepository;
        this.tokenRepository = tokenRepository;
    }


    AuthenticationResponse register(UserWVO userWVO) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        InventaireVO inventaireVO = new InventaireVO();
        inventaireRepository.saveAndFlush(inventaireVO);

        var userVO = new UserVO(userWVO.getPseudoname(),
                userWVO.getMail(),
                userWVO.getName(),
                userWVO.getSurname(),
                passwordEncoder.encode(userWVO.getPassword()),
                userWVO.getDob(),
                inventaireVO);

        var savedUser = userRepository.saveAndFlush(userVO);
        var jwToken = jwtService.generateToken(userVO);
        var refreshToken = jwtService.generateRefreshToken(userVO);
        authenticationResponse.setAccessToken(jwToken);
        authenticationResponse.setRefreshToken(refreshToken);
        saveUserToken(savedUser, jwToken);
        return authenticationResponse;
    }

    private void saveUserToken(UserVO user, String jwtToken) {
        var token = new TokenVO(jwtToken, TokenType.BEARER, false, false, user);
        tokenRepository.saveAndFlush(token);
    }

    AuthenticationResponse login(UserWVO userWVO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userWVO.getMail(),
                            userWVO.getPassword()
                    )
            );
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        var userVO = userRepository.findByMail(userWVO.getMail()).orElseThrow();
        var jwToken = jwtService.generateToken(userVO);
        var refreshToken = jwtService.generateRefreshToken(userVO);

        revokeAllUserTokens(userVO);
        saveUserToken(userVO, jwToken);
        return new AuthenticationResponse(jwToken, refreshToken);
    }

    private void revokeAllUserTokens(UserVO user) {
        var validUserTokens = tokenRepository.findByUser_IdAndRevokedAndExpired(user.getId(), false, false);
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, java.io.IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserMail(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByMail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = new AuthenticationResponse(accessToken, refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }


}
