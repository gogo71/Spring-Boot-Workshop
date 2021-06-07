package com.gkhn.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Table(name="ISSUE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name="DESCRIPTION",length = 400)
    private String description;

    @Column(name="DETAILS", length = 4000)
    private String details;

    @Column(name="DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "ISSUE_STATUS")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name="ASSIGNEE_USER_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)  //Bir çok konu bir kullanıcıya bağlanabilir. Optional issue usera atanmasa da olur anlamında.
    private User assignee;               //EAGER Dediğinde her zaman User tablosundaki datayı getir demek. // LAZY sadece gerektiginde getir demek.

    @JoinColumn(name="PROJECT_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
    
    
}
