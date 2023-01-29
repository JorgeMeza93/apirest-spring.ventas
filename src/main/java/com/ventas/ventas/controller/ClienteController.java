package com.ventas.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.ventas.model.Cliente;
import com.ventas.ventas.service.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	@GetMapping
	public ResponseEntity<List<Cliente>>findAll(){
		return ResponseEntity.ok(clienteService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id){
		return clienteService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
		return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
		return clienteService.findById(cliente.getIdCliente())
				.map( cli -> ResponseEntity.ok(clienteService.update(cliente)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	public ResponseEntity<Cliente> delete(Integer id){
		return clienteService.findById(id)
				.map( cli -> clienteService.delete(id) )
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
}
