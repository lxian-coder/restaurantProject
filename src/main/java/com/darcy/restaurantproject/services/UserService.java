package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.UserGetDTO;
import com.darcy.restaurantproject.dtos.UserPostDTO;
import com.darcy.restaurantproject.entities.Authority;
import com.darcy.restaurantproject.entities.User;
import com.darcy.restaurantproject.mappers.UserMapper;
import com.darcy.restaurantproject.repositories.AuthorityRepository;
import com.darcy.restaurantproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    private final AuthorityRepository authorityRepository;


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

        User user = userMapper.toEntity(userPostDTO);
        String rawPassword = userPostDTO.getEncodedPassword();
        log.info("RawPassword:"+rawPassword);
        log.info("RawName: "+ userPostDTO.getUsername());
        log.info("Authrorities:"+userPostDTO.getAuthorities().iterator().next().getPermission());
        Authority authority = userPostDTO.getAuthorities().iterator().next();
        String permission = authority.getPermission();
        Authority authorityReturn = authorityRepository.findByPermission(permission).get();
        authority.setId(authorityReturn.getId());
        user.getAuthorities().clear();
        user.getAuthorities().add(authority);


        user.setEncodedPassword(encodePassword(rawPassword));
        log.info("password:"+user.getEncodedPassword());
        log.info("id :"+user.getId());
        log.info("check Auth id:"+user.getAuthorities().iterator().next().getId());
        User userReturn = userRepository.save(user);
        return userMapper.fromEntity(userReturn);
    }

    public UserGetDTO updateUser(Long id,UserPostDTO userPostDTO){
        User user = userRepository.findById(id).get();
        if(userPostDTO.getUsername() != null && userPostDTO.getUsername() != user.getUsername()){
            user.setUsername(userPostDTO.getUsername());
        }
        if(userPostDTO.getEncodedPassword() != null){

            user.setEncodedPassword(encodePassword(userPostDTO.getEncodedPassword()));
        }
        if(userPostDTO.getAuthorities() != null ){
            Authority authority = userPostDTO.getAuthorities().iterator().next();
            String permission = authority.getPermission();
            Authority authorityReturn = authorityRepository.findByPermission(permission).get();
            authority.setId(authorityReturn.getId());
            user.getAuthorities().clear();
            user.getAuthorities().add(authority);
        }
        if(userPostDTO.getPasswordHint() != null){
            user.setPasswordHint(userPostDTO.getPasswordHint());

        }
        User userReturn = userRepository.save(user);
        return userMapper.fromEntity(userReturn);

    }

   private String encodePassword(String rawPassword){
        return new BCryptPasswordEncoder(10).encode(rawPassword);
   }

   public UserGetDTO findUserByName(String name){
        userRepository.findByUsername(name).getAuthorities().stream().forEach(ele->log.info(ele.getPermission()));
       UserGetDTO userGetDTO =  userMapper.fromEntity(userRepository.findByUsername(name));
        log.info( String.valueOf(userGetDTO.getAuthorities().size()));
       return userGetDTO;
   }

}
