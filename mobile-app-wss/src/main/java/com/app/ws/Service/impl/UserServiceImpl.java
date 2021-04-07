package com.app.ws.Service.impl;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ws.Service.UserService;
import com.app.ws.io.entity.UserEntity;
import com.app.ws.io.repositories.UserRepository;
import com.app.ws.shared.dto.UserDto;
//import com.appsdeveloperblog.app.ws.exceptions.UserServiceException;
//import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;

@Service
public class UserServiceImpl implements UserService {

	
	private static final String ErrorMessages = null;

	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {
	
		UserEntity storedUserDetailss=userRepository.findByEmail(user.getEmail());
		
//		if((storedUserDetailss)!= null) throw new RuntimeException ("record already exist");
		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
//		userEntity.setEncryptedpassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setEncryptedpassword(user.getPassword());
		if(storedUserDetailss != null) {
		userEntity.setUserId(storedUserDetailss.getUserId());
		userEntity.setId(storedUserDetailss.getId());
		}else {
			long count = userRepository.count();
			String userId="mobileapp-" + (count+1);
			userEntity.setUserId(userId);
		}
		
		UserEntity storedUserDetails=userRepository.save(userEntity);
		
		UserDto returnValue= new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}
	@Override
	public UserDto getUser(String email) {
		 
		UserEntity userEntity=userRepository.findByEmail(email);
//		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDto returnValue= new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue; 
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		
//		UserEntity userEntity=userRepository.findByEmail(email);
//		
//		if(userEntity == null) throw new UsernameNotFoundException(email);
//		
//		return new User(userEntity.getEmail(), userEntity.getEncryptedpassword(), (Collection<? extends GrantedAuthority>) new ArrayList<>());
//	}
	@Override
	public UserDto getUserByUserId(String userId) {
		 UserDto returnValue= new UserDto();
		 UserEntity userEntity=userRepository.findByUserId(userId);
		 
//		 if(userEntity == null) throw new UsernameNotFoundException(userId);
		 
		 BeanUtils.copyProperties(userEntity,returnValue);
		 return returnValue;
	}
	@Override
	public UserDto updateUser(String uderId,UserDto user) {
		
		UserDto returnValue = new UserDto();

		String userId = null;
		UserEntity userEntity = userRepository.findByUserId(userId);

		//if (userEntity == null)
			//throw new Exception(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());

		UserEntity updatedUserDetails = userRepository.save(userEntity);
		//returnValue = new Mapper().map(updatedUserDetails, UserDto.class);

		return returnValue;
	}

	
	}


