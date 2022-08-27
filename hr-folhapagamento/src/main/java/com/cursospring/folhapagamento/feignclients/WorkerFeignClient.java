package com.cursospring.folhapagamento.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cursospring.folhapagamento.entities.Worker;

@Component
@FeignClient(name="hr-worker", path="/workers")
public interface WorkerFeignClient {

	@GetMapping("/{id}")
	ResponseEntity<Worker> buscarPorId(@PathVariable Long id);
	
}
