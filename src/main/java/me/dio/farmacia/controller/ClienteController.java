package me.dio.farmacia.controller;


import me.dio.farmacia.model.Cliente;
import me.dio.farmacia.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
                //ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        var clienteNovo = clienteService.create(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteNovo.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteNovo);
    }
}
