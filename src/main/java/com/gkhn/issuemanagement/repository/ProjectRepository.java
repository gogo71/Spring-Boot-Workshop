package com.gkhn.issuemanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gkhn.issuemanagement.entity.Project;
//@Repository Autowired için gerekli. Ancak JPARepository Spring 2.0 dan sonra gerek kalmadı.
public interface ProjectRepository extends JpaRepository<Project, Long> {
	Project save(Project proje);
    Project getByProjectCode(String projectCode);
      Project getByProjectCodeAndIdNot(String projectCode, Long id);
//    List<Project> getAllByProjectCodeAndIdNotNull(String projectCode);
//    List<Project> getAllByProjectCodeAnAndProjectNameContains(String projectCode, String name);
    Page<Project> findAll(Pageable pageable);
    List<Project> findAll(Sort sort);
     void deleteById(Long id);
}
