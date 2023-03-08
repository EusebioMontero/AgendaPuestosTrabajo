package com.emc.apiContactos_01.security.service;

import com.emc.apiContactos_01.security.entity.UserInfo;
import com.emc.apiContactos_01.security.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Clase Service para gestionar el usuario en la BBD
 */
@Service
public class InfoUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(InfoUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "userInfo added to system ";
    }
}
