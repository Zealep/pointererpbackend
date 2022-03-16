package com.pointerweb.pointererpbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class MenuDTO {
    private String label;
    private String faIcon;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String link;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuDTO> items;

    public MenuDTO(String label, String faIcon, List<MenuDTO> items) {
        this.label = label;
        this.faIcon = faIcon;
        this.items = items;
    }

    public MenuDTO(){}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFaIcon() {
        return faIcon;
    }

    public void setFaIcon(String faIcon) {
        this.faIcon = faIcon;
    }

    public List<MenuDTO> getItems() {
        return items;
    }

    public void setItems(List<MenuDTO> items) {
        this.items = items;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
