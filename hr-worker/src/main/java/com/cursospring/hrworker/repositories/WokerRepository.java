package com.cursospring.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.hrworker.entities.Worker;

public interface WokerRepository extends JpaRepository<Worker, Long>{
	
}
