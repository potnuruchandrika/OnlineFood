package com.chandrika.onlinefood.OnlineFoodBackEnd.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	
	@Column(unique=true)
	private String phoneNo;
	
	private String emailId;
	
	private String password;
	
	private String address;
	
	private LocalDateTime RegistrationDate;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, String userName, String phoneNo, String emailId, String password, String address,
			LocalDateTime registrationDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		RegistrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phoneNo=" + phoneNo + ", emailId=" + emailId
				+ ", password=" + password + ", address=" + address + ", RegistrationDate=" + RegistrationDate + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		RegistrationDate = registrationDate;
	}
	
	
	
}
