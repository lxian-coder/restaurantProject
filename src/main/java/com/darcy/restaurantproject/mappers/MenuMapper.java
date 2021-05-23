package com.darcy.restaurantproject.mappers;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.entities.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Darcy Xian  9/5/21  5:11 pm      restaurantProject
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {

    Menu toEntity(MenuPostDTO menuPostDTO);

    MenuGetDTO fromEntity(Menu menu);

}
