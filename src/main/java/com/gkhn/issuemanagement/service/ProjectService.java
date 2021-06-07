package com.gkhn.issuemanagement.service;

import com.gkhn.issuemanagement.entity.Issue;
import com.gkhn.issuemanagement.entity.Project;
import com.gkhn.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ProjectService {
    Project save(Project project);
    Project getById(BigInteger id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

}
