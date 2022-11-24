package org.example.repository;

import org.example.model.Song;
import org.example.model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static org.example.repository.RepoConfig.factory;

public class SongRepo {

    public void saveSong(Song song){

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(song);
            tx.commit();
        }
    }

    public List<Song> getAllSongs(){
        List<Song> songs;

        try (Session session = factory.openSession()) {
            songs = session.createQuery("from Song", Song.class)
                    .list();
        }

        return songs;
    }

    public Song getSong(int id) {
        Song song;
        try (Session session = factory.openSession()) {
            song = session.createQuery("from Song s where s.id=:id ", Song.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        return song;
    }

    public int updateSong(int id, String title, String artist,
                          String album, String genre, String yearRelease){
        int results;
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "update Song s set s.title=:title, s.artist=:artist, s.album=:album," +
                            " s.genre=:genre, s.yearRelease=:yearRelease" +
                            " where w.id=:id",
                    Writer.class
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

    public int deleteSong(int id){
        int results;
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "delete from Song s where s.id=:id",
                    Song.class
            );
            query.setParameter("id", id);
            results = query.executeUpdate();
            tx.commit();
        }
        return results;
    }


}
