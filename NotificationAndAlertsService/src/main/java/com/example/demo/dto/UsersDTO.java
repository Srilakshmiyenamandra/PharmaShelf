package com.example.demo.dto;

import com.example.demo.entity.Role;

public class UsersDTO {
	
	private Long userID;    
    private String name;   
    private Role role;   
    private String email;  
    private String password;  
    private String phone;
    private String status;
    
	public Long getUserID() {
		return userID;
	}
	
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UsersDTO [userID=" + userID + ", name=" + name + ", role=" + role + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", status=" + status + "]";
	}
    
    

}
