package com.ricardo.springboot.form.services;

import java.util.List;

import com.ricardo.springboot.form.models.entity.Pais;

public interface PaisServices {
	
	public List<Pais> listar();
	public Pais porId(Integer id);

}
