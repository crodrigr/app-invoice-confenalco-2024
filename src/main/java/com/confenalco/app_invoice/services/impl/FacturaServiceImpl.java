package com.confenalco.app_invoice.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.confenalco.app_invoice.repositories.FacturaRepository;
import com.confenalco.app_invoice.repositories.ProductoRepository;
import com.confenalco.app_invoice.repositories.entities.Factura;
import com.confenalco.app_invoice.repositories.entities.Producto;
import com.confenalco.app_invoice.services.FacturaServices;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FacturaServiceImpl implements FacturaServices {

    
    private FacturaRepository facturaRepository;
    private ProductoRepository productoRepository;

        
    @Override
    @Transactional(readOnly=true)
    public Factura findById(Long id) {
       return facturaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Factura> findAll() {
        return (List<Factura>)facturaRepository.findAll();
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
       return facturaRepository.save(factura);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findProductoByNombre(String term) {
        return productoRepository.findByNombreContainingIgnoreCase(term);
    }

}
