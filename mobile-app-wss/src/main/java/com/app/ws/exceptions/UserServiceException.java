package com.app.ws.exceptions;

public class UserServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UserServiceException(String name)
	{
		super(name);
	}

}
