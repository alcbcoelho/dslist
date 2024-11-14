package com.devsuperior.dslist.projections;

/*

 Projections são interfaces que queries personalizadas como a feita no GameRepository retornam.
 
 Devemos incluir nela getters para cada atributo retornado pela query.
 
 */

public interface GameMinProjection {
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
