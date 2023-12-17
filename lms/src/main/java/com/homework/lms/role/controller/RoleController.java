package com.homework.lms.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.role.model.Role;
import com.homework.lms.role.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping("")
	public void test() {
		System.out.println("RoleController");
	}
	
	@GetMapping("/{roleId}")
	public Role getRole(@PathVariable int roleId) {
		return roleService.getRole(roleId);
	}
}
