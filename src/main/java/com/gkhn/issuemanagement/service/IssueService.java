package com.gkhn.issuemanagement.service;

import org.springframework.data.domain.Pageable;

import com.gkhn.issuemanagement.dto.IssueDto;
import com.gkhn.issuemanagement.util.TPage;

public interface IssueService {
    IssueDto save(IssueDto issueDto);
    IssueDto getById(Long id);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(IssueDto issue);
    IssueDto update(Long id, IssueDto issue);

}
