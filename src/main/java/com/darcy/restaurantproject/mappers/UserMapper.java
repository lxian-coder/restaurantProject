package com.darcy.restaurantproject.mappers;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.dtos.UserGetDTO;
import com.darcy.restaurantproject.dtos.UserPostDTO;
import com.darcy.restaurantproject.entities.Menu;
import com.darcy.restaurantproject.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Darcy Xian  5/8/21  11:15 am      restaurantProject
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toEntity(UserPostDTO userPostDTO);

    UserGetDTO fromEntity(User user);

}