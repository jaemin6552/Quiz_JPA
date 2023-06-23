package home.JPA.controller;

import home.JPA.config.jwt.TokenProvider;
import home.JPA.dto.JoinDto;
import home.JPA.dto.LoginDto;
import home.JPA.dto.TokenDto;
import home.JPA.entity.RefreshToken;
import home.JPA.repository.RefreshTokenRedisRepository;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/refresh")
@RequiredArgsConstructor
@Slf4j
public class JwtController {
    private final TokenProvider tokenProvider;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;
    @PostMapping("")
    public ResponseEntity<?> reissueAccessToken(@RequestHeader("Authorization") String header) throws IOException {
        System.out.println("컨트롤러에 값들어옴");
        return tokenProvider.reissue(header.substring(7));
    }

}