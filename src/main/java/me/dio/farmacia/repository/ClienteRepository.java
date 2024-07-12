package me.dio.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.farmacia.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
