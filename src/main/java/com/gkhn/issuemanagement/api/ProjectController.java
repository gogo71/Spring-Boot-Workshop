package com.gkhn.issuemanagement.api;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkhn.issuemanagement.dto.ProjectDto;
import com.gkhn.issuemanagement.service.impl.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
public class ProjectController {

	private final ProjectServiceImpl projectServiceImpl;

	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
		ProjectDto projectDto = projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
}
