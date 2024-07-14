package me.dio.farmacia.service.impl;


import me.dio.farmacia.model.Cliente;
import me.dio.farmacia.repository.ClienteRepository;
import me.dio.farmacia.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cliente create(Cliente cliente) {

        if (cliente.getId() != null && clienteRepository.existsById(cliente.getId())) {
            throw new IllegalArgumentException("Usuário já existente!");
        }
        return clienteRepository.save(cliente);
    }
}
