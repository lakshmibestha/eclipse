package com.app.ws.ui.model.response;

public class UserRest {

	private String UserId;
	private String firstName;
	private String lastName;
	private String email;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		this.UserId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRest [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
