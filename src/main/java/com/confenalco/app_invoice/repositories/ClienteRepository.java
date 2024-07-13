package com.confenalco.app_invoice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.confenalco.app_invoice.repositories.entities.Cliente;
import com.confenalco.app_invoice.repositories.entities.Region;

public interface ClienteRepository extends CrudRepository<Cliente,Long>{

    @Query("from Region")
    public List<Region> findAllRegiones();

}
