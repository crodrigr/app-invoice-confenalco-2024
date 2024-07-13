package com.confenalco.app_invoice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.confenalco.app_invoice.repositories.ClienteRepository;
import com.confenalco.app_invoice.repositories.entities.Cliente;
import com.confenalco.app_invoice.repositories.entities.Region;
import com.confenalco.app_invoice.services.ClienteService;
import com.confenalco.app_invoice.utils.exceptions.ClienteNotFoundException;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    

    @Override
    @Transactional(readOnly=true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
        
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente update(Cliente cliente, Long id) {
        
        Optional<Cliente> clienteOptional=clienteRepository.findById(id);

        if(clienteOptional.isPresent()){
            Cliente clienteCurrent=clienteOptional.get();
            clienteCurrent.setNombre(cliente.getNombre());
            clienteCurrent.setApellido(cliente.getApellido());
            clienteCurrent.setEmail(cliente.getEmail());
            clienteCurrent.setDireccion(cliente.getDireccion());
            clienteCurrent.setCelular(cliente.getCelular());
            clienteCurrent.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteRepository.save(clienteCurrent);
            return clienteCurrent;        
        }else{
           throw new ClienteNotFoundException("Cliente con Id:"+id+" no existe");
        }       

    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Region> findAllRegiones() {
        return clienteRepository.findAllRegiones();
    }

}
