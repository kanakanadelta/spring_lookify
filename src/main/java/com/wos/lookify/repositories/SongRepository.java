package com.wos.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wos.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	// method to retrieve all songs from the database
	List<Song> findAll();
	// method to find a song by artist
	List<Song> findByArtistContaining(String search);
	
	// method to create OR update a song
	void save(Optional<Song> optionalSong);
	// method to delete a song by id
	void deleteById(Long id);
	
	
}
