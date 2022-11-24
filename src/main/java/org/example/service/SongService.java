package org.example.service;

import org.example.model.Song;
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

    public void delete(int id){
        int result = repo.deleteSong(id);
        if(result == 1)
            System.out.println("Song deleted.");
    }

    public Song get(int id){
        return repo.getSong(id);
    }

}
