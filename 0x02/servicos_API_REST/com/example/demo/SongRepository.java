package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	
	
	private List<Song> list = new ArrayList<Song>();

	public SongRepository() {
		list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
		list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
	}
	
    public List<Song> getAllSongs() {
     return list;
    }

    public Song getSongById(Integer id) {
  
    	return null;
    	// TODO
    }

    public void addSong(Song s) {
      // TODO
    }

    public void updateSong(Song s) {
      // TODO
    }

    public void removeSong(Song s) {
       // TODO
    }
	

}
