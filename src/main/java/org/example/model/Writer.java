package org.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String name;
    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 50)
    private String nationality;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private Set<Song> songs;


    public Writer() {
    }

    public Writer(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.songs = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return String.format("\n-------------------------------------------\nWriter\n" +
                        "Name: %s\t\tage: %s\t\tnationality: %s\n" +
                        "-------------------------------------------",
                name, age, nationality);
    }
}
