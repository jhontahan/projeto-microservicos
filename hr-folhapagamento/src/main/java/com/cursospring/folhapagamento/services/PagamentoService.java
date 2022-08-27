package com.cursospring.folhapagamento.services;

import org.springframework.stereotype.Service;

import com.cursospring.folhapagamento.entities.Pagamento;

@Service
public class PagamentoService {

	public Pagamento getPagamento(Long idWorker, int dias) {
		return new Pagamento("Jhonathan", 200.0, dias);
	}
}
