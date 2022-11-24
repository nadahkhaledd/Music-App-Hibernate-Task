package org.example.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class RepoConfig {

    static StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

    static SessionFactory factory = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();
}
