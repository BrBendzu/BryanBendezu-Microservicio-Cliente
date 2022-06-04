package com.example.microserviciocliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microserviciocliente.modelo.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {

}
