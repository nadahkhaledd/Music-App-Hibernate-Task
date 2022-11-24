package org.example.repository;

import org.example.model.Song;
import org.example.model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SongRepo {

    @Autowired
    Config config;

    public void saveSong(Song song){

        try (Session session = config.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(song);
            tx.commit();
        }
    }

    public List<Song> getAllSongs(){
        List<Song> songs;

        try (Session session = config.getFactory().openSession()) {
            songs = session.createQuery("from Song", Song.class)
                    .list();
        }

        return songs;
    }

    public Song getSong(String title) {
        Song song;
        try (Session session = config.getFactory().openSession()) {
            song = session.createQuery("from Song s where s.title=:title ", Song.class)
                    .setParameter("title", title)
                    .getSingleResult();
        }
        return song;
    }

    public int updateSong(int id, String title, String artist,
                          String album, String genre, String yearRelease){
        int results;
        try (Session session = config.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "update Song s set s.title=:title, s.artist=:artist, s.album=:album," +
                            " s.genre=:genre, s.yearRelease=:yearRelease" +
                            " where w.id=:id",
                    Song.class
            );
            query.setParameter("title", title)
                    .setParameter("artist", artist)
                    .setParameter("album", album)
                    .setParameter("genre", genre)
                    .setParameter("yearRelease", yearRelease);
            query.setParameter("id", id);
            results = query.executeUpdate();
            tx.commit();
        }
        return results;
    }

    public int deleteSong(String title){
        int results;
        try (Session session = config.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "delete from Song s where s.title=:title",
                    Song.class
            );
            query.setParameter("title", title);
            results = query.executeUpdate();
            tx.commit();
        }
        return results;
    }

    public Writer getSongWriter(String title){
        Writer writer;
        try (Session session = config.getFactory().openSession()) {
            writer  = session.createQuery("from Song s where s.title=:title ", Song.class)
                    .setParameter("title", title)
                    .getSingleResult().getWriter();
        }
        return writer;
    }


}
