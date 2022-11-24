package org.example.repository;

import org.example.model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import static org.example.repository.RepoConfig.factory;

public class WriterRepo {

    public void saveWriter(Writer writer){

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(writer);
            tx.commit();
        }
    }

    public int updateWriterAge(String name, int age){
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query=session.createQuery(
                    "update Writer w set w.creditscore=:creditscore where p.name=:name",
                    Writer.class
            );
            tx.commit();
        }
    }
}
