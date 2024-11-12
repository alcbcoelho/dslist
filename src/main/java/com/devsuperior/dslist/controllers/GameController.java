package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController		// registra essa classe como sendo um componente RestController do sistema
@RequestMapping(value = "/games")	// mapeia o recurso retornado por esse controller ao endpoint "/games" da API
public class GameController {
	@Autowired
	private GameService gameService;
	
	@GetMapping		// mapeando operação ao método HTTP GET
	public List<GameMinDTO> findAll() {
		return gameService.findAll();
	}
}
