package com.example.bai_2.model.model;

import jakarta.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String singer;
    private String styleMusic;
    private boolean isFlagDelete;

    public Music() {
    }

    public Music(String name, String singer, String styleMusic, boolean isFlagDelete) {
        this.name = name;
        this.singer = singer;
        this.styleMusic = styleMusic;
        this.isFlagDelete = isFlagDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getStyleMusic() {
        return styleMusic;
    }

    public void setStyleMusic(String styleMusic) {
        this.styleMusic = styleMusic;
    }

    public boolean isFlagDelete() {
        return isFlagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        isFlagDelete = flagDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
