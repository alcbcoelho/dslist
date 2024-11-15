package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> list = gameListRepository.findAll();
		return list.stream().map(l -> new GameListDTO(l)).toList();
	}
	
	@Transactional
	public void moveItem(Long listId, int originIndex, int destinationIndex) {
		List <GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(originIndex);
		list.add(destinationIndex, obj);
		
		int min = originIndex < destinationIndex ? originIndex : destinationIndex;
		int max = originIndex > destinationIndex ? originIndex : destinationIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
