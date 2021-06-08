package com.gkhn.issuemanagement.service;

import com.gkhn.issuemanagement.dto.IssueDto;
import com.gkhn.issuemanagement.entity.Issue;
import com.gkhn.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface IssueService {
    IssueDto save(IssueDto issueDto);
    IssueDto getById(Long id);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(IssueDto issue);

}
