package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.Menu;
import com.pointerweb.pointererpbackend.model.dto.MenuDTO;
import com.pointerweb.pointererpbackend.repository.MenuRepository;
import com.pointerweb.pointererpbackend.service.MenuService;
import com.pointerweb.pointererpbackend.util.Constantes;
import com.pointerweb.pointererpbackend.util.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuDTO> findByModulo(String modulo) {
        List<Menu> menuList = menuRepository.findByModulo(modulo).orElse(null);

        MenuTree menuTree = new MenuTree(menuList);
        List<Menu> menuDTOList = menuTree.builTree();
        return convertObjectMenu(menuDTOList);
    }

    List<MenuDTO> convertObjectMenu(List<Menu> menus) {
        List<MenuDTO> menuDTOList = new ArrayList<>();

        for (Menu m : menus) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setLabel(m.getOpmDes());
            menuDTO.setLink(m.getUrlOperacion());
            List<MenuDTO> subMenuDTOList = new ArrayList<>();
            for (Menu c : m.getChildren()) {
                MenuDTO menuDTO1 = new MenuDTO();
                menuDTO1.setLabel(c.getOpmDes());
                menuDTO1.setLink(c.getUrlOperacion());
                subMenuDTOList.add(menuDTO1);
            }
            menuDTO.setItems(subMenuDTOList);
            menuDTOList.add(menuDTO);
        }
        return menuDTOList;
    }
}
