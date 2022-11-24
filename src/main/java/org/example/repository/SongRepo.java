package org.example.repository;

import org.example.model.Song;
import org.example.model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.example.repository.RepoConfig.factory;

public class SongRepo {

    public void saveSong(Song song){

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(song);
            tx.commit();
        }
    }


}
