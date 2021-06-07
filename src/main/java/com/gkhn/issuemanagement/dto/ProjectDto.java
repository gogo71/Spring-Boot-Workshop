package com.gkhn.issuemanagement.dto;

import java.math.BigInteger;

public class ProjectDto {
    private BigInteger id;
    private String projectName;
    private String projectCode;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
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
