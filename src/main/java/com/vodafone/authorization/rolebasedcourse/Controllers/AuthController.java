package com.vodafone.authorization.rolebasedcourse.Controllers;

import com.vodafone.authorization.rolebasedcourse.DTO.AuthResponseDto;
import com.vodafone.authorization.rolebasedcourse.DTO.LoginDto;
import com.vodafone.authorization.rolebasedcourse.DTO.RegisterDto;
import com.vodafone.authorization.rolebasedcourse.Model.Role;
import com.vodafone.authorization.rolebasedcourse.Model.Team;
import com.vodafone.authorization.rolebasedcourse.Model.UserEntity;
import com.vodafone.authorization.rolebasedcourse.Repositories.RoleRepository;
import com.vodafone.authorization.rolebasedcourse.Repositories.TeamRepository;
import com.vodafone.authorization.rolebasedcourse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private TeamRepository teamRepository;
    private PasswordEncoder passwordEncoder;

    private SecurityContextRepository securityContextRepository =
            new HttpSessionSecurityContextRepository();

    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();



    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, TeamRepository teamRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.teamRepository = teamRepository;
    }


//    @PostMapping("/api/auth/register")
//    public ResponseEntity<String > register(@RequestBody RegisterDto registerDto){
//        if(userRepository.existsByUsername(registerDto.getUsername()))
//            return new ResponseEntity<>("Username is taken!!", HttpStatus.BAD_REQUEST);
//
//        UserEntity user = new UserEntity();
//        user.setUsername(registerDto.getUsername());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//
//        Team team = registerDto.getTeam()!= null ? teamRepository.findByName(registerDto.getTeam()).get() : null;
//        Role roles;
//        if(team != null){
//            roles = roleRepositorysitory.findByTeamId(team.getId()).get();
//            team.setRoles(Collections.singletonList(roles));
//            user.setTeams(Collections.singletonList(team));
//        }
//        else{
//            roles = roleRepository.findByName("USER").get();
//        }
//
////        user.setRoles(Collections.singletonList(roles));
//
//
//        userRepository.save(user);
//
//        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
//    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication); //holds all the auth details to not log in each time

        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }



    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginRequest, HttpServletRequest request, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(
                loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);
    }
}
