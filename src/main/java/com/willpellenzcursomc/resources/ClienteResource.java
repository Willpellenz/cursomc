package com.willpellenzcursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.willpellenzcursomc.domain.Cliente;
import com.willpellenzcursomc.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

    @RestController
    @RequestMapping(value = "/clientes")
    public class ClienteResource {
    
    @Autowired
    private ClienteService service;
    
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find(@PathVariable Integer id) {
    		Cliente obj = null;
			try {
				obj = service.find(id);
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
    		return ResponseEntity.ok().body(obj);

   }
    
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST está funcionando!";
		
	}
}