package com.cursospring.folhapagamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.folhapagamento.entities.Pagamento;
import com.cursospring.folhapagamento.entities.Worker;
import com.cursospring.folhapagamento.feignclients.WorkerFeignClient;

@Service
public class PagamentoService {
	
//	@Value("${hr-worker.host}")
//	private String workerHost;
	
//	@Autowired
//	private RestTemplate restTemplete;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Pagamento getPagamento(Long idWorker, int dias) {
		
//		Map<String, String> uriVaiables = new HashMap<>();
//		uriVaiables.put("id", ""+idWorker);
//		
//		Worker worker = restTemplete.getForObject(workerHost + "/workers/{id}", 
//												 Worker.class,
//												 uriVaiables);
//		return new Pagamento(worker.getNome(), worker.getQuantidadeDia(), dias);
		
		Worker worker = workerFeignClient.buscarPorId(idWorker).getBody();
		
		return new Pagamento(worker.getNome(), worker.getQuantidadeDia(), dias);
	}
}
