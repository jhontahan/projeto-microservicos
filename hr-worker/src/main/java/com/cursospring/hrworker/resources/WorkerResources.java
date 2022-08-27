package com.cursospring.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);
	
	@Autowired
	private WokerRepository repository;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> buscarPorId(@PathVariable Long id){
		
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		
		Optional<Worker> worker = repository.findById(id);
		
//		if (!worker.isPresent()) {
//			return ResponseEntity.badRequest().body("Usuario não encontrado para o id informado.");
//		}
		
		return ResponseEntity.ok(worker.get());
		
	}
	
}
