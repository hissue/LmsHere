package com.homework.lms.role.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.homework.lms.role.model.Role;

@Repository
@Mapper
public interface IRoleRepository {
	Role getRole(int roleId);
}
