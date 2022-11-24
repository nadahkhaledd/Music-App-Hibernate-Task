package org.example.service;

import org.example.model.Song;
import org.example.model.Writer;
import org.example.repository.WriterRepo;

import java.awt.*;
import java.util.List;

public class WriterService {

    WriterRepo repo;

    public WriterService(WriterRepo repo) {
        this.repo = repo;
    }

    public List<Writer> getAll(){
        return repo.getAllWriters();
    }

    public void add(Writer writer){
        repo.saveWriter(writer);
    }

    public void delete(int id){
        int result = repo.deleteWriter(id);
        if(result == 1)
            System.out.println("Writer deleted.");
    }

    public Writer get(int id){
        return repo.getWriter(id);
    }

    public List<Song> getSongs(int id){
        return repo.getWriterSongs(id);
    }



}
