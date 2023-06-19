package com.example.ungdungtudien.service;

import com.example.ungdungtudien.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository dictionaryRepository;
    @Override
    public String translate(String string) {
        String wordLCase = string.toLowerCase();
        String result = "Our dictionary is still under re so we don't have this word yet";
        Map<String, String> library = dictionaryRepository.getLibrary();
        for (String s : library.keySet()) {
            if (s.equals(wordLCase)) {
                result = library.get(s);
                break;
            }
        }
        return result;
    }
}
