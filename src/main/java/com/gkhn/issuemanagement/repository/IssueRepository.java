package com.gkhn.issuemanagement.repository;

import com.gkhn.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IssueRepository extends JpaRepository<Issue, BigInteger> {

}
