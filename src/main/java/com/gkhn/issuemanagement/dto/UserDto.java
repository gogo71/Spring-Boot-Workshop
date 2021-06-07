package com.gkhn.issuemanagement.dto;

import java.math.BigInteger;

public class UserDto {
    private BigInteger id;
    private String nameSurname;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getNameSurname() {
		return nameSurname;
	}
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}
    
    
}
