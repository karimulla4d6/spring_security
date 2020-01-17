package com.security.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userName;
	private String password;
	/*
	 * @Column(name="Account_expired") private boolean isAccountNonExpired;
	 * 
	 * @Column(name="Credentials_expired") private boolean isCredentialsNonExpired;
	 * 
	 * @Column(name="Account_Locked") private boolean isAccountNonLocked;
	 * 
	 * @Column(name = "enabled") private boolean isEnabled;
	 */

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password +  "]";
	}

}
