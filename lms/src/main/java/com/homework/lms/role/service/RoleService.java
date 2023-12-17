package com.homework.lms.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.lms.role.model.Role;
import com.homework.lms.role.repository.IRoleRepository;

@Service
public class RoleService implements IRoleService{
	
	@Autowired
	IRoleRepository roleRepository;

	@Override
	public Role getRole(int roleId) {
		return roleRepository.getRole(roleId);
	}

}
