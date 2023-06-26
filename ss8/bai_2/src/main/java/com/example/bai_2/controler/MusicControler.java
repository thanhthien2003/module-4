package com.example.bai_2.controler;

import com.example.bai_2.dto.MusicDto;
import com.example.bai_2.model.model.Music;
import com.example.bai_2.model.service.IMusicService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicControler {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("musicList", musicService.getList());
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (musicService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "Id not found");
            return "redirect:/";
        } else {
            musicService.delete(musicService.findById(id));
            redirectAttributes.addFlashAttribute("msg", "Delete success");
        }
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        MusicDto musicDto = new MusicDto();
        model.addAttribute("musicDto", musicDto);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.create(music);
        redirectAttributes.addFlashAttribute("msg", "Create success");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (musicService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "Id not found");
            return "redirect:/";
        }
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(musicService.findById(id), musicDto);
        model.addAttribute("musicDto", musicDto);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "update";
        }
        if (musicService.findById(musicDto.getId()) == null) {
            model.addAttribute("musicDto", musicDto);
            return "update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.update(music);
        redirectAttributes.addFlashAttribute("msg", "update success");
        return "redirect:";
    }
}
