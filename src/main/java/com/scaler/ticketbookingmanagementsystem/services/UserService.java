package com.scaler.ticketbookingmanagementsystem.services;

//import com.scaler.ticketbookingmanagementsystem.Configs.BcryptPasswordEncoderConfigr;
import com.scaler.ticketbookingmanagementsystem.Configs.BcryptPasswordEncoderConfig;
import com.scaler.ticketbookingmanagementsystem.Dtos.ResponseStatus;
import com.scaler.ticketbookingmanagementsystem.Repositories.UserRepository;
import com.scaler.ticketbookingmanagementsystem.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bcryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }
    public User signup(String name, String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            //redirect to login page

        }
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(bcryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }
    public ResponseStatus login(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(!optionalUser.isEmpty()){
            //redirect to signup
        }
        User user = optionalUser.get();
        if(bcryptPasswordEncoder.matches(password, user.getPassword())){
            return ResponseStatus.SUCCESS;
        }
        return ResponseStatus.FAILURE;
    }
}
