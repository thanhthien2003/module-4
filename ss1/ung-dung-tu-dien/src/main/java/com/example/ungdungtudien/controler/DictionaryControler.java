package com.example.ungdungtudien.controler;

import com.example.ungdungtudien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryControler {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String startDictionary() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String displayDictionary(@RequestParam("word") String word, Model model) {
        model.addAttribute("result", dictionaryService.translate(word));
        return "index";
    }
}
