package com.example.jpa_h2_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/addClient")
	public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(this.clienteRepository.save(cliente));
	}

	@GetMapping("/findAllClients")
	public ResponseEntity<List<Cliente>> findAllClients() {
		return ResponseEntity.ok(this.clienteRepository.findAll());
	}

	@GetMapping("/findClientById/{id}")
	public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
		return ResponseEntity.ok(this.clienteRepository.findById(idClient.intValue()).get());
	}

	@DeleteMapping("/removeClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCliente(@PathVariable("id") Long idClient){
		this.clienteRepository.deleteById(idClient.intValue());
    }

	@PutMapping("/updateClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteDb = this.clienteRepository.findById(id.intValue()).get();
		clienteDb.setNome(cliente.getNome());
		clienteDb.setIdade(cliente.getIdade());
		clienteDb.setEmail(cliente.getEmail());
		clienteDb.setEnderecos(cliente.getEnderecos());
        clienteDb.setTelefones(cliente.getTelefones());
        this.clienteRepository.save(clienteDb);
	}
}