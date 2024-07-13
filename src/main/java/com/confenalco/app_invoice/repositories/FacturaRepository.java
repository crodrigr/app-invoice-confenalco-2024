package com.confenalco.app_invoice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.confenalco.app_invoice.repositories.entities.Factura;


public interface FacturaRepository extends CrudRepository<Factura,Long>{

}
