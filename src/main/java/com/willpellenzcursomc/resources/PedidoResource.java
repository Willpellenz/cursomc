package com.willpellenzcursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.willpellenzcursomc.domain.Pedido;
import com.willpellenzcursomc.services.PedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

    @RestController
    @RequestMapping(value = "/pedidos")
    public class PedidoResource {
    
    @Autowired
    private PedidoService service;
    
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find(@PathVariable Integer id) {
    		Pedido obj = null;
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