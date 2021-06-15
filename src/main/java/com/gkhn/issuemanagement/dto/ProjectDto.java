package com.gkhn.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
    @ApiModelProperty(value = "Project ID")
    private Long id;
    @javax.validation.constraints.NotNull
    @ApiModelProperty(required = true,value = "Name of Project")
    private String projectName;
    @javax.validation.constraints.NotNull
    @ApiModelProperty(required = true,value = "Code of Project")
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
