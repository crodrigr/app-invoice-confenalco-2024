package com.confenalco.app_invoice.repositories.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "el nombre no pue estar vacio")
    @Size(min=3,max=60,message="el tamaño debe estar entre 3 y 60 caracteres")
    @Column(nullable = false,name="nombres") 
    private String nombre;

    @NotEmpty(message = "el apellido no pue estar vacio")
    @Size(min=3,max=60,message="el tamaño debe estar entre 3 y 60 caracteres")
    @Column(nullable = false,name="apellidos")
    private String apellido;

    @Column(nullable = false,unique = true)
    @Email(message="el email con cumple con el formato. Debe tener la @ y dominio .com")
    private String email;

    @NotEmpty(message = "la dirección no pue estar vacia")
    @Column(nullable = false)
    private String direccion;

    @NotEmpty(message = "el celular no pue estar vacia")
    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private Date   fechaNacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Region region;

    @JsonIgnoreProperties(value={"cliente","hibernateLazyInitializer","handler"},allowSetters=true)
    @OneToMany(mappedBy = "cliente", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Factura> facturas;   
    

}
