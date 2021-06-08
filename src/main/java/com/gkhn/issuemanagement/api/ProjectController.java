package com.gkhn.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@PostMapping()
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
	
	
//	@RequestMapping(path = "/update",method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project){
		//SOLID'E TERS SAVE METODU İLE UPDATE YAPARSAK. TEK BİR FONKSİYONA HEM SAVE HEM UPDATE YAPMAMALI
		return ResponseEntity.ok(projectServiceImpl.update(id,project));
	}
	
	
	
}
