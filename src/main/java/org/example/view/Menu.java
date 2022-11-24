//package org.example.view;
//
//import org.example.model.Song;
//import org.example.model.Writer;
//import org.example.service.SongService;
//import org.example.service.WriterService;
//import org.example.view.utility.Utils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//
//public class Menu {
//
//    static List<String> menuOptions;
////    private WriterService writerService;
////    private SongService songService;
//    private Utils utils = new Utils();
//
//    public Menu(WriterService writerService, SongService songService) {
//        writerService = writerService;
//        songService = songService;
//        //utils = new Utils();
//
//    }
//
//    static {
//        menuOptions = new ArrayList<>(Arrays.asList("1. add writer", "2. show all writers", "3. show a writer by name",
//                "4. delete writer", "5. show writer songs", "6. add song", "7. show all songs",
//                "8. show a song by name", "9. delete song", "10. show songwriter",
//                "11. update writer", "12. update song", "13. Exit"));
//    }
//
//     void showMenu(){
//        menuOptions.forEach(System.out::println);
//    }
//
//    public Writer addWriter(){
//        System.out.println("Enter writer data");
//        String name = utils.getStringInput("Enter writer's name");
//        int age = utils.getIntInput("Enter writer's age");
//        String nationality = utils.getStringInput("Enter writer's nationality");
//
//        return new Writer(name, age, nationality);
//    }
//
//    public Song addSong(){
//        System.out.println("Enter song data");
//        String title = utils.getStringInput("Enter title of song");
//        String artist = utils.getStringInput("Enter artist of the song");
//        String album = utils.getStringInput("Enter album name of the song");
//        String genre = utils.getStringInput("Enter song's genre");
//        String year = utils.getStringInput("Enter release year of the song");
//
//
//        String writerName = utils.getStringInput("Enter writer's name");
//        Writer writer = writerService.get(writerName);
//        while (writer== null){
//            System.err.println("writer name invalid! try again");
//            writerName = utils.getStringInput("Enter writer's name");
//            writer = writerService.get(writerName);
//        }
//        return new Song(title, artist, album, genre, year, writer);
//    }
//
//    void showWriter(){
//        String name = utils.getStringInput("Enter writer name");
//        Writer writer = writerService.get(name);
//        if(writer!=null)
//            System.out.println(writer);
//        else System.out.println("No writer found with that name!");
//    }
//
//    void deleteWriter(){
//        String name = utils.getStringInput("Enter writer name to delete");
//        writerService.delete(name);
//    }
//
//    void showWriterSongs(){
//        String name = utils.getStringInput("Enter writer name");
//        List<Song> songs =    writerService.getSongs(name);
//        if(songs.isEmpty())
//            System.out.println("No songs found for that writer");
//        else
//            songs.forEach(System.out::println);
//    }
//
//    void showSong(){
//        String title = utils.getStringInput("Enter song name");
//        Song song = songService.get(title);
//        if(song!=null)
//            System.out.println(song);
//        else System.out.println("No songs found with that title!");
//    }
//
//    void deleteSong(){
//        String title = utils.getStringInput("Enter song name to delete");
//        songService.delete(title);
//    }
//
//    void showSongwriter(){
//        String title = utils.getStringInput("Enter song name");
//        System.out.println(songService.getWriter(title));
//    }
//
//
//
//}
