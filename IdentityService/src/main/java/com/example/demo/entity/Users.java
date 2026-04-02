package com.example.demo.entity;

import jakarta.persistence.*;

@Entity 
@Table(name = "Users")  
public class Users {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long userID;
    
    private String name;
    
    @Enumerated(EnumType.STRING) 
    private Role role;
    
    private String email;
    
    private String password;
    
    private String phone;
    
    //(e.g., "ACTIVE", "INACTIVE")
    private String status;

    public Users() {
        super();
    }

    public Users(Long userID, String name, Role role, String email, String phone, String status) {
        super();
        this.userID = userID;
        this.name = name;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

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
        return "User [userID=" + userID + ", name=" + name + ", role=" + role + ", email=" + email + ", phone=" + phone
                + ", status=" + status + "]";
    }
    
}
