package com.gkhn.issuemanagement.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gkhn.issuemanagement.dto.ProjectDto;
import com.gkhn.issuemanagement.entity.Project;
import com.gkhn.issuemanagement.repository.ProjectRepository;
import com.gkhn.issuemanagement.service.ProjectService;
import com.gkhn.issuemanagement.util.TPage;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;

	public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProjectDto save(ProjectDto project) {

		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
		if (projectCheck != null)
			throw new IllegalArgumentException("Project Code Already Exist");

		Project p = modelMapper.map(project, Project.class);
		p = projectRepository.save(p);
		project.setId(p.getId());
		return project;
	}

	@Override
	public ProjectDto getById(Long id) {
		Project p = projectRepository.getById(id);
		return modelMapper.map(p, ProjectDto.class);
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {
		return null;
	}

	@Override
	public List<ProjectDto> getByProjectCodeContains(String projectCode) {
		return null;
	}

	@Override
	public TPage<ProjectDto> getAllPageable(Pageable pageable) {
		Page<Project> data = projectRepository.findAll(pageable);
		TPage<ProjectDto> response = new TPage<ProjectDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
		return response;
	}

	@Override
	public Boolean delete(ProjectDto project) {
		return null;
	}
	

	
	public Boolean delete(Long id) {
	    projectRepository.deleteById(id);
		return true;
		
	}


	@Override
	public ProjectDto update(Long id, ProjectDto project) {

		Project projectDb = projectRepository.getById(id);
		if (projectDb == null)
			throw new IllegalArgumentException("Project Code Does Not Exist:" + id);

//		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
//		if (projectCheck != null && projectCheck.getId() != projectDb.getId())
//		throw new IllegalArgumentException("Project Code Already Exist");
		Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
		if (projectCheck != null)
			throw new IllegalArgumentException("Project Code Already Exist");

		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		
		projectRepository.save(projectDb);
		return modelMapper.map(projectDb, ProjectDto.class);

	}
}
