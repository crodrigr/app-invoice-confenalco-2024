package com.confenalco.app_invoice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.confenalco.app_invoice.repositories.entities.Producto;


public interface ProductoRepository extends CrudRepository<Producto,Long>{

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE ?1")
    public List<Producto> findByNombre(String term);

    public List<Producto> findByNombreLike(String term);

    public List<Producto> findByNombreContainingIgnoreCase(String term);
                          
    public List<Producto> findByNombreStartingWithIgnoreCase(String term);

    public List<Producto> findByPrecioBetween(Double precioStart, Double precionEnd);




                                      
}
