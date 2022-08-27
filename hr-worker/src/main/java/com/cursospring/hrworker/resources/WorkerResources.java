package com.cursospring.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.hrworker.entities.Worker;
import com.cursospring.hrworker.repositories.WokerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResources {

	@Autowired
	private WokerRepository repository;
	
	@GetMapping("/")
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id){
		
		Optional<Worker> worker = repository.findById(id);
		
		if (!worker.isPresent()) {
			return ResponseEntity.badRequest().body("Usuario não encontrado para o id informado.");
		}
		
		return ResponseEntity.ok(worker.get());
		
	}
	
}
