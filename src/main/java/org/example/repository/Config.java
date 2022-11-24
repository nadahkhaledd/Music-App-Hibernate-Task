package org.example.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Config {

     private SessionFactory factory;

     public Config() {

     }

     public SessionFactory getFactory() {
          return factory;
     }

     @Autowired
     public void setFactory(SessionFactory factory) {
          this.factory = factory;
     }
}
