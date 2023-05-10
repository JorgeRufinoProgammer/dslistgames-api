package com.devsuperior.dslistgamesapi.projections;

//Esta classe tem que ter metodos Get para cada dado que a consulta retornar
public interface GameMinProjection {

	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
