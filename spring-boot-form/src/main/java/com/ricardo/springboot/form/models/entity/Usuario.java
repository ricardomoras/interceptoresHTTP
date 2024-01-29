package com.ricardo.springboot.form.models.entity;

import java.util.Date;
//import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

import com.ricardo.springboot.form.validations.IdentificadorRegex;
import com.ricardo.springboot.form.validations.Requerido;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {

	// @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;

	// @NotEmpty(message = "El nombre no puede ser vacio")
	private String nombre;
	// @NotEmpty
	@Requerido
	private String apellido;

	@NotEmpty(message = "El username no puede ser vacio")
	@Size(min = 3, max = 10)
	private String username;
	@NotBlank
	private String password;
	@NotEmpty
	@Email(message = "Esta mal email")
	private String email;

	@NotNull
	@Min(3)
	@Max(5000)
	private Integer cuenta;

	@Past(message = "Debe ser una fecha anterior")
	@NotNull
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	private Pais pais;

	@NotEmpty
	private List<Role> roles;

	private Boolean habilitar;

	@NotEmpty
	private String genero;

	private String valorSecreto;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@NotNull
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getValorSecreto() {
		return valorSecreto;
	}

	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}

}
