package com.gkhn.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="ISSUE_HISTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class IssueHistory extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JoinColumn(name="ISSUE_ID",referencedColumnName = "ID")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Issue issue;

    @Column(name="DESCRIPTION", length = 1000)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE")
    private Date date;

    @Column(name="ISSUE_STATUS")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Column(name="DETAILS", length = 4000)
    private String details;



    @JoinColumn(name="ASSIGNEE_USER_ID",referencedColumnName = "ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public IssueStatus getIssueStatus() {
		return issueStatus;
	}



	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}



	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}



	public User getAssignee() {
		return assignee;
	}



	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}



	public Issue getIssue() {
		return issue;
	}

	
	


	public void setIssue(Issue issue) {
		this.issue = issue;
	}
    
    
    
}
