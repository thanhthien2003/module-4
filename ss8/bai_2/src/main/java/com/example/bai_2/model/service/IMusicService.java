package com.example.bai_2.model.service;

import com.example.bai_2.model.model.Music;

import java.util.List;

public interface IMusicService {
 List<Music> getList();
 void create(Music music);
 void delete(Music music);
 void update(Music music);
 Music findById(Integer id);
}
