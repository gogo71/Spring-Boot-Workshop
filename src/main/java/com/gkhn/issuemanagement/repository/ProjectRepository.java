package com.gkhn.issuemanagement.repository;

import com.gkhn.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
//@Repository Autowired için gerekli. Ancak JPARepository Spring 2.0 dan sonra gerek kalmadı.
public interface ProjectRepository extends JpaRepository<Project, BigInteger> {
    List<Project> getAllByProjectCode(String projectCode);
//    List<Project> getAllByProjectCodeAndIdNotNull(String projectCode);
//    List<Project> getAllByProjectCodeAnAndProjectNameContains(String projectCode, String name);
    Page<Project> findAll(Pageable pageable);
    List<Project> findAll(Sort sort);
}
