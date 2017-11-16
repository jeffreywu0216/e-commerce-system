package com.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALBUM")  //don't need name if is the same with the class name, but still need @Table
public class ChinookAlbum {

    private Integer id;
    private String title;
    private Integer artist;

    public ChinookAlbum() {}

    @Id
    @Column(name="ALBUMID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column     //no need name, since name is the the same as the db column name
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="ARTISTID")
    public Integer getArtist() {
        return artist;
    }

    public void setArtist(Integer artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "ChinookAlbum{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                '}';
    }
}
