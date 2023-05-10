package com.devsuperior.dslistgamesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistgamesapi.dto.GameDto;
import com.devsuperior.dslistgamesapi.dto.GameMinDto;
import com.devsuperior.dslistgamesapi.entities.Game;
import com.devsuperior.dslistgamesapi.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

//	Assegura que será somente operaçoes de leitura, sem escrita, tornando a operação mais rapida
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll(){
		List<GameMinDto> dto = gameRepository.findAll().stream()
				.map(game -> new GameMinDto(game))
				.toList();
		
		return dto;
	}

	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game result = gameRepository.findById(id).get();
		
		return new GameDto(result);
	}
}
