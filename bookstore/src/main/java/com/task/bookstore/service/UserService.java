package com.task.bookstore.service;

import com.task.bookstore.model.MyUserPrincipal;
import com.task.bookstore.model.User;
import com.task.bookstore.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =userRepository.getUserByUsername(username);
        if(user.isPresent()){
            return  new MyUserPrincipal(user.get());
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
}
