package org.example.repository;

import org.example.model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static org.example.repository.RepoConfig.factory;

public class WriterRepo {

    public List<Writer> getAllWriters(){
        List<Writer> writers;

        try (Session session = factory.openSession()) {
            writers = session.createQuery("from Writer", Writer.class)
                    .list();
        }

        return writers;
    }

    public Writer getWriter(int id){
        Writer writer;
        try (Session session = factory.openSession()) {
            writer  = session.createQuery("from Writer w where w.id=:id ", Writer.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        return writer;
    }

    public void saveWriter(Writer writer){

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(writer);
            tx.commit();
        }
    }

    public int updateWriter(int id, String name, int age, String nationality){
        int results;
        try (Session session = factory.openSession()) {
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

    public int deleteWriter(int id){
        int results;
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "delete from Writer w where w.id=:id",
                    Writer.class
            );
            query.setParameter("id", id);
            results = query.executeUpdate();
            tx.commit();
        }
        return results;
    }

}
