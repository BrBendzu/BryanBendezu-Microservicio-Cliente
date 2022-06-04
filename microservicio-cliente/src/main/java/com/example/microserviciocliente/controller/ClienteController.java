package com.example.microserviciocliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviciocliente.modelo.Cliente;
import com.example.microserviciocliente.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	
	@GetMapping(path = "/listar")
	public @ResponseBody List<Cliente>listar(){
		return service.listar();
	}
	
	@GetMapping(path="buscar/{id}")
	public ResponseEntity<Cliente>EncontrarCliente(@PathVariable("id")Integer id){
		Cliente cliente = service.EncontrarPorid(id);
		 if(cliente!=null){
	            return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	        }

	        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="/agregar")
	public ResponseEntity<Void>agregar(@RequestBody Cliente cliente){
		service.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable("id") Integer id,@RequestBody Cliente cliente){
       Cliente ci = service.EncontrarPorid(id);
        if(ci!=null){
            service.editarCliente(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);


    }
	
	@DeleteMapping(path="/eliminar/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("id")Integer id){
        Cliente cliente = service.EncontrarPorid(id);
        if(cliente!=null){
            service.eliminarCliente(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
	
	
}
