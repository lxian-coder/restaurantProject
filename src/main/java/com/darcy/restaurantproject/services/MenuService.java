package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.exceptions.ResourceNotFoundException;
import com.darcy.restaurantproject.mappers.MenuMapper;
import com.darcy.restaurantproject.repositories.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Darcy Xian  9/5/21  6:20 pm      restaurantProject
 */
@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public List<MenuGetDTO> listAll() {
        return menuRepository.findAll()
                .stream()
                .map(menuMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public MenuGetDTO addNewMenuItem(MenuPostDTO menuPostDTO) {
        return menuMapper.fromEntity(menuRepository.save(menuMapper.toEntity(menuPostDTO)));
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public MenuGetDTO updateMenu(Long id, MenuPostDTO menuPostDTO) {
        return menuRepository.findById(id).map(menu -> {
            if (menuPostDTO.getCategory() != null) {
                menu.setCategory(menuPostDTO.getCategory());
            }
            if (menuPostDTO.getDescription() != null) {
                menu.setDescription(menuPostDTO.getDescription());
            }
            if (menuPostDTO.getPriceA() != null) {
                menu.setPriceA(menuPostDTO.getPriceA());
            }
            if (menuPostDTO.getPriceB() != null) {
                menu.setPriceB(menuPostDTO.getPriceB());
            }
            menuRepository.save(menu);
            return menuMapper.fromEntity(menu);
        }).orElseThrow(ResourceNotFoundException::new);
    }

}