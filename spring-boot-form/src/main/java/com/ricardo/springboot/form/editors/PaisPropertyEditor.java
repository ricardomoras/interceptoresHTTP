package com.ricardo.springboot.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ricardo.springboot.form.services.PaisServices;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private PaisServices service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		if (idString != null && idString.length() > 0) {
			try {
				Integer id = Integer.parseInt(idString);
				this.setValue(service.porId(id));
			} catch (NumberFormatException e) {
				setValue(null);
			}
		} else {
			setValue(null);
		}
	}
}
