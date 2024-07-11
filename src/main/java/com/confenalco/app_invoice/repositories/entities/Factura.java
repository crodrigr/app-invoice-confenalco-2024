package com.confenalco.app_invoice.repositories.entities;

import java.sql.Date;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="facturas")
@Data@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="create_at")
    private Date createAt;
    private String descripcion;
    private String observacion;

    @JsonIgnoreProperties(value={"facturas","hibernateLazyInitializer","handler"},allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> items;

   
    public Double getTotal(){
        var total=0.0;
        for(ItemFactura item:items){
            total+=item.getImporte();
        }
        return total;
    }
    

}
