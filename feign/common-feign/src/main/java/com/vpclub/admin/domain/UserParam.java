package com.vpclub.admin.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserParam implements Serializable {

    private Long userId;

    private Long schoolId;
}
