package com.confenalco.app_invoice.services;

import java.util.List;

import com.confenalco.app_invoice.repositories.entities.Factura;
import com.confenalco.app_invoice.repositories.entities.Producto;

public interface FacturaServices {

    Factura findById(Long id);

    List<Factura> findAll();

    Factura save(Factura factura);

    void delete(Long id);

    List<Producto> findProductoByNombre(String term);

    
} 