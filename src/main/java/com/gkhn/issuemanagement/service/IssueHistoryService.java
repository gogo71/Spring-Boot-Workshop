package com.gkhn.issuemanagement.service;

import com.gkhn.issuemanagement.entity.Issue;
import com.gkhn.issuemanagement.entity.IssueHistory;
import com.gkhn.issuemanagement.repository.IssueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);
    IssueHistory getById(BigInteger id);
    Page<IssueHistory> getAllPageable(Pageable pageable);
    Boolean delete(IssueHistory issueHistory);

}
