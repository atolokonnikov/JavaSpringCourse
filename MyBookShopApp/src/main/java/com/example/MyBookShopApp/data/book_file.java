package com.example.MyBookShopApp.data;

import javax.persistence.*;

@Entity
@Table
public class book_file {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String hash;
    @Column(nullable = false)
    private Integer type_id;
    @Column(nullable = false)
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "book_file{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", type_id=" + type_id +
                ", path='" + path + '\'' +
                '}';
    }
}
