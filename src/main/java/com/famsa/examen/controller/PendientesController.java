package com.famsa.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.famsa.examen.model.Pendiente;
import com.famsa.examen.service.PendienteService;


@RestController
@CrossOrigin
@RequestMapping("/pendientes")
public class PendientesController {
	
	@Autowired
	PendienteService pendienteService;
	
	
	@GetMapping(value = "/all")
    public ResponseEntity<List<Pendiente>> getPendientes(){
		List<Pendiente> body = this.pendienteService.list();
		if (body.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
    	return new ResponseEntity<List<Pendiente>>(this.pendienteService.list(), HttpStatus.OK);
    }
	
	@PostMapping(value = "/save")
	public ResponseEntity<Long> savePendiente(@RequestBody Pendiente pendiente){
		if (pendiente == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
		}
		return new ResponseEntity<Long>(this.pendienteService.save(pendiente), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pendiente> getPendienteById(@PathVariable("id") long id){
		
		Pendiente pendiente = this.pendienteService.get(id);
		if (pendiente == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Pendiente>(pendiente, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updatePendiente(@PathVariable("id") long id, @RequestBody Pendiente pendiente){
		this.pendienteService.update(id, pendiente);
		return ResponseEntity.ok().body("Actualizado correctamente");
	}
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deletePendiente(@PathVariable("id") long id){
		 this.pendienteService.delete(id);
		 return ResponseEntity.ok().body("Eliminado correctamente");
	 }
}
