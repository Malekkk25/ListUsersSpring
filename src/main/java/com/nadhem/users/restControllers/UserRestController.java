package com.nadhem.users.restControllers;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.malek.vols.dto.VolDTO;
import com.nadhem.users.dto.UserDTO;
import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;
import com.nadhem.users.repos.UserRepository;
import com.nadhem.users.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200/")
public class UserRestController {
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<UserDTO> getAllUser() {
		return userService.getAllUsers();
	 }
	
	
	@RequestMapping(value="/getbyid/{idUser}",method=RequestMethod.GET)
	public UserDTO getUserById(@PathVariable("idUser") Long idUser) {
		return userService.getUser(idUser);
	}
	
	@RequestMapping(value="/{idUser}/roles",method=RequestMethod.GET)
	public List<Role> getUserRoles(@PathVariable("idUser") Long idUser) {
		UserDTO user =userService.getUser(idUser);
		List<Role> roles =user.getRoles();
		return roles;
	
	}
	
	
	
}
