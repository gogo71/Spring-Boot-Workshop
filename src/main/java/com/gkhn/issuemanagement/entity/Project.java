package com.gkhn.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="PROJECT_CODE", unique = true)
    private String projectCode;
    @Column(name="PROJECT_NAME")
    private String projectName;
    @JoinColumn(name="MANAGER_USER_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
    
    
}
