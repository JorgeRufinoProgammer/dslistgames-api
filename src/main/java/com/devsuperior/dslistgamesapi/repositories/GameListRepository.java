package com.devsuperior.dslistgamesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslistgamesapi.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
