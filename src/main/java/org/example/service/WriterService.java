package org.example.service;

import org.example.model.Song;
import org.example.model.Writer;
import org.example.repository.WriterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService {

    WriterRepo repo;

    @Autowired
    public WriterService(WriterRepo repo) {
        this.repo = repo;
    }

    public List<Writer> getAll(){
        return repo.getAllWriters();
    }

    public void add(Writer writer){
        repo.saveWriter(writer);
    }

    public void delete(String name){
        int result = repo.deleteWriter(name);
        if(result == 1)
            System.out.println("Writer deleted.");
    }

    public Writer get(String name){
        return repo.getWriter(name);
    }

    public List<Song> getSongs(String name){
        return repo.getWriterSongs(name);
    }



}
