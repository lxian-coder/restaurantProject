package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.UserGetDTO;
import com.darcy.restaurantproject.dtos.UserPostDTO;
import com.darcy.restaurantproject.entities.Authority;
import com.darcy.restaurantproject.entities.User;
import com.darcy.restaurantproject.mappers.UserMapper;
import com.darcy.restaurantproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Darcy Xian  5/8/21  11:23 am      restaurantProject
 */
@Service
@RequiredArgsConstructor
@Slf4j
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
   public UserGetDTO findUserById(Long id){
        return userMapper.fromEntity(userRepository.findById(id).get());
   }


    public UserGetDTO addNewUser(UserPostDTO userPostDTO){

        User user =   userMapper.toEntity(userPostDTO);
        String rawPassword = user.getEncodedPassword();
        log.info("RawPassword:"+rawPassword);
        log.info("RawName: "+ user.getUsername());
        log.info("Authrorities:"+user.getAuthorities().iterator().next().getPermission());

        user.setEncodedPassword(encodePassword(rawPassword));
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
