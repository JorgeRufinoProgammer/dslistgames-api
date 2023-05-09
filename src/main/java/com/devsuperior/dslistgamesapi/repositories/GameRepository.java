package com.devsuperior.dslistgamesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslistgamesapi.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
