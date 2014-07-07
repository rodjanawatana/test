package jp.co.fitec.lesson.yoneyama.web.bookstore.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class UserAccount implements Serializable {

	private static final long serialVersionUID = -2187862651926614152L;

	@Id
	private String email;
	
	private String name;
	
	private String password;
	
	public UserAccount() {}

	public UserAccount(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAccount [email=" + email + ", name=" + name + ", password="
				+ password + "]";
	}

}
