package com.web2.proyecto.converter;

import org.springframework.stereotype.Component;

import com.web2.proyecto.entities.User;
import com.web2.proyecto.model.UserModel;

@Component("userConverter")
public class UserConverter {
	
	public UserModel entityToModel(User user) {
		return new UserModel(user.getId(),user.getPassword(),user.getUsername(),user.getCreatedAt(),user.getUpdatedAt(),user.isEnabled(), user.getUserRoles());
	}

	public User modelToEntity(UserModel userModel) {
		return new User(userModel.getId(),userModel.getUsername(),userModel.getPassword(),userModel.isEnabled(),userModel.getCreatedAt(),userModel.getUpdatedAt(),userModel.getUserRoles());
	}
}
