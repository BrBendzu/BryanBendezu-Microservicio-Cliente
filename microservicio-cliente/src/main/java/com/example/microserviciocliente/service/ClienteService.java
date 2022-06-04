package com.example.microserviciocliente.service;

import java.util.List;

import com.example.microserviciocliente.modelo.Cliente;

public interface ClienteService {

	public List<Cliente>listar();
	public void guardarCliente(Cliente cliente);
	public void editarCliente(Cliente cliente);
	public void eliminarCliente(Integer id);
	public Cliente EncontrarPorid(Integer id);
}
