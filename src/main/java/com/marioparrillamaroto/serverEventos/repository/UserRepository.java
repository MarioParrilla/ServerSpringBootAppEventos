package com.marioparrillamaroto.serverEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.marioparrillamaroto.serverEventos.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	
	
}
