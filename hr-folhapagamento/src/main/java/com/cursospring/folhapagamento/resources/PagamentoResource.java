package com.cursospring.folhapagamento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.folhapagamento.entities.Pagamento;
import com.cursospring.folhapagamento.services.PagamentoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

	@Autowired
	private PagamentoService service;
	
	@HystrixCommand(fallbackMethod = "getPagamentoAlternativo")
	@GetMapping("/{idWorker}/dias/{dias}")
	public ResponseEntity getPagamento(@PathVariable Long idWorker, @PathVariable Integer dias) {
		
		Pagamento pagamento = service.getPagamento(idWorker, dias);
		
		return ResponseEntity.ok(pagamento);
		
	}
	
	
	public ResponseEntity getPagamentoAlternativo(Long idWorker, Integer dias) {
		Pagamento pagamento = new Pagamento("jhonathan", 400.0, dias);
		
		return ResponseEntity.ok(pagamento);
	}
	
}
