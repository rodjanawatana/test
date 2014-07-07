package jp.co.fitec.lesson.yoneyama.web.bookstore.controller;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import jp.co.fitec.lesson.yoneyama.web.bookstore.dao.UserAccountDAO;
import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.UserAccount;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class RegisterFormBean {
	
	@NotNull 
	@Email(message="The E-mail is not a well-formed")
	private String email;
	
	@NotNull 
	@Length(min=1, max=15, message="Name length must be between 1 and 15") 
	@Pattern(regexp="\\w+", message="The Name is not a well-formed")
	private String name;
	
	@NotNull
	@Length(min=6, max=10, message="Password length must be between 6 and 10")
	private String password1;
	private String password2;
	
	private Boolean confirmed;
	private String readOnly;
	private String buttonCaption;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@AssertTrue(message="The e-mail was already registered.")
	public boolean isAlreadyExist() {
		UserAccount userAccount = new UserAccountDAO().findBy(email);
		if(userAccount == null) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	@AssertTrue(message="Passwords doesn't match")
	public boolean isMatchPassword() {
		return password1.equals(password2);
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getButtonCaption() {
		return buttonCaption;
	}

	public void setButtonCaption(String buttonCaption) {
		this.buttonCaption = buttonCaption;
	}
}
