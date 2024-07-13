package com.confenalco.app_invoice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confenalco.app_invoice.repositories.entities.Factura;
import com.confenalco.app_invoice.repositories.entities.Producto;
import com.confenalco.app_invoice.services.FacturaServices;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/facturas")
@AllArgsConstructor
public class FacturaController {
     
    private FacturaServices facturaServices;

    @GetMapping("/")
    public List<Factura> getAllFacturas(){
        return facturaServices.findAll();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return facturaServices.findById(id);
    }

    @PostMapping("/")
    public Factura guardarFactura(@RequestBody Factura factura) {
        return facturaServices.save(factura);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Long id){
        facturaServices.delete(id);
    }

    @GetMapping("/filtra-productos/{term}")
    public List<Producto> filtraProductos(@PathVariable String term) {
        return facturaServices.findProductoByNombre(term);
    }
    

    
    

}
