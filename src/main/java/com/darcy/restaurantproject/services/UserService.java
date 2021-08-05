package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.UserGetDTO;
import com.darcy.restaurantproject.dtos.UserPostDTO;
import com.darcy.restaurantproject.entities.User;
import com.darcy.restaurantproject.mappers.UserMapper;
import com.darcy.restaurantproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Darcy Xian  5/8/21  11:23 am      restaurantProject
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserGetDTO> findAllUsers (){
        return userRepository.findAll().stream()
                .map(userMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
        return;
    }

    public UserGetDTO addNewUser(UserPostDTO userPostDTO){

        User user =   userMapper.toEntity(userPostDTO);
        user.setEncodedPassword(encodePassword(user.getEncodedPassword()));
        User userReturn = userRepository.save(user);
        return userMapper.fromEntity(userReturn);
    }

    public UserGetDTO updateUser(Long id,UserPostDTO userPostDTO){
        User user = userRepository.findById(id).get();
        if(userPostDTO.getUsername() != null){
            user.setUsername(userPostDTO.getUsername());
        }
        if(userPostDTO.getEncodedPassword() != null){
            user.setEncodedPassword(encodePassword(userPostDTO.getEncodedPassword()));
        }
        if(userPostDTO.getAuthorities() != null){
            user.setAuthorities(userPostDTO.getAuthorities());
        }

        User userReturn = userRepository.save(user);
        return userMapper.fromEntity(userReturn);

    }

   private String encodePassword(String rawPassword){
        return new BCryptPasswordEncoder(10).encode(rawPassword);
   }

}
