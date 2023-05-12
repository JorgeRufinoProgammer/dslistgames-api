package com.devsuperior.dslistgamesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslistgamesapi.dto.GameListDto;
import com.devsuperior.dslistgamesapi.entities.GameList;
import com.devsuperior.dslistgamesapi.projections.GameMinProjection;
import com.devsuperior.dslistgamesapi.repositories.GameListRepository;
import com.devsuperior.dslistgamesapi.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;

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
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
//		Se o index de origem for menor que o index de destino, o menor é a origem, se não é o destino
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		
//		O contrario
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min ; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
