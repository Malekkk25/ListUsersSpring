package com.nadhem.users.service;
import java.util.List; 
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malek.vols.dto.VolDTO;
import com.malek.vols.entities.Vol;
import com.nadhem.users.dto.UserDTO;
import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;
import com.nadhem.users.repos.RoleRepository;
import com.nadhem.users.repos.UserRepository;

@Transactional
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoleRepository roleRep;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDTO saveUser(UserDTO user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return convertEntityToDto(userRep.save(convertDtoToEntity(user)));
	}
	
	@Override
	public UserDTO getUser(Long id) {
		return convertEntityToDto(userRep.findById(id).get());
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
		return userRep.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	

	@Override
	public User convertDtoToEntity(UserDTO userDto) {
		User user = new  User();
		user=modelMapper.map(userDto, User.class);
		return user;
	}
	
	@Override
	public UserDTO convertEntityToDto(User user) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDTO userDTO =modelMapper.map(user, UserDTO.class);
		return userDTO;

	}
	
	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}

	
	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User findUserByUsername(String username) {	
		return userRep.findByUsername(username);
	}



}
