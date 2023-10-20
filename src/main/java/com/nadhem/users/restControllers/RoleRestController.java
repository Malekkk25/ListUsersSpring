package com.nadhem.users.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.users.entities.Role;
import com.nadhem.users.repos.RoleRepository;

@RestController
@RequestMapping("/api/role")
@CrossOrigin("http://localhost:4200/")
public class RoleRestController {
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Role getRoleById(@PathVariable("id") Long id) {
		return roleRepository.findById(id).get();
	}
	
	

}
