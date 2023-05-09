package com.devsuperior.dslistgamesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslistgamesapi.dto.GameMinDto;
import com.devsuperior.dslistgamesapi.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;	 
	
	@GetMapping
	public List<GameMinDto> findAll(){
		return gameService.findAll();
	}

}
