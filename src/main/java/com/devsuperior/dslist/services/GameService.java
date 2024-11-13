package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service	// registra essa classe como sendo um componente Service do sistema
public class GameService {
	
	@Autowired		// puxando uma instância do GameRepository (injetando uma dependência de GameRepository)
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)		// boa prática colocar sempre essa annotation para qualquer método do service envolvendo resgate de dados do repository
	public List<GameMinDTO> findAll() {
		List<Game> games = gameRepository.findAll();
		return games.stream().map(g -> new GameMinDTO(g)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();	// o método get é necessário p/ resgatar um objeto
														// (não um tipo Optional<Game>, como é o retorno de findById)
		return new GameDTO(game);
	}
}
