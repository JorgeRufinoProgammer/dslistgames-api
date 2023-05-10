package com.devsuperior.dslistgamesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslistgamesapi.dto.GameDto;
import com.devsuperior.dslistgamesapi.dto.GameListDto;
import com.devsuperior.dslistgamesapi.dto.GameMinDto;
import com.devsuperior.dslistgamesapi.entities.GameList;
import com.devsuperior.dslistgamesapi.services.GameListService;
import com.devsuperior.dslistgamesapi.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;	 
	
	@GetMapping
	public List<GameListDto> findAll(){
		return gameListService.findAll();
	}

//	@GetMapping("/{id}")
//	public GameDto findById(@PathVariable Long id){
//		return gameListService.findById(id);
//	}
}
