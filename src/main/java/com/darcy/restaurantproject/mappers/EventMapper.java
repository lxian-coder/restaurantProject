package com.darcy.restaurantproject.mappers;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.dtos.EventPostDTO;
import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.entities.Event;
import com.darcy.restaurantproject.entities.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Darcy Xian  23/5/21  10:17 pm      restaurantProject
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    Event toEntity(EventPostDTO eventPostDTO);

    EventGetDTO fromEntity(Event event);

}
