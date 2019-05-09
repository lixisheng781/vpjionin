package com.vpclub.admin.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrgDTO implements Serializable {
    private Long orgId;

    private String orgName;
}
