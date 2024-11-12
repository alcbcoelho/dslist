package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service	// registra essa classe como sendo um componente Service do sistema
public class GameService {
	
	@Autowired		// puxando uma instância do GameRepository (injetando uma dependência de GameRepository)
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(g -> new GameMinDTO(g)).toList();
	}
}
