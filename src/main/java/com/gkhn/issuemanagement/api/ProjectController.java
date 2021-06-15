package com.gkhn.issuemanagement.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gkhn.issuemanagement.dto.ProjectDto;
import com.gkhn.issuemanagement.service.impl.ProjectServiceImpl;
import com.gkhn.issuemanagement.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = ApiPaths.ProjectCtrl.CTRL)
@Api(value="Project APIs", description = "Project APIs")
public class ProjectController {
	
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);


	private final ProjectServiceImpl projectServiceImpl;

	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
	}

	@GetMapping("/{id}")
	@ApiOperation( value="GetBy Id Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
		logger.info("ProjectController-> GetById");
		logger.debug("ProjectController-> GetById ->Param : "+id);
		ProjectDto projectDto = projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}

	@PostMapping()
//	@ApiOperation(value="Create Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}

//	@RequestMapping(path = "/update",method = RequestMethod.PUT)
	@PutMapping("/{id}")
//	@ApiOperation(value="Update Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id,
			@Valid @RequestBody ProjectDto project) {
		// SOLID'E TERS SAVE METODU İLE UPDATE YAPARSAK. TEK BİR FONKSİYONA HEM SAVE HEM
		// UPDATE YAPMAMALI
		return ResponseEntity.ok(projectServiceImpl.update(id, project));
	}

	@DeleteMapping("/{id}")
//	@ApiOperation(value="Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(projectServiceImpl.delete(id));
	}

}
