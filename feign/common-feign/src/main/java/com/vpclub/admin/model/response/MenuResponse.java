package com.vpclub.admin.model.response;

import com.vpclub.admin.entity.SysMenuEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MenuResponse {
    private List<SysMenuEntity> menuList;
    private Set<String> permissions;
}
