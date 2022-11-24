package org.example.main;

import org.example.model.Song;
import org.example.model.Writer;
import org.example.repository.SongRepo;
import org.example.repository.WriterRepo;
import org.example.service.SongService;
import org.example.service.WriterService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        WriterService writerService = new WriterService(new WriterRepo());
        SongService songService = new SongService(new SongRepo());


        Writer taylor = new Writer("Taylor swift", 32, "American");
        Song willow = new Song("willow", "Taylor swift", "evermore", "chill",  "2021", taylor);
        Song cardigan = new Song("cardigan", "Taylor swift", "folklore", "chill", "2020", taylor);

        writerService.add(taylor);
        songService.add(willow);
        songService.add(cardigan);


        Writer writer = songService.getWriter(willow.getTitle());
        System.out.println(writer);
//        List<Song> songs = writerService.getSongs(taylor.getId());
//        songs.forEach(System.out::println);

    }
}
