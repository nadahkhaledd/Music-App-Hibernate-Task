package org.example.service;

import org.example.model.Song;
import org.example.model.Writer;
import org.example.repository.SongRepo;
import java.util.List;

public class SongService {

    SongRepo repo;

    public SongService(SongRepo repo) {
        this.repo = repo;
    }


    public List<Song> getAll(){
        return repo.getAllSongs();
    }

    public void add(Song song){
        repo.saveSong(song);
    }

    public void delete(String title){
        int result = repo.deleteSong(title);
        if(result == 1)
            System.out.println("Song deleted.");
    }

    public Song get(String title){
        return repo.getSong(title);
    }

    public Writer getWriter(String title){
        return repo.getSongWriter(title);
    }

}
