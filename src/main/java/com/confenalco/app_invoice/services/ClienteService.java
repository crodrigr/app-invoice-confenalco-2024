package com.confenalco.app_invoice.services;

import java.util.List;

import com.confenalco.app_invoice.repositories.entities.Cliente;
import com.confenalco.app_invoice.repositories.entities.Region;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente, Long id);

    void delete(Long id);

    List<Region> findAllRegiones();

    

}
