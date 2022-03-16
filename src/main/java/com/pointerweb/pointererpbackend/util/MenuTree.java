package com.pointerweb.pointererpbackend.util;

import com.pointerweb.pointererpbackend.model.Menu;
import com.pointerweb.pointererpbackend.model.dto.MenuDTO;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {

    private List<Menu> menuList = new ArrayList<>();

    public MenuTree(List<Menu> menuList) {
        this.menuList = menuList;
    }

    //Establish tree structure
    public List<Menu> builTree() {
        List<Menu> treeMenus = new ArrayList<>();
        for (Menu menuNode : getRootNode()) {
            menuNode = buildChilTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //Recursion, building subtree structure
    private Menu buildChilTree(Menu pNode) {
        List<Menu> chilMenus = new ArrayList<>();
        for (Menu menuNode : menuList) {
            if (menuNode.getOpmNumPred().equals(pNode.getOpmNum())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    //Get root node
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists = new ArrayList<>();
        for (Menu menuNode : menuList) {
            if (menuNode.getOpmNumPred().equals("") || menuNode.getOpmNumPred() == null) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }
}
