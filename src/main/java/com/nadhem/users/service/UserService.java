package com.nadhem.users.service;

import java.util.List;
import com.nadhem.users.dto.UserDTO;
import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;

public interface UserService {
	UserDTO saveUser(UserDTO user);
	UserDTO getUser(Long id);
	List<UserDTO> getAllUsers();
	
	UserDTO convertEntityToDto (User user);
	User convertDtoToEntity(UserDTO userDto);
	
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	
}
