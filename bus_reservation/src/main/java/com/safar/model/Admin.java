package com.safar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminID;

    @NotNull(message = "Name can not be null!")
    @NotBlank(message = "Name can not be blank!")
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @NotNull(message="Password can not be null!")
    @NotBlank(message= "Password can not be blank!")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters including alphanumerics and special characters")
    private String password;
    
    
    

	public Admin(Integer adminID,
			@NotNull(message = "Name can not be null!") @NotBlank(message = "Name can not be blank!") String name,
			@Email String email,
			@NotNull(message = "Password can not be null!") @NotBlank(message = "Password can not be blank!") @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters including alphanumerics and special characters") String password) {
		super();
		this.adminID = adminID;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
    
    
}
