package com.ricardo.springboot.form.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ricardo.springboot.form.editors.NombreMayusculaEditor;
import com.ricardo.springboot.form.editors.PaisPropertyEditor;
import com.ricardo.springboot.form.editors.RolesEditor;
import com.ricardo.springboot.form.models.entity.Pais;
import com.ricardo.springboot.form.models.entity.Role;
import com.ricardo.springboot.form.models.entity.Usuario;
import com.ricardo.springboot.form.services.PaisServices;
import com.ricardo.springboot.form.services.RoleService;
import com.ricardo.springboot.form.validations.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {
	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private PaisServices paisService;

	@Autowired
	private PaisPropertyEditor paisEditor;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RolesEditor roleEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellidos", new NombreMayusculaEditor());

		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);
	}

	@ModelAttribute("genero")
	public List<String> genero() {
		return Arrays.asList("Hombre", "Mujer", "Prefiero no mencionarlo");
	}

	@ModelAttribute("listaRoles")
	public List<Role> listaRoles() {
		return this.roleService.listar();
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
	}

	@ModelAttribute("listadoRolesString")
	public List<String> listadoRolesString() {
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}

	@ModelAttribute("listadoRolesMap")
	public Map<String, String> listadoRolesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ROLE_ADMIN", "Admistrador");
		paises.put("ROLE_USER", "Usuario");
		paises.put("ROLE_MODERATOR", "Moderador");
		return paises;
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Colombia", "Peru", "Venezuela");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "España");
		paises.put("MX", "Mexico");
		paises.put("CH", "Chile");
		paises.put("AG", "Argentina");
		paises.put("CO", "Colombia");
		paises.put("PE", "Peru");
		paises.put("VE", "Venezuela");
		return paises;
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Ricardi");
		usuario.setApellido("Mora");
		usuario.setIdentificador("11.456.789-K");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algun valor secreto......");
		usuario.setPais(new Pais(2, "MX", "Mexico"));
		usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		// validador.validate(usuario, result);

		if (result.hasErrors()) {

			model.addAttribute("titulo", "Resulado form");
			/*
			 * Map<String, String> errores = new HashMap<>();
			 * result.getFieldErrors().forEach(err -> { errores.put(err.getField(),
			 * "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()
			 * )); }); model.addAttribute("error", errores);
			 */
			return "form";
		}

		return "redirect:/ver";
	}

	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model,
			SessionStatus status) {

		if (usuario == null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Resulado form");

		status.setComplete();
		return "resultado";
	}

}
