package com.vpclub.admin.model.response;

import com.vpclub.admin.entity.MenuBaseInfoEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MenuResponse {
    private List<MenuBaseInfoEntity> menuList;
    private Set<String> permissions;
}
