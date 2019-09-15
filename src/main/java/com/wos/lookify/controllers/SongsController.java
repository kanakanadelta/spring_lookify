package com.wos.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wos.lookify.models.Song;
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
	@GetMapping("/dashboard")
	public String index(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	//2. NEW - Show form to make a new song
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	//3. CREATE - Add new item the database and redirect
	@PostMapping("/songs")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			songService.createOrUpdateSong(song);
			return "redirect:/dashboard";
		}
	}
	
	
	
	// ADDITIONAL FUNCTIONALITIES:
	@GetMapping("/search/topTen")
	public String topTen(Model model, @ModelAttribute("song") Song song) {
		List<Song> sortedSongs = songService.sortByRating(songService.allSongs());
		model.addAttribute("sortedSongs", sortedSongs);
//		List<Song> songs = songService.allSongs();
//		model.addAttribute("songs", songs);
		return "topTen.jsp";
	}
	
}
