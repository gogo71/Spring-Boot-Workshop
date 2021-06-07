package com.gkhn.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="UNAME", length = 100, unique = true)
    private String username;
    @Column(name="PWD", length = 200)
    private String password;
    @Column(name="NAME_SURNAME", length = 200)
    private String nameSurname;
    @Column(name="EMAIL", length = 100)
    private String email;

    @JoinColumn(name="ASSIGNEE_USER_ID")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
    
    
    
}
