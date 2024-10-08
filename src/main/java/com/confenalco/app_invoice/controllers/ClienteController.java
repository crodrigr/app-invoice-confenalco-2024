package com.confenalco.app_invoice.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confenalco.app_invoice.repositories.entities.Cliente;
import com.confenalco.app_invoice.repositories.entities.Region;
import com.confenalco.app_invoice.services.ClienteService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> getClientes(){
        return clienteService.findAll();        
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteService.findById(id);

    }

    @PutMapping("update/{id}")
    public String putMethodName(@PathVariable String id,@RequestBody Cliente cliente) {          
        return "hola";
    }
    

    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> saveCliente(@Valid @RequestBody Cliente cliente, BindingResult result){
   
        Cliente clienteNew=null;

        Map<String,Object> response=new HashMap<>();

        if(result.hasErrors()){
           List<String> errors=result.getFieldErrors()
                               .stream()
                               .map(err-> "El campo: "+ err.getField()+ " : "+err.getDefaultMessage())
                               .collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }

        try{
           
          clienteNew=clienteService.save(cliente);

        }catch(DataAccessException e){
             response.put("mensaje","Error al realizar el inser en la base de datos");
             response.put("error",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
             return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);

        }
          response.put("mensaje","El cliente ha sido creado con éxito");
          response.put("cliente",clienteNew);
          return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id ){
        
         Cliente clientUpdate=null;

         Map<String,Object> response=new HashMap<>();

         if(result.hasErrors()){
            List<String> errors=result.getFieldErrors()
                                .stream()
                                .map(err -> "El campo: "+ err.getField()+" "+err.getDefaultMessage())
                                .collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
         }

         try{

            clientUpdate=clienteService.update(cliente,id);        

         }catch(DataAccessException e){
            response.put("mensaje","No se puedo actulizar el cliente por un error en la base de datos");
            response.put("error",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
         }
        
            response.put("mensaje","El cliente se actualizó correctamente");
            response.put("cliente",clientUpdate);
         
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
        
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.delete(id);
    }

    @GetMapping("/regiones")
    public List<Region> findAllRegiones() {
        return clienteService.findAllRegiones();
    }
    


}
