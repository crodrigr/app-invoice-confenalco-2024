package com.confenalco.app_invoice.repositories.entities;

import java.util.Date;
import java.util.List;

import org.hibernate.engine.profile.Fetch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name="nombres") 
    private String nombre;
    @Column(nullable = false,name="apellidos")
    private String apellido;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private Date   fechaNacimiento;
    @OneToOne()
    @JoinColumn(name="region_id")
    private Region region;
    @OneToMany(mappedBy = "cliente", fetch=FetchType.LAZY)
    private List<Factura> facturas;   
    

}
