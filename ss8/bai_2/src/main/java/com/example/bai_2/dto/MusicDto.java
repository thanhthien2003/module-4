package com.example.bai_2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {
    @NotBlank(message = "Please enter your name!")
    @Max(value = 800,message = "Don't over 800 key")
    @Pattern(regexp = "^[\\w\\s]$", message = "Don't have  @ ; , . = - + ")
    private String name;
    @NotBlank(message = "Please enter your name!")
    @Max(value = 300,message = "Don't over 300 key")
    @Pattern(regexp = "^[\\w\\s]$", message = "Don't have  @ ; , . = - + ")
    private String singer;
    @NotBlank(message = "Please enter your name!")
    @Max(value = 1000,message = "Don't over 1000 key")
    @Pattern(regexp = "^([\\w\\d\\s]+[,]*)+$", message = "Don't have  @ ; , . = - + ")
    private String styleMusic;
    private boolean isFlagDelete;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
