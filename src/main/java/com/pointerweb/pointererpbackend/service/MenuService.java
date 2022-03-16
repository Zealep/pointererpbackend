package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    List<MenuDTO> findByModulo(String modulo);
}
