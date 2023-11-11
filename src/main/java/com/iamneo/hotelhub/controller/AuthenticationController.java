package com.iamneo.hotelhub.controller;


import com.iamneo.hotelhub.dto.AuthenticationRequest;
import com.iamneo.hotelhub.dto.RegisterRequest;
import com.iamneo.hotelhub.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;


    @PostMapping("/register")
   public ResponseEntity<String> register(
           @RequestBody RegisterRequest request
    ){
       return  service.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request
    ){
       return  service.authenticateUser(request);
    }
}
