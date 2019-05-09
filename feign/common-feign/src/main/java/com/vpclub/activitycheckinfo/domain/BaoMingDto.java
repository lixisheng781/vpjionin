package com.vpclub.activitycheckinfo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaoMingDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long activityId;

	private Long userId;

	private Long schoolId;

	private String fileUrl;

	private Long orgId;

	private int signinType;

	private Long allowClassId;
}
