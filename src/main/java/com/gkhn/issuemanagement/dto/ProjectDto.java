package com.gkhn.issuemanagement.dto;

import java.math.BigInteger;

public class ProjectDto {
    private Long id;
    private String projectName;
    private String projectCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
    
    
}
