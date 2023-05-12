package com.devsuperior.dslistgamesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslistgamesapi.dto.GameListDto;
import com.devsuperior.dslistgamesapi.dto.GameMinDto;
import com.devsuperior.dslistgamesapi.services.GameListService;
import com.devsuperior.dslistgamesapi.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;	 
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDto> findAll(){
		return gameListService.findAll();
	}

	@GetMapping("/{id}")
	public GameListDto findById(@PathVariable Long id){
		return gameListService.findById(id);
	}
		
	@GetMapping("/{listId}/games")
	public List<GameMinDto> findByList(@PathVariable Long listId){
		return gameService.findByList(listId);
	}
	
	@PostMapping("/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDto replacementDto){
		
		gameListService.move(listId, replacementDto.getSourceIndex(), replacementDto.getDestinationIndex());		
	}
}
