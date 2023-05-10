package com.devsuperior.dslistgamesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistgamesapi.dto.GameListDto;
import com.devsuperior.dslistgamesapi.entities.GameList;
import com.devsuperior.dslistgamesapi.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;

//	Assegura que será somente operaçoes de leitura, sem escrita, tornando a operação mais rapida
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		List<GameListDto> dto = gameListRepository.findAll().stream()
				.map(gameList -> new GameListDto(gameList))
				.toList();
		
		return dto;
	}

	@Transactional(readOnly = true)
	public GameListDto findById(Long id) {
		GameList result = gameListRepository.findById(id).get();
		
		return new GameListDto(result);
	}
}
