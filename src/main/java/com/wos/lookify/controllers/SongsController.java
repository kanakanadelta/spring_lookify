package com.wos.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wos.lookify.services.SongService;


@Controller
@RequestMapping("/")
public class SongsController {
	// dependency injection
	public final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping("")
	public String landing() {
		return "index.jsp";
	}
	
	// RESTFUL ROUTES SET UP //
	
	//1. INDEX - Display all songs
	
}
