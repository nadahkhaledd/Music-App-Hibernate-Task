package org.example.view;

import org.example.repository.SongRepo;
import org.example.repository.WriterRepo;
import org.example.service.SongService;
import org.example.service.WriterService;

public class Console {

    WriterService writerService = new WriterService(new WriterRepo());
    SongService songService = new SongService(new SongRepo());

    Menu menu = new Menu();

    public void start(){
        menu.showMenu();
    }
}
