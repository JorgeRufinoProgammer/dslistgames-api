package com.devsuperior.dslistgamesapi.dto;

import com.devsuperior.dslistgamesapi.entities.GameList;

public class GameListDto {

	private Long id;	
	private String name;
	
	public GameListDto() {
	}

	public GameListDto(GameList list) {
		id = list.getId();
		name = list.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
