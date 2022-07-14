package com.ttx.ecommerce.controller;

import com.ttx.ecommerce.dto.*;
import com.ttx.ecommerce.dto.user.SignInDto;
import com.ttx.ecommerce.dto.user.SignInResponseDto;
import com.ttx.ecommerce.dto.user.SignupDto;
import com.ttx.ecommerce.exceptions.AuthenticationFailException;
import com.ttx.ecommerce.exceptions.CustomException;
import com.ttx.ecommerce.model.User;
import com.ttx.ecommerce.repository.UserRepository;
import com.ttx.ecommerce.service.AuthenticationService;
import com.ttx.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }
}
