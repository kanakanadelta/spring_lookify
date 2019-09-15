package com.wos.lookify.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wos.lookify.models.Song;
import com.wos.lookify.repositories.SongRepository;

@Service
public class SongService {
	// add the song repository as a dependency
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	// return all songs
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	// creates a new song row or updates an existing song info
	public Song createOrUpdateSong(Song song) {
		return songRepo.save(song);
	}
	
	// retrieve a song by Id
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	// search for a song by artist
	public List<Song> searchByArtist(String search) {
		return songRepo.findByArtistContaining(search);
	}
	
	// update song's info in the db
	public Song updateSong(
			Long id,
			String title,
			String artist,
			Integer rating
			) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			Song song = optionalSong.get();
			song.setTitle(title);
			song.setArtist(artist);
			song.setRating(rating);
			songRepo.save(song);
			return song;
		} else {
			return null;
		}
	}
	
	// delete a song from the db
	public Song deleteSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			Song song = optionalSong.get();
			songRepo.deleteById(id);
			return song;
		} else {
			return null;
		}
	}
	
	// SORT BY RATING
	
	class SortByRating implements Comparator<Song> {
		public int compare(Song a, Song b) {
			return b.getRating() - a.getRating();
		}
	}
	public List<Song> sortByRating(List<Song> songList) {
		Collections.sort(songList, new SortByRating());
		System.out.println(songList.toString());
		return songList;
	}
	// END SERVICE
}
