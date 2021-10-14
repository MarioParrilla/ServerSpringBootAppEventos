package com.marioparrillamaroto.serverEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marioparrillamaroto.serverEventos.entity.Evento;

@Repository
public interface EventRepository extends JpaRepository<Evento, Long>{

	
	
}
