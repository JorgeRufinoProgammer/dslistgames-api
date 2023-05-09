package com.devsuperior.dslistgamesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslistgamesapi.dto.GameMinDto;
import com.devsuperior.dslistgamesapi.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDto> findAll(){
//		Transforma a lista de Games em um lista de GameMinDto
		List<GameMinDto> dto = gameRepository.findAll().stream()
				.map(game -> new GameMinDto(game))
				.toList();
		
		return dto;
	}

}
