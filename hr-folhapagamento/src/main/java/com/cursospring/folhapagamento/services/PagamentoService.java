package com.cursospring.folhapagamento.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursospring.folhapagamento.entities.Pagamento;
import com.cursospring.folhapagamento.entities.Worker;

@Service
public class PagamentoService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplete;

	public Pagamento getPagamento(Long idWorker, int dias) {
		
		Map<String, String> uriVaiables = new HashMap<>();
		uriVaiables.put("id", ""+idWorker);
		
		Worker worker = restTemplete.getForObject(workerHost + "/workers/{id}", 
												 Worker.class,
												 uriVaiables);
		
		return new Pagamento(worker.getNome(), worker.getQuantidadeDia(), dias);
	}
}
