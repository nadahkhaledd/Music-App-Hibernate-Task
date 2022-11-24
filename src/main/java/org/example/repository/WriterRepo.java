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
public class WriterRepo {

    @Autowired
    Config config;

    public List<Writer> getAllWriters(){
        List<Writer> writers;

        try (Session session = config.getFactory().openSession()) {
            writers = session.createQuery("from Writer", Writer.class)
                    .list();
        }

        return writers;
    }

    public Writer getWriter(String name){
        Writer writer;
        try (Session session = config.getFactory().openSession()) {
            writer  = session.createQuery("from Writer w where w.name=:name ", Writer.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
        return writer;
    }

    public void saveWriter(Writer writer){

        try (Session session = config.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(writer);
            tx.commit();
        }
    }

    public int updateWriter(int id, String name, int age, String nationality){
        int results;
        try (Session session = config.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "update Writer w set w.name=:name, w.age=:age, w.nationality=:nationality" +
                            " where w.id=:id",
                    Writer.class
            );
            query.setParameter("name", name);
            query.setParameter("age", age);
            query.setParameter("nationality", nationality);
            query.setParameter("id", id);
            results = query.executeUpdate();
            tx.commit();
        }
        return results;
    }

    public int deleteWriter(String name){
        int results;
        try (Session session = config.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "delete from Writer w where w.name=:name",
                    Writer.class
            );
            query.setParameter("name", name);
            results = query.executeUpdate();
            tx.commit();
        }
        return results;
    }

    public List<Song> getWriterSongs(String name){
        List<Song> songs;
        try (Session session = config.getFactory().openSession()) {
            songs  = session.createQuery("from Song s where s.writer.name=:name ", Song.class)
                    .setParameter("name", name)
                    .list();
        }
        return songs;
    }

}
