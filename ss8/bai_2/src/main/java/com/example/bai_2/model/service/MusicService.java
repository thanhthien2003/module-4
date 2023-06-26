package com.example.bai_2.model.service;

import com.example.bai_2.model.model.Music;
import com.example.bai_2.model.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
@Autowired
    IMusicRepository musicRepository;
    @Override
    public List<Music> getList() {
        return musicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(Music music) {

    }

    @Override
    public void update(Music music) {

    }

    @Override
    public Music findById(Integer id) {
        return null;
    }
}
