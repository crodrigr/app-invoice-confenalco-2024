package com.confenalco.app_invoice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confenalco.app_invoice.repositories.entities.Cliente;
import com.confenalco.app_invoice.repositories.entities.Region;
import com.confenalco.app_invoice.services.ClienteService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> getClientes(){
        return clienteService.findAll();        
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteService.findById(id);

    }

    @PostMapping("/")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);        
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@RequestBody Cliente cliente,@PathVariable Long id){
        return clienteService.update(cliente,id);        
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.delete(id);
    }

    @GetMapping("/regiones")
    public List<Region> findAllRegiones() {
        return clienteService.findAllRegiones();
    }
    


}
