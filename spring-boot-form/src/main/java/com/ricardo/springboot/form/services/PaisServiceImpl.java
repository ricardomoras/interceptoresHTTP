package com.ricardo.springboot.form.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ricardo.springboot.form.models.entity.Pais;

@Service
public class PaisServiceImpl implements PaisServices {

	private List<Pais> lista;
	
	public PaisServiceImpl() {
		this.lista = Arrays.asList(
				new Pais(1, "ES", "España"),
				new Pais(2, "MX","Mexico"),
				new Pais(3, "CH","Chile"),
				new Pais(4, "AR","Argentina"), 
				new Pais(5, "CO","Colombia"),
				new Pais(6, "PE","Peru"),
				new Pais(7, "VE","Venezuela"));
		}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais porId(Integer id) {
		Pais resultado = null;
		for(Pais pais: this.lista) {
			if(id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
