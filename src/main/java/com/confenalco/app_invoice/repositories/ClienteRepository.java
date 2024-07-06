package com.confenalco.app_invoice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.confenalco.app_invoice.repositories.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Long>{

}
