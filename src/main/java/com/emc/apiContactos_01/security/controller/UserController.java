package com.emc.apiContactos_01.security.controller;

import com.emc.apiContactos_01.security.entity.UserInfo;
import com.emc.apiContactos_01.security.model.UserModel;
import com.emc.apiContactos_01.security.service.InfoUserDetailService;
import com.emc.apiContactos_01.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador Rest.
 * "Escucha" las siguientes URLs para registrar y autorizar un usuario.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private InfoUserDetailService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome(@RequestBody UserInfo userInfo) {
        return "Welcome "+ userInfo.getName();
    }

    /**
     * Registra un usuario en la BBDD
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    /**
     * Valida el usuario y retorna un token para si está registrado
     * @param userModel
     * @return
     */
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody UserModel userModel) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userModel.getUsername(), userModel.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userModel.getUsername());
        } else {
            System.out.println("No se encuentra el usuario");
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
}
