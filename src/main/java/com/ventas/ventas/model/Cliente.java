package com.ventas.ventas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	@NotNull
	@NotBlank(message = "El campo nombre es obligatorio")
	@Size(max = 70, min = 3, message = "Longitud permitida es de entre 3 y 60 caracteres")
	@Column(name="nombres", nullable = false, length = 70)
	private String nombres;
	@NotNull
	@NotBlank(message = "El campo apellido es obligatorio")
	@Size(max = 100, min = 3, message = "Longitud permitida es de entre 3 y 100 caracteres")
	@Column(name="apellidos", nullable = false, length = 100)
	private String apellidos;
	@Size(max = 150, message = "La dirección no debe de superar los 150 caracteres")
	@Column(name="direccion", nullable = true, length = 150)
	private String direccion;
	@NotNull
	@NotBlank(message = "El campo teléfono es obligatorio")
	@Size(max = 12, min = 10, message = "El número teléfonico es de mínimo 10 digitos")
	@Column(name="telefono", nullable = false, length = 12)
	private String telefono;
	@NotNull
	@NotBlank(message = "El campo email es obligatorio")
	@Size(min = 10, max = 100, message = "El email no cumple con los tamaños requeridos")
	@Email(message = "El email proporcionado no es un formato válido")
	@Column(name="email", nullable = false, length = 100)
	private String email;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
