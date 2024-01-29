package com.ricardo.springboot.form.services;

import java.util.List;

import com.ricardo.springboot.form.models.entity.Role;

public interface RoleService {

	public List<Role> listar();
	public Role porId(Integer id);
}
