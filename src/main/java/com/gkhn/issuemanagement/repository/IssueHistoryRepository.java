package com.gkhn.issuemanagement.repository;

import com.gkhn.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
}
