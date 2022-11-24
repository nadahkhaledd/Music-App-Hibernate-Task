package org.example.view;

import org.example.repository.SongRepo;
import org.example.repository.WriterRepo;
import org.example.service.SongService;
import org.example.service.WriterService;
import org.example.view.utility.Utils;

public class Console {

    private WriterService writerService;
    private SongService songService;

    private Menu menu;
    private Utils utils;

    public Console() {
        writerService = new WriterService(new WriterRepo());
        songService = new SongService(new SongRepo());
        menu = new Menu(writerService, songService);
        utils = new Utils();
    }

     public void start(){
        while (true){
            System.out.println("Welcome! Choose an option");
            menu.showMenu();
            int option = utils.getIntInput("");
            doOption(option);
        }
     }

     private void doOption(int option)
     {
         switch (option){

             case 1:
                 writerService.add(menu.addWriter());
                 break;

             case 2:
                 writerService.getAll().forEach(System.out::println);
                 break;

             case 3:
                 menu.showWriter();
                 break;

             case 4:
                 menu.deleteWriter();
                 break;

             case 5:
                 menu.showWriterSongs();
                 break;

             case 6:
                 songService.add(menu.addSong());
                 break;

             case 7:
                 songService.getAll().forEach(System.out::println);
                 break;

             case 8:
                 menu.showSong();
                 break;

             case 9:
                 menu.deleteSong();
                 break;

             case 10:
                 menu.showSongwriter();
                 break;

             case 13:
                 System.exit(0);
                 break;
             default: break;
         }
     }
}
