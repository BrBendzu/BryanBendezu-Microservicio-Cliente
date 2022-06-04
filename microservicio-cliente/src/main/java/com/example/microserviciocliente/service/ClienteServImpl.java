package com.example.microserviciocliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microserviciocliente.modelo.Cliente;
import com.example.microserviciocliente.repository.ClienteRespository;

@Service
public class ClienteServImpl implements ClienteService{
	
	@Autowired
	private ClienteRespository repository;

	@Override
	public List<Cliente> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		repository.save(cliente);
		
	}

	@Override
	public void editarCliente(Cliente cliente) {
		repository.saveAndFlush(cliente);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Cliente EncontrarPorid(Integer id) {
		Cliente cliente = repository.findById(id).orElse(null);
		return cliente;
	}

}
