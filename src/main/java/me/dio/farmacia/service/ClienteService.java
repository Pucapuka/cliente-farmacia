package me.dio.farmacia.service;

import me.dio.farmacia.model.Cliente;

public interface ClienteService {

    Cliente findById(Long id);

    Cliente create(Cliente cliente);

}
