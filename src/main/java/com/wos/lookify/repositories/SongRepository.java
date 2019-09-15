package com.wos.lookify.repositories;

import java.util.List;

import com.wos.lookify.models.Song;

public interface SongRepository {
	// method to retrieve all songs from the database
	List<Song> findAll();
	// method to find a song by title
	List<Song> findByTitleContaining(String search);
	
	
	
}
