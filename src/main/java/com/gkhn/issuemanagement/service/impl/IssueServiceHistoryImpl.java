package com.gkhn.issuemanagement.service.impl;

import com.gkhn.issuemanagement.entity.IssueHistory;
import com.gkhn.issuemanagement.repository.IssueHistoryRepository;
import com.gkhn.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class IssueServiceHistoryImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueServiceHistoryImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if(issueHistory.getDate() == null){
            throw new IllegalArgumentException("Issue history cannot be null");
        }
        issueHistory = issueHistoryRepository.save(issueHistory);
        return issueHistory;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getById(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
